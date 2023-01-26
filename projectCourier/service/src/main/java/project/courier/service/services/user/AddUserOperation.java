package project.courier.service.services.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.User;
import project.courier.data.entity.enums.Role;
import project.courier.service.exceptions.UserExistsException;
import project.courier.service.injector.UserRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.UserRepositoryInjector;
import project.courier.service.model.UserModel;

/**
 * adds new user to db
 */
public class AddUserOperation implements AddUserInterface {
    private final UserRepositoryInjector injector = new UserRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(AddUserOperation.class);
    public void addUser(final UserModel userModel){
        boolean exists = injector.userRepository().existsByUsername(userModel.getUsername());
        if(exists){
            throw new UserExistsException();
        }
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setPassword(userModel.getPassword());
        user.setLastName(userModel.getLastName());
        user.setRole(Role.valueOf(userModel.getType().toUpperCase()));
        injector.userRepository().save(user);
        logger.info("User {} saved", userModel.getUsername());
    }
}
