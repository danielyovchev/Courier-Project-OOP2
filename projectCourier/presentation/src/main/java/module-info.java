module presentation {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires service;
    opens project.courier.presentation to javafx.fxml;
    exports project.courier.presentation;
}