package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.services.AddUserInjector;
import project.courier.presentation.services.AddUserInjectorImpl;
import project.courier.presentation.services.CourierRegisterInjector;
import project.courier.presentation.services.CourierRegisterInjectorImpl;
import project.courier.service.services.company.CompanyProviderImpl;
import project.courier.service.services.user.GetUserIdImpl;
import project.courier.service.exceptions.UserExistsException;
import project.courier.service.services.company.CompanyProvider;
import project.courier.service.services.user.GetUserId;
import project.courier.service.model.CourierModel;
import project.courier.service.model.UserModel;

import java.net.URL;
import java.util.ResourceBundle;

public class NewCourierController implements Initializable {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private ComboBox<String> companies;
    @FXML
    private Button closeBtn;
    @FXML
    public void registerCourier(){
        if(firstName.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing first name!");
            return;
        }
        if(lastName.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing last name!");
            return;
        }
        if(email.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing email!");
            return;
        }
        if(password.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing password!");
            return;
        }
        if(username.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing username!");
            return;
        }
        if(companies.getValue() == null){
            showAlert(Alert.AlertType.WARNING,"No company defined");
            return;
        }
        final GetUserId getUserId = new GetUserIdImpl();
        final CourierRegisterInjector injector = new CourierRegisterInjectorImpl();
        final AddUserInjector addUserInjector = new AddUserInjectorImpl();
        final UserModel userModel = new UserModel();
        userModel.setFirstName(firstName.getText());
        userModel.setLastName(lastName.getText());
        userModel.setEmail(email.getText());
        userModel.setPassword(password.getText());
        userModel.setUsername(username.getText());
        userModel.setType("Courier");
        try {
            addUserInjector.getService().addUser(userModel);
        } catch (UserExistsException e){
            showAlert(Alert.AlertType.WARNING,"User already exists");
            return;
        }
        final CourierModel courierModel = new CourierModel();
        courierModel.setId(getUserId.getId(userModel.getUsername()));
        courierModel.setFirstName(firstName.getText());
        courierModel.setLastName(lastName.getText());
        courierModel.setEmail(email.getText());
        courierModel.setUsername(username.getText());
        courierModel.setCompany((String) companies.getValue());
        injector.register().addCourier(courierModel);
        showAlert(Alert.AlertType.CONFIRMATION, "Courier registered");
    }
    private void showAlert(Alert.AlertType alertType, String message){
        Alert alert = new Alert(alertType, message);
        alert.show();
    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        companyProvider.getNames().forEach(e -> companies.getItems().add(e));
    }
}
