package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.courier.presentation.HelloApplication;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.service.GetUserIdImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.interfaces.GetUserId;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.ShipmentTableModel;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private Button logOutBtn;
    @FXML
    private TableView<ShipmentTableModel> shipmentsView = new TableView<>();
    @FXML
    private TableColumn <ShipmentTableModel, Long> shipmentId = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, String> office = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, String> category = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, String> destination = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, String> status = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, Double> price = new TableColumn<>();
    @FXML
    private TableColumn<ShipmentTableModel, LocalDate> dateSent = new TableColumn<>();

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
    private ObservableList<ShipmentTableModel> getModels(){
        final ShipmentProvider shipmentProvider = new ShipmentProviderImpl();
        final GetUserId getUserId = new GetUserIdImpl();
        return FXCollections.observableList(shipmentProvider
                .getCustomerShipments(getUserId.getId(CurrentUser.username)).stream().toList());
    }
    private void displayTable(){
        ObservableList<ShipmentTableModel> shipments = getModels();
        shipmentId.setCellValueFactory(new PropertyValueFactory<>("shipmentId"));
        office.setCellValueFactory(new PropertyValueFactory<>("office"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateSent.setCellValueFactory(new PropertyValueFactory<>("dateSent"));
        shipmentsView.setItems(shipments);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayTable();
    }
}
