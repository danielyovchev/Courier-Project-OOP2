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
import project.courier.service.CompanyProviderImpl;
import project.courier.service.GetUserIdImpl;
import project.courier.service.exceptions.UserExistsException;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.GetUserId;
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
            showAlert("Missing first name!");
            return;
        }
        if(lastName.getText().isEmpty()){
            showAlert("Missing last name!");
            return;
        }
        if(email.getText().isEmpty()){
            showAlert("Missing email!");
            return;
        }
        if(password.getText().isEmpty()){
            showAlert("Missing password!");
            return;
        }
        if(username.getText().isEmpty()){
            showAlert("Missing username!");
            return;
        }
        if(companies.getValue() == null){
            showAlert("No company defined");
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
            showAlert("User already exists");
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
    }
    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING, message);
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
