package project.courier.presentation;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewOfficeForm implements Initializable {
    public ComboBox CompanyName;
    public TextField OfficeCity;

    public void NewOffice(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CompanyName.getItems().addAll(FXCollections.observableArrayList("Letter", "Parcel", "Package", "Cargo"));
    }

    public void CancelAction(ActionEvent actionEvent) {
    }
}
