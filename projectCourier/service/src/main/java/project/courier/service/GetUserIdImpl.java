package project.courier.service;

import project.courier.service.injector.UserRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.UserRepositoryInjector;
import project.courier.service.interfaces.GetUserId;

public class GetUserIdImpl implements GetUserId {
    @Override
    public Long getId(String username) {
       final UserRepositoryInjector userRepositoryInjector= new UserRepositoryInjectorImpl();
       return userRepositoryInjector.userRepository().findByUsername(username).get().getId();
    }
}
