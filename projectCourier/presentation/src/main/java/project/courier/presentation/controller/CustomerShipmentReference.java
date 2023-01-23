package project.courier.presentation.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.ShipmentTableModel;

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
    public void showButtonAction(ActionEvent actionEvent) {
        if(forPeriod.isSelected()){

        }
        else{

        }

    }
    private ObservableList<ShipmentTableModel> shipmentList(){
        return null;
    }
    public void refreshButtonAction(ActionEvent actionEvent) {

    }
}
