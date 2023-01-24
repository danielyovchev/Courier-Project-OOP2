package project.courier.service.injector;

import project.courier.data.repository.ShipmentRepository;
import project.courier.data.repository.ShipmentRepositoryImpl;
import project.courier.data.util.DBUtils;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;

public class ShipmentRepositoryInjectorImpl implements ShipmentRepositoryInjector {
    @Override
    public ShipmentRepository getShipmentRepository() {
        return new ShipmentRepositoryImpl(new DBUtils());
    }
}
