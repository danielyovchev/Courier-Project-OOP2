package project.courier.data.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.courier.data.entity.User;
import project.courier.data.util.DBUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Transactional(rollbackOn = {})
class UserRepositoryTest {
    private final DBUtils dbUtils = new DBUtils();
    private UserRepository userRepository = new UserRepositoryImpl();
    private User user;
    @BeforeEach
    void setUp(){
        this.user = new User();
    }
    @Test
    void saveAndDelete() {
        List<User> userList = userRepository.findAll();
        userRepository.save(user);
        assertNotEquals(userList, userRepository.findAll());
        userRepository.delete(user);
        assertEquals(userList, userRepository.findAll());
    }

    @Test
    void update() {
        List<User> userList = userRepository.findAll();
        User user1 = userRepository.findById(Long.valueOf(1)).get();
        user1.setEmail("admin@admin.bg");
        userRepository.update(user1);
        assertEquals(userList, userRepository.findAll());
    }
    @Test
    void findById() {
        List<User> userList = userRepository.findById(1L).stream().toList();
        assertEquals(1, userList.size());
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