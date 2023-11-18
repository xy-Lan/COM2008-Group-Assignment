package project.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {
    /**
     * Hashes a password using BCrypt's hashing algorithm.
     *
     * @param password the password to hash
     * @return a hashed version of the password
     */
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Verifies a password against a given hashed password.
     *
     * @param password       the password to verify
     * @param hashedPassword the hashed password to compare against
     * @return true if the password matches the hashed password, false otherwise
     */
    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    // Example usage
    public static void main(String[] args) {
        // Hash a password
        String originalPassword = "mysecretpassword";
        String hashedPassword = hashPassword(originalPassword);
        System.out.println("Hashed Password: " + hashedPassword);

        // Verify the password
        boolean isMatch = verifyPassword(originalPassword, hashedPassword);
        System.out.println("Password verification result: " + isMatch);
    }
}
