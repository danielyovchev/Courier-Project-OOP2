package project.courier.service;

import org.junit.jupiter.api.Test;
import project.courier.service.injector.UserRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.UserRepositoryInjector;

import static org.junit.jupiter.api.Assertions.assertEquals;
class LoginUserImplTest {
    private LoginUserImpl loginUser = new LoginUserImpl();
    private UserRepositoryInjector injector = new UserRepositoryInjectorImpl();
    private String username;
    private String password;



    @Test
    void checkLogin() {
        username = "";
        password = "";
        assertEquals("No username", loginUser.checkLogin(username,password));
    }
    @Test
    void checkNoPass(){
        username = "asd";
        password = "";
        assertEquals("No password", loginUser.checkLogin(username,password));
    }
    @Test
    void checkNoUser(){
        username = "asd";
        password = "as";
        assertEquals("Wrong credentials", loginUser.checkLogin(username,password));
    }
    @Test
    void checkAdmin(){
        username = "admin";
        password = "admin";
        assertEquals("admin", loginUser.checkLogin(username,password));
    }
    @Test
    void checkCourier(){
        username = "iv.iv";
        password = "123";
        assertEquals("courier", loginUser.checkLogin(username,password));
    }
    @Test
    void checkCustomer(){
        username = "dad";
        password = "23";
        assertEquals("customer", loginUser.checkLogin(username,password));
    }
}