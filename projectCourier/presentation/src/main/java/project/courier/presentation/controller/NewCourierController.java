package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.services.AddUserInjector;
import project.courier.presentation.services.AddUserInjectorImpl;
import project.courier.presentation.services.CourierRegisterInjector;
import project.courier.presentation.services.CourierRegisterInjectorImpl;
import project.courier.service.model.CourierModel;
import project.courier.service.model.UserModel;

public class NewCourierController {
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
    private Button closeBtn;
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
        courierModel.setCompany("");
        injector.register().addCourier(courierModel);
    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
