package project.courier.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
    public void openCompanyRegForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewCompanyForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openOfficeRegForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewOfficeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openCourierRegForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewCourierForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void logOut() throws IOException {
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
        CurrentUser.role="none";
        CurrentUser.username="";
    }

    public void openCustomerRegForm(ActionEvent actionEvent) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/NewClientForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Admin");
            stage.setScene(scene);
            stage.show();
        }

    public void showCompaniesStatistics(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Admin-company-statistics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }

    public void showCustomerStatistics(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Admin-customer-statistics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
    public void showCourierStatistics(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Admin-courier-statistics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();
    }
}

