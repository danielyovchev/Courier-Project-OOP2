package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.presentation.services.LoginUserInjector;
import project.courier.service.LoginUserImpl;

public class LoginController {
    @FXML
    private TextField textFieldUsername;
    @FXML
    private PasswordField passFieldPassword;
    @FXML
    private void onLoginClick(){
        final LoginUserInjector loginUserInjector = LoginUserImpl::new;
        final String username = textFieldUsername.getText();
        final String password = passFieldPassword.getText();
        final String role = loginUserInjector.getLogin().checkLogin(username, password);
        try {
            if (role.equals("admin")) {
                CurrentUser.role="admin";
                CurrentUser.username=username;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Admin-main-page.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Admin");
                stage.setScene(scene);
                stage.show();
            } else if (role.equals("courier")) {
                CurrentUser.role="courier";
                CurrentUser.username=username;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Courier-main-page.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 450);
                Stage stage = new Stage();
                stage.setTitle("Courier");
                stage.setScene(scene);
                stage.show();
            } else if (role.equals("customer")) {
                CurrentUser.role="customer";
                CurrentUser.username=username;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Client-main-page.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 450);
                Stage stage = new Stage();
                stage.setTitle("Customer");
                stage.setScene(scene);
                stage.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR, role);
                alert.show();
            }
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Internal Server Error");
        }
    }
}
