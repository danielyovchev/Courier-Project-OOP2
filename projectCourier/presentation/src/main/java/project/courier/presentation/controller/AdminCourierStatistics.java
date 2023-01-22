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
import project.courier.service.CourierProviderImpl;
import project.courier.service.CustomerProviderImpl;
import project.courier.service.GetAllCompaniesImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.CourierProvider;
import project.courier.service.interfaces.CustomerProvider;
import project.courier.service.interfaces.GetAllCompanies;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.CourierModel;
import project.courier.service.model.CustomerModel;
import project.courier.service.model.ShipmentModel;
import project.courier.service.model.ShipmentTableModel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminCourierStatistics implements Initializable {

    @FXML
    private TableView<CourierModel> courierTableView = new TableView<>();
    @FXML
    private TableColumn<CourierModel,String> companyName = new TableColumn<>();
    @FXML
    private TableColumn<CourierModel,String> courierName = new TableColumn<>();
    @FXML
    private TableColumn<CourierModel,String> courierUsername = new TableColumn<>();
    @FXML
    private TableColumn<CourierModel,Integer> shipments = new TableColumn<>();
    @FXML
    private DatePicker fromDate = new DatePicker();
    @FXML
    private DatePicker toDate = new DatePicker();
    @FXML
    private Button ShowButton =new Button();
    @FXML
    private CheckBox PeriodCheckbox = new CheckBox();
    @FXML
    private ComboBox<String> companyNames = new ComboBox<>();



    private ObservableList<CourierModel> courierList()
    {
        final CourierProvider courierProvider = new CourierProviderImpl();
        return FXCollections.observableList(courierProvider.getAllCouriers().stream().toList());
    }

    private void fillCompanyComboBox()
    {
        GetAllCompanies getAllCompanies = new GetAllCompaniesImpl();
        List<String> companyNamesList = getAllCompanies.getNames();
        for (String name: companyNamesList) {
            companyNames.getItems().add(name);
        }
    }
    private ObservableList<CourierModel> filterList (ObservableList<CourierModel> unfiltered)
    {
        List<CourierModel> filteredList = new ArrayList<>();
        for (CourierModel model: unfiltered) {
            if (model.getCompanyName().equalsIgnoreCase(companyNames.getValue()))
                filteredList.add(model);
        }
        return FXCollections.observableList(filteredList.stream().toList());
    }

    private void setShipmentsCount (ObservableList<CourierModel> list)
    {
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        for (CourierModel model: list) {
            model.setShipmentsCount(shipmentProvider.getCourierShipments(model.getCourierId()).size());
        }
    }

    private void DateFilteredShipmentsCount (ObservableList<CourierModel> list,
                                             LocalDate fromDate, LocalDate toDate)
    {
        ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        List<ShipmentTableModel> allShipments =  new ArrayList<>();
        for (CourierModel model: list)
        {
            int shipmentCount=0;
            allShipments = shipmentProvider.getCourierShipments(model.getCourierId());
            for (ShipmentTableModel shipment: allShipments)
            {
                if(shipment.getDateSent().isAfter(fromDate) && shipment.getDateSent().isBefore(toDate))
                {shipmentCount++;}
            }
            model.setShipmentsCount(shipmentCount);
        }
    }

    private void fillTable() {
        ObservableList<CourierModel> courierModels = filterList(courierList());

        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        courierName.setCellValueFactory(new Callback<>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CourierModel, String> n) {
                return new SimpleStringProperty(n.getValue().getFirstName() +
                        " " + n.getValue().getLastName());
            }
        });
        courierUsername.setCellValueFactory(new PropertyValueFactory<>("username"));

        if(PeriodCheckbox.isSelected())
        {
            DateFilteredShipmentsCount(courierModels,fromDate.getValue(),toDate.getValue());
        }
        else {
            setShipmentsCount(courierModels);
        }

        shipments.setCellValueFactory(new PropertyValueFactory<>("shipmentsCount"));
        courierTableView.setItems(courierModels);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillCompanyComboBox();

    }

    public void ShowPeriodTable(ActionEvent actionEvent) {
        fillTable();
    }
}

