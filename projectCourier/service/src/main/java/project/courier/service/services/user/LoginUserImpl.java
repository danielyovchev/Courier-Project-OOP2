package project.courier.service.services.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.User;
import project.courier.service.injector.UserRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.UserRepositoryInjector;

import java.util.Optional;

/**
 * service that checks if the user exists,
 */
public class LoginUserImpl implements LoginUser {
    private final UserRepositoryInjector injector = new UserRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(LoginUserImpl.class);
    @Override
    public String checkLogin(String username, String password) {
        String result="";
        final Optional<User> user = injector.userRepository().findByUserAndPass(username, password);
        if(username.isEmpty()) {
            logger.error("No username");
            return "No username";
        }
        if(password.isEmpty()) {
            return "No password";
        }
        if(user.isEmpty()){
            logger.warn("No user found");
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
        logger.info("Logged {}", username);
        return result;
    }
}
