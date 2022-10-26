package project.courier.data.crud;

import project.courier.data.entity.UserDB;
import project.courier.data.util.DBUtils;

public class AddUserService {
    private final DBUtils dbUtils;

    public AddUserService(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }
    public void addUser(UserDB user){
        try{
            dbUtils.openSession().save(user);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbUtils.closeSession();
    }
}
