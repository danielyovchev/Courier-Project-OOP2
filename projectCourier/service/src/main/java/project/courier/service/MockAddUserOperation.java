package project.courier.service;

import project.courier.data.entity.User;
import project.courier.data.entity.enums.Role;
import project.courier.service.interfaces.UserRepositoryInjector;
import project.courier.service.interfaces.AddUserInterface;
import project.courier.service.model.UserModel;
//@NoArgsConstructor
public class MockAddUserOperation implements AddUserInterface {
    //private UserRepositoryImpl addUserService;
//    private UserRepository addUserInterface;
//
//    public MockAddUserOperation(UserRepository addUserInterface) {
//        this.addUserInterface = addUserInterface;
//    }
    //    public MockAddUserOperation(UserRepositoryImpl addUserService) {
//        this.addUserService = addUserService;
//    }
//    //private DBUtils dbUtils = new DBUtils();

    public void addAdmin(final UserModel userModel){
        UserRepositoryInjector injector = new UserRepositoryInjectorImpl();
        User admin = new User();
        admin.setUsername(userModel.getUsername());
        admin.setEmail(userModel.getEmail());
        admin.setFirstName(userModel.getFirstName());
        admin.setPassword(userModel.getPassword());
        admin.setLastName(userModel.getLastName());
        admin.setRole(Role.valueOf(userModel.getType()));
        injector.userRepository().save(admin);
//        DBUtils dbUtils = new DBUtils();
//        addUserService = new UserRepositoryImpl(dbUtils);
//        User admin = new User();
//        admin.setUsername(userModel.getUsername());
//        admin.setEmail(userModel.getEmail());
//        admin.setFirstName(userModel.getFirstName());
//        admin.setPassword(userModel.getPassword());
//        admin.setLastName(userModel.getLastName());
//        admin.setRole(Role.valueOf(userModel.getType()));
//        addUserService.addUser(admin);

    }
}
