module project.courier.presentation.presentation {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens project.courier.presentation to javafx.fxml;
    exports project.courier.presentation;
}