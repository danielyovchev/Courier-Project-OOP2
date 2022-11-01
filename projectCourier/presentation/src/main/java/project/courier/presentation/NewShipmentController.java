package project.courier.presentation;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class NewShipmentController implements Initializable
{
    @FXML
    private ComboBox <String> comboBox ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        comboBox.setItems(FXCollections.observableArrayList("Letter", "Parcel", "Package", "Cargo"));
    }
}
