package project.courier.service;

import project.courier.data.entity.UserDB;
import project.courier.data.entity.enums.Role;
import project.courier.service.interfaces.DBUserInjector;
import project.courier.service.interfaces.MockAddUserInterface;
import project.courier.service.model.UserModel;
//@NoArgsConstructor
public class MockAddUserOperation implements MockAddUserInterface {
    //private AddUserService addUserService;
//    private AddUserInterface addUserInterface;
//
//    public MockAddUserOperation(AddUserInterface addUserInterface) {
//        this.addUserInterface = addUserInterface;
//    }
    //    public MockAddUserOperation(AddUserService addUserService) {
//        this.addUserService = addUserService;
//    }
//    //private DBUtils dbUtils = new DBUtils();

    public void addAdmin(final UserModel userModel){
        DBUserInjector injector = new DBUserInjectorImpl();
        UserDB admin = new UserDB();
        admin.setUsername(userModel.getUsername());
        admin.setEmail(userModel.getEmail());
        admin.setFirstName(userModel.getFirstName());
        admin.setPassword(userModel.getPassword());
        admin.setLastName(userModel.getLastName());
        admin.setRole(Role.valueOf(userModel.getType()));
        injector.getAddUser().addUser(admin);
//        DBUtils dbUtils = new DBUtils();
//        addUserService = new AddUserService(dbUtils);
//        UserDB admin = new UserDB();
//        admin.setUsername(userModel.getUsername());
//        admin.setEmail(userModel.getEmail());
//        admin.setFirstName(userModel.getFirstName());
//        admin.setPassword(userModel.getPassword());
//        admin.setLastName(userModel.getLastName());
//        admin.setRole(Role.valueOf(userModel.getType()));
//        addUserService.addUser(admin);

    }
}
