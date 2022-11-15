package project.courier.service;

import project.courier.data.repository.UserRepository;
import project.courier.data.repository.UserRepositoryImpl;
import project.courier.data.util.DBUtils;
import project.courier.service.interfaces.UserRepositoryInjector;

public class UserRepositoryInjectorImpl implements UserRepositoryInjector {
    @Override
    public UserRepository userRepository() {
        return new UserRepositoryImpl(new DBUtils());
    }
}
