package project.courier.presentation.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import project.courier.presentation.services.CompanyRegisterInjector;
import project.courier.presentation.services.CompanyRegisterInjectorImpl;
import project.courier.service.model.CompanyModel;

public class NewCompanyController {
    @FXML
    private TextField companyName;
    @FXML
    private TextField bulstat;
    @FXML
    public void registerCompany(){
        final CompanyRegisterInjector injector = new CompanyRegisterInjectorImpl();
        final CompanyModel companyModel = new CompanyModel(companyName.getText(), bulstat.getText());
        injector.register().addCompany(companyModel);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Success");
        alert.show();
    }
    @FXML
    public void closeForm(){
        
    }
}
