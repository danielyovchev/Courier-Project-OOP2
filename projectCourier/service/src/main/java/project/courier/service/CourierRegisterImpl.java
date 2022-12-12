package project.courier.service;

import project.courier.data.entity.Courier;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.interfaces.CourierRegister;
import project.courier.service.model.CourierModel;

public class CourierRegisterImpl implements CourierRegister {
    @Override
    public void addCourier(CourierModel courierModel) {
        final CourierRepositoryInjector injector = new CourierRepositoryInjectorImpl();
        final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
        final Long courierId = companyRepositoryInjector.getCompanyRepository().findByName(courierModel.getCompany()).get().getId();
        Courier courier = new Courier();
        courier.setFirstName(courierModel.getFirstName());
        courier.setLastName(courierModel.getLastName());
        courier.setEmail(courier.getEmail());
        courier.setCompanyId(courierId);
        injector.getCourierRepository().save(courier);
    }
}
