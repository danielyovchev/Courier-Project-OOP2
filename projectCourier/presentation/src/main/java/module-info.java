module project.courier.presentation.presentation {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.courier.presentation to javafx.fxml;
    exports project.courier.presentation;
}