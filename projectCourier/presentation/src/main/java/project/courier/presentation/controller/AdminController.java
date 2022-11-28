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
    private Parent root;
    @FXML
    private MenuItem regCompany;

    public void openCompanyRegForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewCompanyForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }

}
