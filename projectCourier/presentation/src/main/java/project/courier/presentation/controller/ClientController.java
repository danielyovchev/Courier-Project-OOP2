package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import project.courier.presentation.HelloApplication;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.service.GetUserIdImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.interfaces.GetUserId;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.ShipmentModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private Button logOutBtn;
    @FXML
    private TableColumn <ShipmentModel, Long> shipmentId;
    @FXML
    private TableColumn <ShipmentModel,Long> fromOffice;
    @FXML
    private TableColumn <ShipmentModel,Long> orderId;
    @FXML
    private TableColumn <ShipmentModel,String> shipmentCategory;
    @FXML
    private TableColumn <ShipmentModel,String> destinationOffice;
    @FXML
    private TableColumn <ShipmentModel,String> orderStatus;
    @FXML
    private TableColumn <ShipmentModel,Double> orderPrice;
    @FXML
    private TableView shipmentsView;
    @FXML
    public void logOut() throws IOException {
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/project/courier/presentation/Login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        CurrentUser.role="none";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        final ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        final GetUserId getUserId = new GetUserIdImpl();
        shipmentProvider.getCustomerShipments(getUserId.getId(CurrentUser.username));

    }
}
