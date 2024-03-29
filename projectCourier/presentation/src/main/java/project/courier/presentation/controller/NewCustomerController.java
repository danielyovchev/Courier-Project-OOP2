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
import project.courier.service.services.company.CompanyProviderImpl;
import project.courier.service.services.user.GetUserIdImpl;
import project.courier.service.exceptions.UserExistsException;
import project.courier.service.services.company.CompanyProvider;
import project.courier.service.services.user.GetUserId;
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
    private final GetUserId getUserId = new GetUserIdImpl();
    private final CustomerRegisterInjector customerRegisterInjector = new CustomerRegisterInjectorImpl();
    private final CompanyProvider companyProvider = new CompanyProviderImpl();
    private final AddUserInjector addUserInjector = new AddUserInjectorImpl();
    @FXML
    public void registerCustomer(){
        if(firstName.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING, "Missing first name!");
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
        if(phone.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing phone");
            return;
        }

        final UserModel userModel = new UserModel();
        userModel.setFirstName(firstName.getText());
        userModel.setLastName(lastName.getText());
        userModel.setEmail(email.getText());
        userModel.setPassword(password.getText());
        userModel.setUsername(username.getText());
        userModel.setType("Customer");
        try {
            addUserInjector.getService().addUser(userModel);
        } catch (UserExistsException e){
            showAlert(Alert.AlertType.WARNING,"User already exists");
            return;
        }
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerId(getUserId.getId(userModel.getUsername()));
        customerModel.setFirstName(firstName.getText());
        customerModel.setLastName(lastName.getText());
        customerModel.setEmail(email.getText());
        customerModel.setPhone(phone.getText());
        customerModel.setCompany(companyProvider.getCompanyFromCourier(CurrentUser.username));
        customerRegisterInjector.getService().registerCustomer(customerModel);
        showAlert(Alert.AlertType.CONFIRMATION, "Customer registered");
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
}
