package project.courier.presentation.services;

import project.courier.service.services.user.LoginUserImpl;
import project.courier.service.services.user.LoginUser;

public class LoginUserInjectorImpl implements LoginUserInjector{
    @Override
    public LoginUser getLogin() {
        return new LoginUserImpl();
    }
}
