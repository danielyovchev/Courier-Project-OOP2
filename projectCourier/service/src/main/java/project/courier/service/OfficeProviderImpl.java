package project.courier.service;

import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.interfaces.OfficeProvider;

import java.util.List;

/**
 * service to provide list of offices
 */
public class OfficeProviderImpl implements OfficeProvider {
    final OfficeRepositoryInjector injector = new OfficeRepositoryInjectorImpl();
    final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
    @Override
    public List<String> getAllOffices(String username) {
        return injector.getOfficeRepository()
                .findAllByCompany(courierRepositoryInjector.getCourierRepository().findByUsername(username).get().getCompanyId()).stream()
                .map(e -> e.getCity()).toList();
    }

    @Override
    public List<String> getOfficesByCity(String city) {
        return injector.getOfficeRepository().findAllByCity(city).stream().map(e -> e.getCity()).toList();
    }
}
