package project.courier.service;

import project.courier.data.entity.User;
import project.courier.service.interfaces.LoginUser;
import project.courier.service.interfaces.UserRepositoryInjector;

import java.util.Optional;

public class LoginUserImpl implements LoginUser {
    @Override
    public String checkLogin(String username, String password) {
        String result="";
        UserRepositoryInjector injector = new UserRepositoryInjectorImpl();
        final Optional<User> user = injector.userRepository().findByUserAndPass(username, password);
        if(user.isEmpty()){
            result = "undefined";
            return result;
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
