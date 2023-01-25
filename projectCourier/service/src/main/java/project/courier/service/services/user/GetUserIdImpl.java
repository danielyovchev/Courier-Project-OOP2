package project.courier.service.services.user;

import project.courier.service.injector.UserRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.UserRepositoryInjector;

/**
 * service to get id of user
 */
public class GetUserIdImpl implements GetUserId {
    private final UserRepositoryInjector userRepositoryInjector= new UserRepositoryInjectorImpl();
    @Override
    public Long getId(String username) {
        return userRepositoryInjector.userRepository().findByUsername(username).get().getId();
    }
}
