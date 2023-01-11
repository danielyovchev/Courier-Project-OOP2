package project.courier.service;

import project.courier.data.entity.User;
import project.courier.service.injector.UserRepositoryInjectorImpl;
import project.courier.service.interfaces.LoginUser;
import project.courier.service.injector.interfaces.UserRepositoryInjector;

import java.util.Optional;

public class LoginUserImpl implements LoginUser {
    @Override
    public String checkLogin(String username, String password) {
        String result="";
        final UserRepositoryInjector injector = new UserRepositoryInjectorImpl();
        final Optional<User> user = injector.userRepository().findByUserAndPass(username, password);

        if(username.isEmpty())
        {
            return "No username";
        }
        if(password.isEmpty())
        {
            return "No password";
        }
        if(user.isEmpty()){
            return "Wrong credentials";
        }
        String role = String.valueOf(user.get().getRole());
        if(role.equalsIgnoreCase("admin")){
            result = "admin";
        } else if (role.equalsIgnoreCase("courier")) {
            result = "courier";
        } else if (role.equalsIgnoreCase("customer")) {
            result = "customer";
        }
        return result;
    }
}
