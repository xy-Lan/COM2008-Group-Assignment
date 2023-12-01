package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.UserDao;
import project.daoimpl.UserDaoImpl;
import project.model.user.Role;
import project.model.user.User;
import project.utils.PasswordUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @BeforeEach
    public void setUp() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void testUpdateUserPasswordHash() {
        int userId = 123;
        String newPassword = "newPassword123";

        Boolean updateResult = userDao.updateUserPasswordHash(userId, newPassword);
        assertTrue(updateResult, "Password hash should be updated successfully");
    }

    @Test
    public void testAddUserPasswordHash()  {
        int userId = 1;
        String password = "testPassword"; // 测试用的密码

        userDao.addUserPasswordHash(userId,password);
    }

//    @Test
//    public void testAddUserRole() {
//        int userId = 2;
//        Role testRole = Role.MANAGER;
//
//        userDao.addUserRole(userId, testRole);
//
//        List<Role> roles = userDao.getUserRoles(userId);
//        assertTrue(roles.contains(testRole), "User should have the assigned role");
//    }

//    @Test
//    public void testRemoveUserRole() {
//        int userId = 2; // 插入一个测试用户并为其分配角色
//        Role testRole = Role.CUSTOMER; // 假设的角色
//
//        // 验证用户初始是否拥有该角色
//        assertTrue(userDao.getUserRoles(userId).contains(testRole), "User should initially have the role");
//
//        // 执行移除用户角色操作
//        userDao.removeUserRole(userId, testRole);
//
//        // 验证用户角色是否已被移除
//        assertFalse(userDao.getUserRoles(userId).contains(testRole), "User should no longer have the role after removal");
//    }

        @Test
    public void testAddUser() {
        // 创建一个用于测试的User对象
        User user = new User("test4@example.com");
        user.setEmail("test4@example.com");
//        user.setPasswordHash("hashed_password");
        user.setForename("Erin");
        user.setSurname("Doe");
        user.setAddressId(1);

        // 执行添加操作
        userDao.addUser(user);

    }
//    @Test
//    public void testAddUserPasswordHash() {
//        int userId = 129;
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
//@Test
//public void testGetAllUsers() {
//    List<User> users = userDao.getAllUsers();
//
//    assertNotNull(users, "User list should not be null");
//    assertFalse(users.isEmpty(), "User list should not be empty");
//
//    int i =0;
//    for (User user : users) {
//        i++;
//        assertNotNull(user.getEmail(), "User email should not be null");
//        assertNotNull(user.getEmail(), "User email should not be null");
//    }
//    System.out.println(i);
//}

//    @Test
//    public void testUpdateUser() {
//        int userId = 2; // 已知的用户 ID
//        User user = new User(2);
//        user.setUserID(userId);
//        user.setEmail("updated@example.com");
//        user.setForename("UpdatedForename2");
//        user.setSurname("UpdatedSurname");
//        user.setAddressId(1); // 假设的新地址 ID
//
//        // 执行更新操作
//        userDao.updateUser(user);
//
//        // 重新从数据库获取更新后的用户信息
//        User updatedUser = userDao.getUserById(userId).get();
//        System.out.println("Forename is "+updatedUser.getForename());
//        assertNotNull(updatedUser, "User should not be null after update");
//        assertEquals("updated@example.com", updatedUser.getEmail(), "Email should be updated");
//        assertEquals("UpdatedForename2", updatedUser.getForename(), "Forename should be updated");
//        assertEquals("UpdatedSurname", updatedUser.getSurname(), "Surname should be updated");
//
//    }
//@Test
//public void testDeleteUser() {
//    int userId = 3;
//
//    userDao.deleteUser(userId);
//
//    Optional<User> user = userDao.getUserById(userId);
//    assertFalse(user.isPresent(), "User should not be present after deletion");
//}
//@Test
//public void testGetUserRoles() {
//    int userId = 2; // 插入一个测试用户并设置其角色，返回用户 ID
//
//    // 调用方法获取用户角色列表
//    List<Role> roles = userDao.getUserRoles(userId);
//
//    assertNotNull(roles, "Roles list should not be null");
//    assertFalse(roles.isEmpty(), "Roles list should not be empty");
//
//    // 验证返回的角色列表是否包含预期的角色
//    assertTrue(roles.contains(Role.CUSTOMER), "User should have CUSTOMER role");
//    assertTrue(roles.contains(Role.STAFF), "User should have STAFF role");
//    // 验证其他预期的角色...
//}
}
