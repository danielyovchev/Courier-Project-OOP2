package project.courier.presentation.services;

import project.courier.service.LoginUserImpl;
import project.courier.service.interfaces.LoginUser;

public class LoginUserInjectorImpl implements LoginUserInjector{
    @Override
    public LoginUser getLogin() {
        return new LoginUserImpl();
    }
}
