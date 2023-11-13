package project.utils;

public class UserSessionManager {
    private static UserSessionManager instance;
    private String loggedInUser;

    private UserSessionManager() {
        // Private constructor to enforce singleton pattern
    }

    public static synchronized UserSessionManager getInstance() {
        if (instance == null) {
            instance = new UserSessionManager();
        }
        return instance;
    }

    public synchronized void setLoggedInUser(String username) {
        this.loggedInUser = username;
    }

    public synchronized String getLoggedInUser() {
        return loggedInUser;
    }

    public synchronized void clearSession() {
        this.loggedInUser = null;
    }
}

