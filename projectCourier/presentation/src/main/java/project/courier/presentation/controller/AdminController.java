package project.courier.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import project.courier.presentation.HelloApplication;
import project.courier.presentation.logConstants.CurrentUser;

import java.io.IOException;

public class AdminController {
    @FXML
    private Button logOutBtn;
    @FXML
    private NewCompanyController newCompanyController;
    @FXML
    private NewCourierController newCourierController;
    @FXML
    private NewCustomerController newCustomerController;
    @FXML
    private AdminStatistics adminStatistics;
    @FXML
    public void openCompanyRegForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewCompanyForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openOfficeRegForm() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewOfficeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openCourierRegForm(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewCourierForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void logOut() throws IOException{
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/project/courier/presentation/Login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        CurrentUser.role="none";
    }
    @FXML
    public void showStatistics(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Admin-statistics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
}
