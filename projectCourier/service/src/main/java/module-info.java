module service {
    requires static lombok;
    requires data;
    requires org.apache.logging.log4j;
    exports project.courier.service;
    exports project.courier.service.model;
    exports project.courier.service.interfaces;
    exports project.courier.service.injector;
    exports project.courier.service.injector.interfaces;
    exports project.courier.service.exceptions;
}