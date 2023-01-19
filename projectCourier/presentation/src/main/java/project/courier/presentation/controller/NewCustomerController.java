package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.presentation.services.AddUserInjector;
import project.courier.presentation.services.AddUserInjectorImpl;
import project.courier.presentation.services.CustomerRegisterInjector;
import project.courier.presentation.services.CustomerRegisterInjectorImpl;
import project.courier.service.GetAllCompaniesImpl;
import project.courier.service.interfaces.GetAllCompanies;
import project.courier.service.model.CustomerModel;
import project.courier.service.model.UserModel;

public class NewCustomerController {
    @FXML
    private Button closeBtn;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField phone;
    @FXML
    private TextField username;
    @FXML
    public void registerCustomer(){
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
        if(phone.getText().isEmpty()){
            showAlert("Missing phone");
            return;
        }
        final CustomerRegisterInjector customerRegisterInjector = new CustomerRegisterInjectorImpl();
        final GetAllCompanies getAllCompanies = new GetAllCompaniesImpl();
        final AddUserInjector addUserInjector = new AddUserInjectorImpl();
        CustomerModel customerModel = new CustomerModel();
        customerModel.setFirstName(firstName.getText());
        customerModel.setLastName(lastName.getText());
        customerModel.setEmail(email.getText());
        customerModel.setPhone(phone.getText());
        customerModel.setCompany(getAllCompanies.getCompanyFromCourier(CurrentUser.username));
        customerRegisterInjector.getService().registerCustomer(customerModel);
        final UserModel userModel = new UserModel();
        userModel.setFirstName(firstName.getText());
        userModel.setLastName(lastName.getText());
        userModel.setEmail(email.getText());
        userModel.setPassword(password.getText());
        userModel.setUsername(username.getText());
        userModel.setType("Customer");
        addUserInjector.getService().addUser(userModel);
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
}
