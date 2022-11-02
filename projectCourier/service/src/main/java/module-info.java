module service {
    requires static lombok;
    requires data;
    exports project.courier.service;
    exports project.courier.service.model;
    exports project.courier.service.interfaces;
}