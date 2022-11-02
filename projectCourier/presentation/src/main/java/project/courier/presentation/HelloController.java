package project.courier.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import project.courier.service.MockAddUserOperation;
import project.courier.service.interfaces.MockAddUserInterface;
import project.courier.service.model.UserModel;

public class HelloController{
    private MockAddUserInterface mockAddUser;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        mockAddUser = new MockAddUserOperation();
        UserModel model = new UserModel();
        model.setEmail("admin@courier.bg");
        model.setUsername("admin");
        model.setPassword("admin");
        model.setFirstName("Admin");
        model.setLastName("Admin");
        model.setType("ADMIN");
        mockAddUser.addAdmin(model);
    }


}