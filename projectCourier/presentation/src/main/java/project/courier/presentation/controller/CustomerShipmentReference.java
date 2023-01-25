package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.service.services.user.GetUserIdImpl;
import project.courier.service.services.shipment.ShipmentProviderImpl;
import project.courier.service.services.user.GetUserId;
import project.courier.service.services.shipment.ShipmentProvider;
import project.courier.service.model.ShipmentTableModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerShipmentReference {
    @FXML
    private TableView<ShipmentTableModel> shipmentReferenceTable = new TableView<>();
    @FXML
    private TableColumn<ShipmentTableModel, Long> shipmentId = new TableColumn<>();
    @FXML
    private TableColumn<ShipmentTableModel, String> shipmentStatus = new TableColumn<>();
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private CheckBox forPeriod;
    private final ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
    private final GetUserId getUserId = new GetUserIdImpl();
    public void showButtonAction(ActionEvent actionEvent) {
        ObservableList<ShipmentTableModel> shipments;
        if(forPeriod.isSelected()){
            if(fromDate.getValue() == null || toDate.getValue() == null){
                showAlert("No dates chosen");
                return;
            }
            shipments = shipmentListBetweenDates(fromDate.getValue(), toDate.getValue());
        }
        else{
            shipments = shipmentList();
        }
        shipmentId.setCellValueFactory(new PropertyValueFactory<>("shipmentId"));
        shipmentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        shipmentReferenceTable.setItems(shipments);
    }
    private ObservableList<ShipmentTableModel> shipmentList(){
        return FXCollections.observableList(shipmentProvider.getCustomerShipments(getUserId.getId(CurrentUser.username)));
    }
    private ObservableList<ShipmentTableModel> shipmentListBetweenDates(LocalDate date1, LocalDate date2){
        return FXCollections.observableList(shipmentProvider.getShipmentsBetweenDates(getUserId.getId(CurrentUser.username), date1, date2));
    }
    public void refreshButtonAction(ActionEvent actionEvent) {
        List<ShipmentTableModel> result = new ArrayList<>();
        ObservableList<ShipmentTableModel> rejected = shipmentList()
                .filtered(s -> s.getStatus().equalsIgnoreCase("rejected"));
        if(rejected.size()>0){
            showRejectedNotification(rejected.size());
            result.addAll(rejected);
        }
        ObservableList<ShipmentTableModel> delivered = shipmentList()
                .filtered(s -> s.getStatus().equalsIgnoreCase("delivered"));
        if(delivered.size()>0){
            showDeliveredNotification(delivered.size());
            result.addAll(delivered);
        }
        ObservableList<ShipmentTableModel> observableList = FXCollections.observableList(result);
        shipmentId.setCellValueFactory(new PropertyValueFactory<>("shipmentId"));
        shipmentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        shipmentReferenceTable.setItems(observableList);
    }
    private void showRejectedNotification(int count){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have "+count+" rejected shipments");
        alert.show();
    }
    private void showDeliveredNotification(int count){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have "+count+" delivered shipments");
        alert.show();
    }
    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING, message);
        alert.show();
    }
}
