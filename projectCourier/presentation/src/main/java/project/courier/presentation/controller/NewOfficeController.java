package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.service.GetAllCompaniesImpl;
import project.courier.service.interfaces.GetAllCompanies;

import java.net.URL;
import java.util.ResourceBundle;

public class NewOfficeController implements Initializable {
    @FXML
    private TextField officeCity;
    @FXML
    private ComboBox<String> companyName;
    @FXML
    private Button closeBtn;
    @FXML
    public void registerOffice(){

    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final GetAllCompanies getAllCompanies = new GetAllCompaniesImpl();
        getAllCompanies.getNames().forEach(e -> companyName.getItems().add(e));
    }
}
