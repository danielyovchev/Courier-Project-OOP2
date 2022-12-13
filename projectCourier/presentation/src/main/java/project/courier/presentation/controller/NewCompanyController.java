package project.courier.presentation.controller;


import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.services.CompanyRegisterInjector;
import project.courier.presentation.services.CompanyRegisterInjectorImpl;
import project.courier.service.model.CompanyModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewCompanyController implements Initializable {
    @FXML
    private TextField companyName;
    @FXML
    private TextField bulstat;
    @FXML
    private Button closeButton;
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
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
