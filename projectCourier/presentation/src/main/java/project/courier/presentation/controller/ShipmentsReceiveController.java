package project.courier.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.service.GetUserIdImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.interfaces.GetUserId;
import project.courier.service.interfaces.ShipmentProvider;

import java.net.URL;
import java.util.ResourceBundle;

public class ShipmentsReceiveController implements Initializable {
    @FXML
    private ListView shipmentList;
    private final ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
    private final GetUserId getUserId = new GetUserIdImpl();

    public void receiveShipments(ActionEvent actionEvent) {

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
    }
}
