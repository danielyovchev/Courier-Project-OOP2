package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.CustomerProviderImpl;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.CustomerProvider;
import project.courier.service.model.CustomerTableModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminCustomerStatistics implements Initializable {

    @FXML
    private ComboBox<String> companyNames = new ComboBox<>();
    @FXML
    private TableView<CustomerTableModel> clientTable = new TableView<>();
    @FXML
    private TableColumn<CustomerTableModel, Long> clientIdColumn = new TableColumn<>();
    @FXML
    private TableColumn<CustomerTableModel, String> clientName = new TableColumn<>();
    @FXML
    private TableColumn <CustomerTableModel, Integer> clientShipmentsCount = new TableColumn<>();
    @FXML
    private CheckBox periodCheck;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;

    private ObservableList<CustomerTableModel> customerList(String company) {
        final CustomerProvider customerProvider = new CustomerProviderImpl();
        return FXCollections.observableList(customerProvider.getAllCompanyCustomers(company)
                .stream().toList());
    }

    private void fillCompanyComboBox() {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        List<String> companyNamesList = companyProvider.getNames();
        for (String name: companyNamesList) {
            companyNames.getItems().add(name);
        }
    }

    public void showStatisticsButton(ActionEvent actionEvent) {
        if(companyNames.getValue().isEmpty()){
            showAlert("No company defined");
            return;
        }
        ObservableList<CustomerTableModel> customerModels = customerList(companyNames.getValue());
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientShipmentsCount.setCellValueFactory(new PropertyValueFactory<>("shipmentsCount"));
        clientTable.setItems(customerModels);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        fillCompanyComboBox();
    }
    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING, message);
        alert.show();
    }
}
