package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.service.GetUserIdImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.interfaces.GetUserId;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.ShipmentTableModel;

import java.time.LocalDate;

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
        return null;
    }
    public void refreshButtonAction(ActionEvent actionEvent) {

    }
}
