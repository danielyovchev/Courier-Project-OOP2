package project.courier.service;

import org.junit.jupiter.api.Test;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.model.ShipmentTableModel;
import project.courier.service.services.shipment.ShipmentProvider;
import project.courier.service.services.shipment.ShipmentProviderImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipmentProviderImplTest {
    private final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    private final OfficeRepositoryInjector officeRepositoryInjector = new OfficeRepositoryInjectorImpl();
    private final ShipmentProvider shipmentProvider = new ShipmentProviderImpl();

    @Test
    void getShipment() {
        assertEquals(Long.valueOf(502), shipmentProvider.getShipment(502L).getShipmentId());
    }

    @Test
    void getCustomerShipments() {
        List<ShipmentTableModel> result = shipmentProvider.getCustomerShipments(352L);
        assertEquals(2, result.size());
    }
}