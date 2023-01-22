package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.CompanyTableModel;
import project.courier.service.model.CustomerModel;
import project.courier.service.model.ShipmentTableModel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminCompanyStatistics implements Initializable
{
    @FXML
    private TableView<CompanyTableModel> CompanyTable = new TableView<>();
    @FXML
    private TableColumn<CompanyTableModel, String> companyName = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, Integer> CompanyShipments = new TableColumn<>();
    @FXML
    private DatePicker fromDate = new DatePicker();
    @FXML
    private DatePicker toDate = new DatePicker();
    @FXML
    private CheckBox periodCheck= new CheckBox();
    @FXML
    private Button showButton = new Button();

    private ObservableList<CompanyTableModel> companyIdList()
    {
        final CompanyProvider companyProvider = new CompanyProviderImpl();
        return FXCollections.observableList(companyProvider.getAllCompanies().stream().toList());
    }

    private void ShipmentsCount(ObservableList<CompanyTableModel> list)
    {
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        List<ShipmentTableModel> shipmentsList = shipmentProvider.getCompanyShipments();

        for (CompanyTableModel model: list) {
            int shipmentsCount=0;

            for (ShipmentTableModel shipment: shipmentsList)
            {
                if (model.getCompanyId()==shipment.getCompanyId())
                {
                   shipmentsCount++;
                }
                model.setShipmentCount(shipmentsCount);
            }
        }
    }

    private void DateFilteredShipmentsCount (ObservableList<CompanyTableModel> list,
                                             LocalDate fromDate, LocalDate toDate)
    {
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        List<ShipmentTableModel> allShipments =  shipmentProvider.getCompanyShipments();
        List<ShipmentTableModel> companyShipments =  new ArrayList<>();
        for (CompanyTableModel model: list)
        {
            int shipmentCount=0;
            for (ShipmentTableModel shipment: allShipments)
            {
                if (model.getCompanyId() == shipment.getCompanyId())
                {
                    companyShipments.add(shipment);
                }

            }
            for (ShipmentTableModel shipment: companyShipments)
            {
                if(shipment.getDateSent().isAfter(fromDate) && shipment.getDateSent().isBefore(toDate))
                {shipmentCount++;}
            }
            model.setShipmentCount(shipmentCount);
        }
    }

    private void displayCompanyTable()
    {
        ObservableList<CompanyTableModel> companyModels = companyIdList();

        ShipmentsCount(companyModels);

        if(periodCheck.isSelected())
        {
            DateFilteredShipmentsCount(companyModels,fromDate.getValue(),toDate.getValue());
        }
        else {
            ShipmentsCount(companyModels);
        }

        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        CompanyShipments.setCellValueFactory(new PropertyValueFactory<>("shipmentCount"));
        CompanyTable.setItems(companyModels);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayCompanyTable();
    }

    public void ShowStatisticsButton(ActionEvent actionEvent)
    {
        displayCompanyTable();
    }
}
