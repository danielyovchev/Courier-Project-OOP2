package project.courier.presentation.services;

import project.courier.service.services.courier.CourierRegisterImpl;
import project.courier.service.services.courier.CourierRegister;

public class CourierRegisterInjectorImpl implements CourierRegisterInjector {
    @Override
    public CourierRegister register() {
        return new CourierRegisterImpl();
    }
}
