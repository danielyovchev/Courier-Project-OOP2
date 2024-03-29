package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.service.model.CompanyTableModel;
import project.courier.service.model.ShipmentTableModel;
import project.courier.service.services.shipment.ShipmentProvider;
import project.courier.service.services.shipment.ShipmentProviderImpl;

import java.time.LocalDate;
import java.util.stream.Stream;

public class CustomerShipmentCheck {
    @FXML
    private TextField findShipmentId;
    @FXML
    private TableView<ShipmentTableModel> shipmentsView = new TableView<>();
    @FXML
    private TableColumn<CompanyTableModel, Long> shipmentId = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, String> category = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, String> office = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, String> destination = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, LocalDate> dateSent = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, Double> price = new TableColumn<>();
    @FXML
    private TableColumn <CompanyTableModel, String> status = new TableColumn<>();

    public void showButtonAction(ActionEvent actionEvent) {
        ObservableList<ShipmentTableModel> modelList = getModels();
        shipmentId.setCellValueFactory(new PropertyValueFactory<>("shipmentId"));
        office.setCellValueFactory(new PropertyValueFactory<>("office"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateSent.setCellValueFactory(new PropertyValueFactory<>("dateSent"));
        shipmentsView.setItems(modelList);
    }
    private ObservableList<ShipmentTableModel> getModels(){
        final ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        return FXCollections.observableList(Stream.of(shipmentProvider.getShipment(Long.valueOf(findShipmentId.getText()))).toList());
    }
}
