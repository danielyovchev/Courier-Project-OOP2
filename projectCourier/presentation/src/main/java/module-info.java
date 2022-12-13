module presentation {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires service;
    requires data;
    opens project.courier.presentation to javafx.fxml;
    exports project.courier.presentation;
    exports project.courier.presentation.controller;
    opens project.courier.presentation.controller to javafx.fxml;
    exports project.courier.presentation.services;
    opens project.courier.presentation.services to javafx.fxml;
}