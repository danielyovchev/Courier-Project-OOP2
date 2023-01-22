package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.CourierProviderImpl;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.CourierProvider;
import project.courier.service.model.CourierTableModel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminCourierStatistics implements Initializable {
    @FXML
    private TableView<CourierTableModel> courierTableView = new TableView<>();
    @FXML
    private TableColumn<CourierTableModel,String> companyName = new TableColumn<>();
    @FXML
    private TableColumn<CourierTableModel,String> courierName = new TableColumn<>();
    @FXML
    private TableColumn<CourierTableModel,String> courierUsername = new TableColumn<>();
    @FXML
    private TableColumn<CourierTableModel,Integer> shipments = new TableColumn<>();
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private Button showButton;
    @FXML
    private CheckBox periodCheckbox;
    @FXML
    private ComboBox<String> companyNames = new ComboBox<>();
    private ObservableList<CourierTableModel> courierList() {
        final CourierProvider courierProvider = new CourierProviderImpl();
        return FXCollections.observableList(courierProvider.getCouriersForCompany(companyNames.getValue()).stream().toList());
    }
    private ObservableList<CourierTableModel> courierListBetweenDates(LocalDate date1, LocalDate date2) {
        final CourierProvider courierProvider = new CourierProviderImpl();
        return FXCollections.observableList(courierProvider.getCouriersForCompanyBetweenDates(companyNames.getValue(), date1, date2).stream().toList());
    }
    private void fillCompanyComboBox() {
        final CompanyProvider companyProvider = new CompanyProviderImpl();
        companyProvider.getNames().forEach(e -> companyNames.getItems().add(e));
    }
    private void fillTable() {
        ObservableList<CourierTableModel> courierModels;
        if(periodCheckbox.isSelected()){
            courierModels = courierListBetweenDates(fromDate.getValue(), toDate.getValue());
        }
        else{
            courierModels = courierList();
        }
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        courierName.setCellValueFactory(new PropertyValueFactory<>("courierName"));
        courierUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
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
