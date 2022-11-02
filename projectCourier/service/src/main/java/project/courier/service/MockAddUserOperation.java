package project.courier.service;

import lombok.NoArgsConstructor;
import project.courier.data.crud.AddUserService;
import project.courier.data.entity.UserDB;
import project.courier.data.entity.enums.Role;
import project.courier.data.util.DBUtils;
import project.courier.service.interfaces.MockAddUserInterface;
import project.courier.service.model.UserModel;
//@NoArgsConstructor
public class MockAddUserOperation implements MockAddUserInterface {
    private AddUserService addUserService;

//    public MockAddUserOperation(AddUserService addUserService) {
//        this.addUserService = addUserService;
//    }
//    //private DBUtils dbUtils = new DBUtils();

    public void addAdmin(final UserModel userModel){
        DBUtils dbUtils = new DBUtils();
        addUserService = new AddUserService(dbUtils);
        UserDB admin = new UserDB();
        admin.setUsername(userModel.getUsername());
        admin.setEmail(userModel.getEmail());
        admin.setFirstName(userModel.getFirstName());
        admin.setPassword(userModel.getPassword());
        admin.setLastName(userModel.getLastName());
        admin.setRole(Role.valueOf(userModel.getType()));
        addUserService.addUser(admin);

    }
}
