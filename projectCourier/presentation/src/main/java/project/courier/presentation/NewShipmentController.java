package project.courier.presentation;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class NewShipmentController implements Initializable
{


    public ComboBox comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        comboBox.getItems().addAll(FXCollections.observableArrayList("Letter", "Parcel", "Package", "Cargo"));
    }
}
