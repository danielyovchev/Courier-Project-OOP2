package project.courier.service;

import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentCategory;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.CustomerRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.injector.interfaces.CustomerRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.RegisterShipment;
import project.courier.service.model.ShipmentModel;

public class RegisterShipmentImpl implements RegisterShipment {
    @Override
    public void registerShipment(ShipmentModel model) {
        final ShipmentRepositoryInjector injector = new ShipmentRepositoryInjectorImpl();
        final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
        final CustomerRepositoryInjector customerRepositoryInjector = new CustomerRepositoryInjectorImpl();
        final Long courierId = courierRepositoryInjector.getCourierRepository()
                .findByUsername(model.getUsername()).get().getId();
        final Long customerId = customerRepositoryInjector.getCustomerRepository().findByEmail(model.getEmail()).get().getId();
        double price = 0;
        if(model.getType().equalsIgnoreCase("ENVELOPE")){
            price= 2.50;
        }
        else if(model.getType().equalsIgnoreCase("PARCEL")){
            price=3.50;
        }
        else if(model.getType().equalsIgnoreCase("PACKAGE")){
            price=4.50;
        }
        else if(model.getType().equalsIgnoreCase("CARGO")){
            price=10.50;
        }
        Shipment shipment = Shipment.builder()
                .customerId(customerId)
                .courierId(courierId)
                .dateSent(model.getDateSent())
                .category(ShipmentCategory.valueOf(model.getType().toUpperCase()))
                .status(ShipmentStatus.IN_OFFICE)
                .price(price)
                .build();
        injector.getShipmentRepository().save(shipment);
    }
}
