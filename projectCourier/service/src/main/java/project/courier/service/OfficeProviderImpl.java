package project.courier.service;

import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.interfaces.OfficeProvider;

import java.util.List;

/**
 * service to provide list of offices
 */
public class OfficeProviderImpl implements OfficeProvider {
    final OfficeRepositoryInjector injector = new OfficeRepositoryInjectorImpl();
    @Override
    public List<String> getAllOffices() {
        return injector.getOfficeRepository().findAll().stream().map(e -> e.getCity()).toList();
    }

    @Override
    public List<String> getOfficesByCity(String city) {
        return injector.getOfficeRepository().findAllByCity(city).stream().map(e -> e.getCity()).toList();
    }
}
