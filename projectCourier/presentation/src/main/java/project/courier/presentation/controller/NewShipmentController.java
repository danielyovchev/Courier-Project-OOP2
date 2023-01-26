package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.presentation.services.ShipmentRegisterInjector;
import project.courier.presentation.services.ShipmentRegisterInjectorImpl;
import project.courier.service.services.office.OfficeProviderImpl;
import project.courier.service.exceptions.CustomerNotFoundException;
import project.courier.service.services.office.OfficeProvider;
import project.courier.service.model.ShipmentModel;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class NewShipmentController implements Initializable {
    @FXML
    private Button closeBtn;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField city;
    @FXML
    private DatePicker sentDate;
    @FXML
    private ComboBox<String> officeList;
    @FXML
    private ComboBox<String> typeList;
    private final ShipmentRegisterInjector injector = new ShipmentRegisterInjectorImpl();
    @FXML
    public void registerShipment(){
        if(firstName.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing first name!");
            return;
        }
        if(lastName.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing last name!");
            return;
        }
        if(email.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing email!");
            return;
        }
        if(city.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing destination!");
            return;
        }
        if(officeList.getValue() == null){
            showAlert(Alert.AlertType.WARNING,"No office chosen!");
            return;
        }
        if(sentDate.getValue() == null){
            showAlert(Alert.AlertType.WARNING,"No date entered!");
            return;
        }
        if(phone.getText().isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Missing phone!");
            return;
        }
        if(typeList.getValue() == null){
            showAlert(Alert.AlertType.WARNING,"No type chosen!");
            return;
        }

        final ShipmentModel model = new ShipmentModel();
        model.setFirstName(firstName.getText());
        model.setLastName(lastName.getText());
        model.setEmail(email.getText());
        model.setPhone(phone.getText());
        model.setCity(city.getText());
        model.setDateSent(sentDate.getValue());
        model.setOffice(officeList.getValue());
        model.setType(typeList.getValue());
        model.setCourierUsername(CurrentUser.username);
        try {
            injector.register().registerShipment(model);
            showAlert(Alert.AlertType.CONFIRMATION, "Shipment registered");
        }
        catch (CustomerNotFoundException exception){
            showAlert(Alert.AlertType.WARNING,"No customer with that credentials");
        }
    }
    private void showAlert(Alert.AlertType alertType, String message){
        Alert alert = new Alert(alertType, message);
        alert.show();
    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final OfficeProvider getAllOffices = new OfficeProviderImpl();
        getAllOffices.getAllOffices(CurrentUser.username).forEach(e -> officeList.getItems().add(e));
        String[] types = {"ENVELOPE", "PARCEL", "PACKAGE", "CARGO"};
        Arrays.stream(types).forEach(e -> typeList.getItems().add(e));
    }
}
