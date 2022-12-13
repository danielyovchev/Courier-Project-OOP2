package project.courier.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import project.courier.presentation.services.AddUserInjector;
import project.courier.presentation.services.AddUserInjectorImpl;
import project.courier.presentation.services.CourierRegisterInjector;
import project.courier.presentation.services.CourierRegisterInjectorImpl;
import project.courier.service.GetAllCompaniesImpl;
import project.courier.service.interfaces.GetAllCompanies;
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
//    @FXML
//    public void showBox(ActionEvent event){
//        final GetAllCompanies getAllCompanies = new GetAllCompaniesImpl();
//        getAllCompanies.getNames().forEach(e -> companies.getItems().add(e));
//        companies.show();
//        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//        HBox hBox = new HBox(companies);
//        Scene scene = new Scene(hBox);
//        stage.setScene(scene);
//        stage.show();
//    }
    @FXML
    public void registerCourier(){
        final CourierRegisterInjector injector = new CourierRegisterInjectorImpl();
        final AddUserInjector addUserInjector = new AddUserInjectorImpl();
        final UserModel userModel = new UserModel();
        userModel.setFirstName(firstName.getText());
        userModel.setLastName(lastName.getText());
        userModel.setEmail(email.getText());
        userModel.setPassword(password.getText());
        userModel.setUsername(username.getText());
        userModel.setType("Courier");
        addUserInjector.getService().addUser(userModel);
        final CourierModel courierModel = new CourierModel();
        courierModel.setFirstName(firstName.getText());
        courierModel.setLastName(lastName.getText());
        courierModel.setEmail(email.getText());
        courierModel.setCompany((String) companies.getValue());
        injector.register().addCourier(courierModel);
    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final GetAllCompanies getAllCompanies = new GetAllCompaniesImpl();
        getAllCompanies.getNames().forEach(e -> companies.getItems().add(e));
    }
}
