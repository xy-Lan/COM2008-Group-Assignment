package project.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import project.utils.PasswordUtils;

public class LoginTest {
    @Test
    public void testLogin() {
        String plaintextPassword = "testPassword123";

        String hashedPassword = PasswordUtils.hashPassword(plaintextPassword);

        String simulatedStoredHash = hashedPassword;

        boolean loginResult = PasswordUtils.checkPassword("a", "$2a$10$CnP5T/Y52YOjNwtO54snLeD101xXlm.bi2wHoEUVTFMugNEjT9OBm");

        assertTrue(loginResult, "Login should succeed with correct password");
    }


}
