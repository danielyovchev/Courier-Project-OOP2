package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.services.AddOfficeInjector;
import project.courier.presentation.services.AddOfficeInjectorImpl;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.model.OfficeModel;

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
        if(officeCity.getText().isEmpty()){
            showAlert("No city defined");
            return;
        }
        if(companyName.getValue() == null){
            showAlert("No company chosen");
            return;
        }
        final AddOfficeInjector officeInjector = new AddOfficeInjectorImpl();
        final OfficeModel officeModel = new OfficeModel();
        officeModel.setCity(officeCity.getText());
        officeModel.setCompany((String) companyName.getValue());
        officeInjector.addOffice().addOffice(officeModel);
    }
    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.show();
    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        companyProvider.getNames().forEach(e -> companyName.getItems().add(e));
    }
}
