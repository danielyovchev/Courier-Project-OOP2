package project.courier.presentation.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.services.CompanyRegisterInjector;
import project.courier.presentation.services.CompanyRegisterInjectorImpl;
import project.courier.service.model.CompanyModel;

public class NewCompanyController {
    @FXML
    private TextField companyName;
    @FXML
    private TextField bulstat;
    @FXML
    private Button closeButton;
    @FXML
    public void registerCompany(){
        if(companyName.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING, "No company name entered!");
            alert.show();
            return;
        }
        if(bulstat.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING, "No bulstat entered!");
            alert.show();
            return;
        }
        final CompanyRegisterInjector injector = new CompanyRegisterInjectorImpl();
        final CompanyModel companyModel = new CompanyModel(companyName.getText(), bulstat.getText());
        injector.register().addCompany(companyModel);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Success");
        alert.show();
    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
