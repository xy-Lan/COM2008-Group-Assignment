package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.UserDao;
import project.daoimpl.OrderDaoImpl;
import project.daoimpl.UserDaoImpl;
import project.model.user.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @BeforeEach
    public void setUp() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void testAddUser() {
        // 创建一个用于测试的User对象
        User user = new User("test@example.com");
        user.setEmail("test@example.com");
//        user.setPasswordHash("hashed_password");
        user.setForename("John");
        user.setSurname("Doe");
        user.setHouseNumber("123");
        user.setPostCode("AB12CD");

        // 执行添加操作
        userDao.addUser(user);

    }
}
