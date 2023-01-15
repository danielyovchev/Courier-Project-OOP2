package project.courier.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.service.CompanyProviderImpl;
import project.courier.service.GetAllCompaniesImpl;
import project.courier.service.ShipmentProviderImpl;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.interfaces.GetAllCompanies;
import project.courier.service.interfaces.ShipmentProvider;
import project.courier.service.model.CompanyModel;
import project.courier.service.model.CompanyTableModel;
import project.courier.service.model.ShipmentTableModel;

import java.net.URL;
import java.util.ResourceBundle;



public class AdminStatistics implements Initializable {

    @FXML
    private TableView<CompanyTableModel> CompanyTable = new TableView<>();
    @FXML
    private TableColumn<CompanyTableModel, Long> companyId = new TableColumn<>();
    @FXML
    private TableColumn <ShipmentTableModel, Integer> CompanyShipments = new TableColumn<>();


    private ObservableList<CompanyTableModel> companyIdList()
    {
        final CompanyProvider companyProvider = new CompanyProviderImpl();
        return FXCollections.observableList(companyProvider.getAllCompanies().stream().toList());
    }
    private void displayCompanyTable()
    {
        ObservableList<CompanyTableModel> companyModels = companyIdList();
        companyId.setCellValueFactory(new PropertyValueFactory<>("companyId"));
        CompanyShipments.setCellValueFactory(new PropertyValueFactory<>("shipmentCount"));
        CompanyTable.setItems(companyModels);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            displayCompanyTable();

    }
}
