package project.courier.service.injector;

import project.courier.data.repository.CourierRepository;
import project.courier.data.repository.CourierRepositoryImpl;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;

public class CourierRepositoryInjectorImpl implements CourierRepositoryInjector {
    @Override
    public CourierRepository getCourierRepository() {
        return new CourierRepositoryImpl();
    }
}
