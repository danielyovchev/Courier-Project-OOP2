module service {
    requires static lombok;
    requires data;
    requires org.apache.logging.log4j;
    exports project.courier.service.model;
    exports project.courier.service.injector;
    exports project.courier.service.injector.interfaces;
    exports project.courier.service.exceptions;
    exports project.courier.service.services.office;
    exports project.courier.service.services.shipment;
    exports project.courier.service.services.user;
    exports project.courier.service.services.company;
    exports project.courier.service.services.courier;
    exports project.courier.service.services.customer;
}