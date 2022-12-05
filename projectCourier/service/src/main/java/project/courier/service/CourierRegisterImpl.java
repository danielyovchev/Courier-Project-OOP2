package project.courier.service;

import project.courier.data.entity.Courier;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.interfaces.CourierRegister;
import project.courier.service.model.CourierModel;

public class CourierRegisterImpl implements CourierRegister {
    @Override
    public void addCourier(CourierModel courierModel) {
        final CourierRepositoryInjector injector = new CourierRepositoryInjectorImpl();
        Courier courier = new Courier();
        courier.setFirstName(courier.getFirstName());
        courier.setLastName(courierModel.getLastName());
        courier.setCompanyId(courierModel.getCompanyId());
        injector.getCourierRepository().save(courier);
    }
}
