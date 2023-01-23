package project.courier.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Courier;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.interfaces.CourierRegister;
import project.courier.service.model.CourierModel;

/**
 * service that registers courier
 */
public class CourierRegisterImpl implements CourierRegister {
    private final CourierRepositoryInjector injector = new CourierRepositoryInjectorImpl();
    private final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(CourierRegisterImpl.class);
    @Override
    public void addCourier(CourierModel courierModel) {
        final Long courierId = companyRepositoryInjector.getCompanyRepository().findByName(courierModel.getCompany()).get().getId();
        Courier courier = new Courier();
        courier.setId(courierModel.getId());
        courier.setFirstName(courierModel.getFirstName());
        courier.setLastName(courierModel.getLastName());
        courier.setEmail(courierModel.getEmail());
        courier.setUsername(courierModel.getUsername());
        courier.setCompanyId(courierId);
        injector.getCourierRepository().save(courier);
        logger.info("Courier" + courierModel.getFirstName()+" "+courierModel.getLastName() +"registered");
    }
}
