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
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.CustomerProvider;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.CustomerModel;
import project.courier.service.model.ShipmentTableModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminCustomerStatistics implements Initializable {

    @FXML
    private ComboBox<String> companyNames = new ComboBox<>();

    @FXML
    private TableColumn<CustomerModel, Long> ClientIdColumn = new TableColumn<>();
    @FXML
    private TableColumn <CustomerModel, Integer> ClientShipmentsCount = new TableColumn<>();
    @FXML
    private TableView<CustomerModel> ClientTable = new TableView<>();
    @FXML
    private CheckBox periodCheck = new CheckBox();
    @FXML
    private DatePicker fromDate = new DatePicker();
    @FXML
    private  DatePicker toDate= new DatePicker();

    private ObservableList<CustomerModel> customerList(long companyId)
    {
        final CustomerProvider customerProvider = new CustomerProviderImpl();
        return FXCollections.observableList(customerProvider.getAllCompanyCustomers(companyId)
                .stream().toList());
    }

    private void fillCompanyComboBox() {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        List<String> companyNamesList = companyProvider.getNames();
        for (String name: companyNamesList) {
            companyNames.getItems().add(name);
        }
    }

    public void ShowStatisticsButton(ActionEvent actionEvent)
    {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        long currentCompanyId = companyProvider.getCurrentCompanyIdByName(companyNames.getValue());
        CompanyRepositoryInjector injector = new CompanyRepositoryInjectorImpl();

        System.out.println(currentCompanyId);
        ObservableList<CustomerModel> customerModels = customerList(currentCompanyId);
        ClientIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        for (CustomerModel c:customerModels)
        {
            List<ShipmentTableModel> shipmentsCountList = shipmentProvider.getCustomerShipments(c.getCustomerId());
            c.setShipmentsCount(shipmentsCountList.size());
            System.out.println(c.getShipmentsCount());
            ClientShipmentsCount.setCellValueFactory(new PropertyValueFactory<>("shipmentsCount"));
        }
        ClientTable.setItems(customerModels);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        fillCompanyComboBox();
    }
}
