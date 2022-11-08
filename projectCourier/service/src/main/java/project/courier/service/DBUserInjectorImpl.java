package project.courier.service;

import project.courier.data.crud.AddUserInterface;
import project.courier.data.crud.AddUserService;
import project.courier.data.util.DBUtils;
import project.courier.service.interfaces.DBUserInjector;

public class DBUserInjectorImpl implements DBUserInjector {
    @Override
    public AddUserInterface getAddUser() {
        return new AddUserService(new DBUtils());
    }
}
