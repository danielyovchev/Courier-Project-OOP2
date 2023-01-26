package project.courier.presentation.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.services.CompanyRegisterInjector;
import project.courier.presentation.services.CompanyRegisterInjectorImpl;
import project.courier.service.exceptions.CompanyExistsException;
import project.courier.service.model.CompanyModel;

public class NewCompanyController {
    @FXML
    private TextField companyName;
    @FXML
    private TextField bulstat;
    @FXML
    private Button closeButton;
    private final CompanyRegisterInjector injector = new CompanyRegisterInjectorImpl();
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
        final CompanyModel companyModel = new CompanyModel(companyName.getText(), bulstat.getText());
        try {
            injector.register().addCompany(companyModel);
            showAlert(Alert.AlertType.CONFIRMATION, "Company registered");
        } catch (CompanyExistsException e){
            showAlert(Alert.AlertType.WARNING,"Company already exists");
        }

    }
    private void showAlert(Alert.AlertType alertType, String message){
        Alert alert = new Alert(alertType, message);
        alert.show();
    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
