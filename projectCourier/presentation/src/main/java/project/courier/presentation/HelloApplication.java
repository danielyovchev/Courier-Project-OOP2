package project.courier.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.courier.service.OrganizeShipmentsImpl;
import project.courier.service.interfaces.OrganizeShipments;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/project/courier/presentation/Login-page.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 450);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        final OrganizeShipments organizeShipments = new OrganizeShipmentsImpl();
        executorService.scheduleAtFixedRate(organizeShipments, 0, 1, TimeUnit.MINUTES);
        launch();
    }
}