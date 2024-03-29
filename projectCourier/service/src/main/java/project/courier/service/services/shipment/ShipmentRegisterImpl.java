package project.courier.service.services.shipment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Courier;
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

/**
 * register new shipment in db
 */
public class ShipmentRegisterImpl implements ShipmentRegister {
    private final ShipmentRepositoryInjector injector = new ShipmentRepositoryInjectorImpl();
    private final OfficeRepositoryInjector officeRepo = new OfficeRepositoryInjectorImpl();
    private final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
    private final CustomerRepositoryInjector customerRepositoryInjector = new CustomerRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(ShipmentRegisterImpl.class);
    @Override
    public void registerShipment(ShipmentModel model) {
        final Courier courier = courierRepositoryInjector.getCourierRepository()
                .findByUsername(model.getCourierUsername()).get();
        final Customer customer = customerRepositoryInjector.getCustomerRepository()
                .findByEmail(model.getEmail()).orElse(null);
        if(customer == null){
            logger.error("No customer found");
            throw new CustomerNotFoundException();
        }
        final Office office = officeRepo.getOfficeRepository()
                .findByCityAndCompany(model.getOffice(), courier.getCompanyId()).get();
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
                .courierId(courier.getId())
                .officeId(office.getId())
                .companyId(courier.getCompanyId())
                .destination(model.getCity())
                .dateSent(model.getDateSent())
                .category(ShipmentCategory.valueOf(model.getType().toUpperCase()))
                .status(ShipmentStatus.IN_OFFICE)
                .price(price)
                .build();
        injector.getShipmentRepository().save(shipment);
        logger.info("Shipment with id {} registered", shipment.getId());
    }
}
