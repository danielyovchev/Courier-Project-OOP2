package project.courier.data.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.courier.data.entity.User;
import project.courier.data.util.DBUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private final DBUtils dbUtils = new DBUtils();
    private UserRepository userRepository = new UserRepositoryImpl(dbUtils);
    private User user;
    @BeforeEach
    void setUp(){
        this.user = new User();
    }
    @Test
    void save() {
        List<User> userList = userRepository.findAll();
        userRepository.save(user);
        assertNotEquals(userList, userRepository.findAll());
    }

    @Test
    void update() {
        List<User> userList = userRepository.findAll();
        User user1 = userRepository.findById(Long.valueOf(102)).get();
        user1.setEmail("asdasd");
        userRepository.update(user1);
        assertEquals(userList, userRepository.findAll());
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        List<User> userList = userRepository.findAll();
        List<User> userList2 = userRepository.findAll();
        assertEquals(userList,userList2);
    }

    @Test
    void existsByUsername() {
        assertTrue(userRepository.existsByUsername("admin"));
    }
}