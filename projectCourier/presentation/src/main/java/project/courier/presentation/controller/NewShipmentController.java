package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.courier.presentation.logConstants.CurrentUser;
import project.courier.presentation.services.ShipmentRegisterInjector;
import project.courier.presentation.services.ShipmentRegisterInjectorImpl;
import project.courier.service.GetAllOfficesImpl;
import project.courier.service.exceptions.UserNotFoundException;
import project.courier.service.interfaces.GetAllOffices;
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
        catch (UserNotFoundException exception){
            System.out.println("errr");
        }

    }
    @FXML
    public void closeForm(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final GetAllOffices getAllOffices = new GetAllOfficesImpl();
        getAllOffices.getAllOffices().forEach(e -> officeList.getItems().add(e));
        //getAllOffices.getOfficesByCity(city.getText()).forEach(e -> officeList.getItems().add(e));
        String[] types = {"ENVELOPE", "PARCEL", "PACKAGE", "CARGO"};
        Arrays.stream(types).forEach(e -> typeList.getItems().add(e));
    }
}
