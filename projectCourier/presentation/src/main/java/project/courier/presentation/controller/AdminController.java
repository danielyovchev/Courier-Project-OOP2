package project.courier.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    private NewCompanyController newCompanyController;
    @FXML
    private NewCourierController newCourierController;
    @FXML
    private NewCustomerController newCustomerController;
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
    public void openCourierRegForm(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewCourierForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openCustomerRegForm(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewClientForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
}
