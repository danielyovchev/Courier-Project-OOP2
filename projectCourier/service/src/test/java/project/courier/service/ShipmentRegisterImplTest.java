package project.courier.service;

import org.junit.Test;
import project.courier.data.entity.Customer;
import project.courier.data.entity.Office;
import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentCategory;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.exceptions.CustomerNotFoundException;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.CustomerRepositoryInjectorImpl;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.injector.interfaces.CustomerRepositoryInjector;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.model.ShipmentModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentRegisterImplTest {
    final ShipmentRepositoryInjector injector = new ShipmentRepositoryInjectorImpl();
    final OfficeRepositoryInjector officeRepo = new OfficeRepositoryInjectorImpl();
    final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
    final CustomerRepositoryInjector customerRepositoryInjector = new CustomerRepositoryInjectorImpl();

    @Test(expected = CustomerNotFoundException.class)
    public void registerShipmentNoCustomerFound() {
        final ShipmentModel model = ShipmentModel.builder().courierUsername("iv.iv").build();
        registerShipment(model);
//        assertThrows(CustomerNotFoundException.class, () -> registerShipment(model));
    }

    @Test
    public void regShipment(){
        final ShipmentModel model = ShipmentModel.builder().type("package").build();
        assertEquals(4.50, getResult(model).getPrice().doubleValue());
    }

    void registerShipment(ShipmentModel model) {
        final Long courierId = courierRepositoryInjector.getCourierRepository()
                .findByUsername(model.getCourierUsername()).get().getId();
        final Customer customer = customerRepositoryInjector.getCustomerRepository()
                .findByEmail(model.getEmail()).orElse(null);
        if(customer == null){
            throw new CustomerNotFoundException();
        }
        final Office office = officeRepo.getOfficeRepository()
                .findByCity(model.getOffice()).get();
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
                .customerId(customer.getId())
                .courierId(courierId)
                .officeId(office.getId())
                .destination(model.getCity())
                .dateSent(model.getDateSent())
                .category(ShipmentCategory.valueOf(model.getType().toUpperCase()))
                .status(ShipmentStatus.IN_OFFICE)
                .price(price)
                .build();
    }

    Shipment getResult(ShipmentModel model){
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
        return Shipment.builder()
                .category(ShipmentCategory.valueOf(model.getType().toUpperCase()))
                .price(price)
                .build();
    }
}