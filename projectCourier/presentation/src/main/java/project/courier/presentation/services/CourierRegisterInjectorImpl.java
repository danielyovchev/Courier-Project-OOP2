package project.courier.presentation.services;

import project.courier.service.CourierRegisterImpl;
import project.courier.service.interfaces.CourierRegister;

public class CourierRegisterInjectorImpl implements CourierRegisterInjector {
    @Override
    public CourierRegister register() {
        return new CourierRegisterImpl();
    }
}
