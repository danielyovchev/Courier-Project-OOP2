package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewShipmentController {
    @FXML
    private Button closeBtn;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField city;
    @FXML
    private DatePicker sentDate;
    @FXML
    private ComboBox<String> officeList;
    @FXML
    private ComboBox<String> typeList;
    @FXML
    public void registerShipment(){}
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
