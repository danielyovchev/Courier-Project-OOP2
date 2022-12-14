package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import project.courier.presentation.logConstants.CurrentUser;

public class ClientController {
    @FXML
    private Button logOutBtn;
    @FXML
    public void logOut(){
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
        CurrentUser.role="none";
    }
}
