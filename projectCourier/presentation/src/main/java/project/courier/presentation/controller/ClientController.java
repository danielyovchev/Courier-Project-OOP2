package project.courier.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import project.courier.presentation.HelloApplication;
import project.courier.presentation.logConstants.CurrentUser;

import java.io.IOException;

public class ClientController{
    @FXML
    private Button logOutBtn;

    @FXML
    public void logOut() throws IOException {
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/project/courier/presentation/Login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        CurrentUser.role="none";
    }

    public void showShipmentCheck(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/CustomerShipmentCheck.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void showReferences(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/CustomerShipmentReference.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void openReceiveWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/project/courier/presentation/Client-receive-shipments.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Customer");
        stage.setScene(scene);
        stage.show();
    }
}
