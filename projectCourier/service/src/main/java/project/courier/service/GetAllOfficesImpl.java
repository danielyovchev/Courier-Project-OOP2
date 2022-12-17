package project.courier.service;

import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.interfaces.GetAllOffices;

import java.util.List;

public class GetAllOfficesImpl implements GetAllOffices {
    @Override
    public List<String> getOfficesByCity(String city) {
        final OfficeRepositoryInjector injector = new OfficeRepositoryInjectorImpl();
        return injector.getOfficeRepository().findAllByCity(city).stream().map(e -> e.getCity()).toList();
    }
}
