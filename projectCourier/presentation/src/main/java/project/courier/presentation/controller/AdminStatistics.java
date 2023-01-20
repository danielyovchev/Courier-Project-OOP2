package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.CustomerProviderImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.CustomerProvider;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.CompanyTableModel;
import project.courier.service.model.CustomerModel;
import project.courier.service.model.ShipmentTableModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class AdminStatistics implements Initializable {

    @FXML
    private TableView<CompanyTableModel> CompanyTable = new TableView<>();
    @FXML
    private TableColumn<CompanyTableModel, Long> companyId = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, Integer> CompanyShipments = new TableColumn<>();
    @FXML
    private ComboBox<String> companyNames = new ComboBox<>();

    @FXML
    private TableColumn <CustomerModel, Long> ClientIdColumn = new TableColumn<>();
    @FXML
    private TableColumn <CustomerModel, Integer> ClientShipmentsCount = new TableColumn<>();
    @FXML
    private TableView<CustomerModel> ClientTable = new TableView<>();


    private ObservableList<CompanyTableModel> companyIdList()
    {
        final CompanyProvider companyProvider = new CompanyProviderImpl();
        return FXCollections.observableList(companyProvider.getAllCompanies().stream().toList());
    }
    private ObservableList<CustomerModel> customerList(long companyId)
    {
        final CustomerProvider customerProvider = new CustomerProviderImpl();
        return FXCollections.observableList(customerProvider.getAllCompanyCustomers(companyId)
                .stream().toList());
    }
    private void displayCompanyTable()
    {
        ObservableList<CompanyTableModel> companyModels = companyIdList();
        companyId.setCellValueFactory(new PropertyValueFactory<>("companyId"));
        CompanyShipments.setCellValueFactory(new PropertyValueFactory<>("shipmentCount"));
        CompanyTable.setItems(companyModels);
    }
    private void fillCompanyComboBox() {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        List<String> companyNamesList = companyProvider.getNames();
        for (String name: companyNamesList) {
            companyNames.getItems().add(name);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
            displayCompanyTable();
            fillCompanyComboBox();
    }


    public void ShowStatisticsButton(ActionEvent actionEvent)
    {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        long currentCompanyId = companyProvider.getCurrentCompanyIdByName(companyNames.getValue());
        ObservableList<CustomerModel> customerModels = customerList(currentCompanyId);
        ClientIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        for (CustomerModel c:customerModels)
        {
            List<ShipmentTableModel> shipmentsCountList = shipmentProvider.getCustomerShipments(c.getCustomerId());
            c.setShipmentsCount(shipmentsCountList.size());
            ClientShipmentsCount.setCellValueFactory(new PropertyValueFactory<>("shipmentsCount"));
        }
        ClientTable.setItems(customerModels);
    }
}
