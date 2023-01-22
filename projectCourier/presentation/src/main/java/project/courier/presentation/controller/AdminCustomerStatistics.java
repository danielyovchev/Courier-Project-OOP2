package project.courier.presentation.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.CustomerProviderImpl;
import project.courier.service.GetAllCompaniesImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.CustomerProvider;
import project.courier.service.interfaces.GetAllCompanies;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.CourierModel;
import project.courier.service.model.CustomerModel;
import project.courier.service.model.ShipmentTableModel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class AdminCustomerStatistics implements Initializable {

    @FXML
    private ComboBox<String> companyNames = new ComboBox<>();

    @FXML
    private TableColumn<CustomerModel, String> CompanyName = new TableColumn<>();
    @FXML
    private TableColumn<CustomerModel, String> ClientName = new TableColumn<>();
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

    private void fillCompanyComboBox()
    {
        GetAllCompanies getAllCompanies = new GetAllCompaniesImpl();
        List<String> companyNamesList = getAllCompanies.getNames();
        for (String name: companyNamesList)
        {companyNames.getItems().add(name);}
    }

    private void setCustomerShipmentsCount (ObservableList<CustomerModel> list)
    {
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        for (CustomerModel c: list)
        {
            List<ShipmentTableModel> shipmentsCountList = shipmentProvider.getCustomerShipments(c.getCustomerId());
            c.setShipmentsCount(shipmentsCountList.size());
        }
    }

    private void DateFilteredShipmentsCount (ObservableList<CustomerModel> list,
                                             LocalDate fromDate, LocalDate toDate)
    {
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        List<ShipmentTableModel> allShipments =  new ArrayList<>();
        for (CustomerModel model: list)
        {
            int shipmentCount=0;
            allShipments = shipmentProvider.getCustomerShipments(model.getCustomerId());
            for (ShipmentTableModel shipment: allShipments)
            {
                if(shipment.getDateSent().isAfter(fromDate) && shipment.getDateSent().isBefore(toDate))
                {shipmentCount++;}
            }
            model.setShipmentsCount(shipmentCount);
        }
    }

    public void ShowStatisticsButton(ActionEvent actionEvent)
    {
        CompanyProvider companyProvider = new CompanyProviderImpl();
        long currentCompanyId = companyProvider.getCurrentCompanyIdByName(companyNames.getValue());

        ObservableList<CustomerModel> customerModels = customerList(currentCompanyId);

        CompanyName.setCellValueFactory(new PropertyValueFactory<>("company"));
        ClientName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CustomerModel, String> c) {
                return new SimpleStringProperty(c.getValue().getFirstName() +
                        " " + c.getValue().getLastName());
            }
        });
        if(periodCheck.isSelected())
        {
            DateFilteredShipmentsCount(customerModels,fromDate.getValue(),toDate.getValue());
        }
        else {
            setCustomerShipmentsCount(customerModels);
        }


        ClientShipmentsCount.setCellValueFactory(new PropertyValueFactory<>("shipmentsCount"));
        ClientTable.setItems(customerModels);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        fillCompanyComboBox();
    }
}
