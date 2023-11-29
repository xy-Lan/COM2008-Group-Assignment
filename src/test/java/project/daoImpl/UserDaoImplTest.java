package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.UserDao;
import project.daoimpl.OrderDaoImpl;
import project.daoimpl.UserDaoImpl;
import project.model.user.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @BeforeEach
    public void setUp() {
        userDao = new UserDaoImpl();
    }

    //    @Test
//    public void testAddUser() {
//        // 创建一个用于测试的User对象
//        User user = new User("test@example.com");
//        user.setEmail("test@example.com");
////        user.setPasswordHash("hashed_password");
//        user.setForename("John");
//        user.setSurname("Doe");
//        user.setAddressId(1);
//
//        // 执行添加操作
//        userDao.addUser(user);
//
//    }
//    @Test
//    public void testAddUserPasswordHash() {
//        int userId = 123;
//        String password = "TestPassword123";
//
//        // 调用方法以添加密码哈希
//        userDao.addUserPasswordHash(userId, password);
//
//    }

//    @Test
//    public void testGetUserPasswordHash() {
//        int userId = 123;
//        String expectedHash = "$2a$10$JQaXcUVRR9QZRne6AgvaN.A/cSoF4sCFDTV8.L6Fo9Wx7NlQK1dkS";
//
//        String actualHash = userDao.getUserPasswordHash(userId);
//
//        assertNotNull(actualHash, "Password hash should not be null");
//        assertEquals(expectedHash, actualHash, "Password hash should match the expected value");
//    }
//
//    @Test
//    public void testGetUserByEmail() {
//        String email = "laister.sam@gmail.com";
//        String expectedForeName = "Sam";
//        int expectedUserId = 1;
//
//
//        User user = userDao.getUserByEmail(email);
//
//        assertNotNull(user, "User should not be null for valid email");
//        assertEquals(expectedForeName, user.getForename(), "User name should match the expected value");
//        assertEquals(expectedUserId, user.getUserID(), "User ID should match the expected value");
//    }

}
