package project.courier.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.presentation.services.ShipmentReceiveInjector;
import project.courier.presentation.services.ShipmentReceiveInjectorImpl;
import project.courier.service.services.user.GetUserIdImpl;
import project.courier.service.services.shipment.ShipmentProviderImpl;
import project.courier.service.services.user.GetUserId;
import project.courier.service.services.shipment.ShipmentProvider;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShipmentsReceiveController implements Initializable {
    @FXML
    private ListView shipmentList;
    @FXML
    private Button closeBtn;
    private final ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
    private final GetUserId getUserId = new GetUserIdImpl();
    private final ShipmentReceiveInjector shipmentReceiveInjector = new ShipmentReceiveInjectorImpl();
    public void receiveShipments(ActionEvent actionEvent) {
        if(shipmentList.getItems().size() == 0){
            showAlert(Alert.AlertType.WARNING,"No shipments selected");
        }
        final List selected = shipmentList.getSelectionModel().getSelectedItems().stream().toList();
        shipmentReceiveInjector.getShipmentReceive().shipmentReceive(selected);
        shipmentList.getItems().clear();
        showAlert(Alert.AlertType.CONFIRMATION, selected.size()+ " shipments received");
    }
    private void listViewFill(){
        shipmentList.getItems()
                .addAll(shipmentProvider.getCustomerShipments(getUserId.getId(CurrentUser.username))
                        .stream().filter(s -> s.getStatus().equalsIgnoreCase("delivered"))
                        .map(s -> s.getShipmentId())
                        .toList());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listViewFill();
        shipmentList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    private void showAlert(Alert.AlertType alertType, String message){
        Alert alert = new Alert(alertType, message);
        alert.show();
    }
    public void closeForm(ActionEvent actionEvent) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
