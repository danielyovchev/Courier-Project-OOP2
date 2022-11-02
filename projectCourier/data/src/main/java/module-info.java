module data {
    requires org.hibernate.orm.core;
    requires static lombok;
    requires jakarta.persistence;
    requires java.naming;
    opens project.courier.data.entity to org.hibernate.orm.core;
    exports project.courier.data.crud;
    exports project.courier.data.entity;
    exports project.courier.data.util;
    exports project.courier.data.entity.enums;
}