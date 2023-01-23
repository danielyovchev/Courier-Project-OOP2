package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.model.CompanyTableModel;

import java.time.LocalDate;

public class AdminCompanyStatistics{
    @FXML
    private TableView<CompanyTableModel> CompanyTable = new TableView<>();
    @FXML
    private TableColumn<CompanyTableModel, String> companyName = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, Integer> CompanyShipments = new TableColumn<>();
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private CheckBox periodCheck;

    private ObservableList<CompanyTableModel> companyIdList() {
        final CompanyProvider companyProvider = new CompanyProviderImpl();
        return FXCollections.observableList(companyProvider.getDeliveriesByCompany().stream().toList());
    }
    private ObservableList<CompanyTableModel> companyBetweenDatesSalesList(LocalDate date1, LocalDate date2) {
        final CompanyProvider companyProvider = new CompanyProviderImpl();
        return FXCollections.observableList(companyProvider.getDeliveriesByCompanyBetweenDates(date1, date2).stream().toList());
    }

    private void displayCompanyTable() {
        ObservableList<CompanyTableModel> companyModels = companyIdList();
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        CompanyShipments.setCellValueFactory(new PropertyValueFactory<>("shipmentCount"));
        CompanyTable.setItems(companyModels);
    }

    private void displayCompaniesBetweenDates(LocalDate date1, LocalDate date2){
        ObservableList<CompanyTableModel> companyModels = companyBetweenDatesSalesList(date1, date2);
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        CompanyShipments.setCellValueFactory(new PropertyValueFactory<>("shipmentCount"));
        CompanyTable.setItems(companyModels);
    }

    public void ShowStatisticsButton(ActionEvent actionEvent) {
        if(periodCheck.isSelected()){
            if(fromDate.getValue() == null || toDate.getValue() == null){
                showAlert("No dates chosen");
                return;
            }
            displayCompaniesBetweenDates(fromDate.getValue(), toDate.getValue());
        }
        else {
            displayCompanyTable();
        }
    }
    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING, message);
        alert.show();
    }
}
