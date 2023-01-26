package project.courier.service.services.office;

import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;

import java.util.List;

/**
 * service to provide list of offices
 */
public class OfficeProviderImpl implements OfficeProvider {
    private final OfficeRepositoryInjector injector = new OfficeRepositoryInjectorImpl();
    private final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
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
