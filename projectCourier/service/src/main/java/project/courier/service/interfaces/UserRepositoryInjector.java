package project.courier.service.interfaces;

import project.courier.data.repository.UserRepository;

public interface UserRepositoryInjector {
    UserRepository userRepository();
}
