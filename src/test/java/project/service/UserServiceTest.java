package project.service;

import org.junit.jupiter.api.Test;
import project.dao.UserDao;
import project.daoimpl.UserDaoImpl;
import project.model.user.Role;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserDao userDao = new UserDaoImpl();

    private UserService userService = new UserService(userDao);

//    @Test
//    void testIsUserManager_WhenManager() {
//        System.out.println("it is "+userService.isUserStaff(2));
//        System.out.println("it is "+userService.isUserStaff(148));
//    }

}
