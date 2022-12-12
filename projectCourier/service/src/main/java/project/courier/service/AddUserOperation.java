package project.courier.service;

import project.courier.data.entity.User;
import project.courier.data.entity.enums.Role;
import project.courier.service.injector.UserRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.UserRepositoryInjector;
import project.courier.service.interfaces.AddUserInterface;
import project.courier.service.model.UserModel;
public class AddUserOperation implements AddUserInterface {


    public void addUser(final UserModel userModel){
        final UserRepositoryInjector injector = new UserRepositoryInjectorImpl();
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setPassword(userModel.getPassword());
        user.setLastName(userModel.getLastName());
        user.setRole(Role.valueOf(userModel.getType().toUpperCase()));
        injector.userRepository().save(user);
        if(userModel.getType().equalsIgnoreCase("courier")){

        } else if (userModel.getType().equalsIgnoreCase("customer")) {

        }
    }
}
