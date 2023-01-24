package project.courier.service;

import org.junit.jupiter.api.Test;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.model.ShipmentTableModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipmentProviderImplTest {
    private final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    private final OfficeRepositoryInjector officeRepositoryInjector = new OfficeRepositoryInjectorImpl();
    /*@Test
    void getShipmentsBetweenDates() {
    }

    @Test
    void getShipment() {
    }*/

    @Test
    void getCustomerShipments() {
        List<ShipmentTableModel> result = shipmentRepositoryInjector.getShipmentRepository()
                .findAllByCustomer(202L).stream().map(s -> ShipmentTableModel.builder()
                        .shipmentId(s.getId())
                        .category(s.getCategory().toString())
                        .dateSent(s.getDateSent())
                        .office(officeRepositoryInjector.getOfficeRepository().findById(s.getOfficeId()).toString())
                        .destination(s.getDestination())
                        .price(s.getPrice())
                        .status(s.getStatus().toString())
                        .build()).toList();
        assertEquals(2, result.size());
    }
}