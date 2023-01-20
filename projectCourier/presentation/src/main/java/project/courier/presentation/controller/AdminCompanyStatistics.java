package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.model.CompanyTableModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminCompanyStatistics implements Initializable {
    @FXML
    private TableView<CompanyTableModel> CompanyTable = new TableView<>();
    @FXML
    private TableColumn<CompanyTableModel, String> companyName = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, Integer> CompanyShipments = new TableColumn<>();
    @FXML
    private DatePicker fromDate = new DatePicker();
    @FXML
    private DatePicker tomDate = new DatePicker();
    @FXML
    private CheckBox periodCheck= new CheckBox();
    @FXML
    private Button showButton = new Button();

    private ObservableList<CompanyTableModel> companyIdList()
    {
        final CompanyProvider companyProvider = new CompanyProviderImpl();
        return FXCollections.observableList(companyProvider.getAllCompanies().stream().toList());
    }
    private void displayCompanyTable()
    {
        ObservableList<CompanyTableModel> companyModels = companyIdList();
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        CompanyShipments.setCellValueFactory(new PropertyValueFactory<>("shipmentCount"));
        CompanyTable.setItems(companyModels);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void ShowStatisticsButton(ActionEvent actionEvent)
    {
        displayCompanyTable();
    }
}
