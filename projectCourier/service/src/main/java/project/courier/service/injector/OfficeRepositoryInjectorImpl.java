package project.courier.service.injector;

import project.courier.data.repository.OfficeRepository;
import project.courier.data.repository.OfficeRepositoryImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;

public class OfficeRepositoryInjectorImpl implements OfficeRepositoryInjector {
    @Override
    public OfficeRepository getOfficeRepository() {
        return new OfficeRepositoryImpl();
    }
}
