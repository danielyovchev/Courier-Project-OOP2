package project.courier.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import project.courier.presentation.services.MockAddUserInjector;
import project.courier.presentation.services.MockAddUserInjectorImpl;
import project.courier.service.model.UserModel;

public class HelloController{
    //private AddUserInterface mockAddUser;
    private MockAddUserInjector injector;
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        injector = new MockAddUserInjectorImpl();
        //mockAddUser = new MockAddUserOperation();
        UserModel model = new UserModel();
        model.setEmail("admin3@courier.bg");
        model.setUsername("admin2");
        model.setPassword("admin");
        model.setFirstName("Admin3");
        model.setLastName("Admin3");
        model.setType("ADMIN");
        injector.getService().addAdmin(model);
        //mockAddUser.addAdmin(model);
    }


}