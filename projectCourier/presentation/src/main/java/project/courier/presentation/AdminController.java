package project.courier.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminController {
    private Parent root;
    public void NewCourierMenu(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewCourierForm.fxml"));
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Client registration form");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");

        }
    }

    public void NewOfficeMenu(ActionEvent actionEvent)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewOfficeForm.fxml"));
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Client registration form");
            stage.setScene(new Scene(root, 350, 250));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");

        }
    }

    public void NewCompanyMenu(ActionEvent actionEvent)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewCompanyForm.fxml"));
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Client registration form");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");

        }
    }
}
