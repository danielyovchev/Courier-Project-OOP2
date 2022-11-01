package project.courier.presentation;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CourierController  {
 private  Parent root;
    @FXML
    public ComboBox<String> comboBox ;
    public void newClientClick(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewClientForm.fxml"));
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Client registration form");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");

        }
    }


    public void newShipmentClick(ActionEvent actionEvent)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewShipmentForm.fxml"));
            root =  fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Shipment registration form");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println("Error");

        }
    }


    public void RegisterClient(ActionEvent actionEvent)
    {
        
    }
}
