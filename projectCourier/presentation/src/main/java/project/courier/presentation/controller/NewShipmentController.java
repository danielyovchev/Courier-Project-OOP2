package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.presentation.services.ShipmentRegisterInjector;
import project.courier.presentation.services.ShipmentRegisterInjectorImpl;
import project.courier.service.OfficeProviderImpl;
import project.courier.service.exceptions.CustomerNotFoundException;
import project.courier.service.interfaces.OfficeProvider;
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
    @FXML
    public void registerShipment(){
        if(firstName.getText().isEmpty()){
            showAlert("Missing first name!");
            return;
        }
        if(lastName.getText().isEmpty()){
            showAlert("Missing last name!");
            return;
        }
        if(email.getText().isEmpty()){
            showAlert("Missing email!");
            return;
        }
        if(city.getText().isEmpty()){
            showAlert("Missing destination!");
            return;
        }
        if(officeList.getValue().isEmpty()){
            showAlert("No office chosen!");
            return;
        }
        if (sentDate.getValue() == null){
            showAlert("No date entered!");
            return;
        }
        if(phone.getText().isEmpty()){
            showAlert("Missing phone");
            return;
        }
        final ShipmentRegisterInjector injector = new ShipmentRegisterInjectorImpl();
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
        }
        catch (CustomerNotFoundException exception){
            showAlert("No customer with that credentials");
        }
    }
    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
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
