package project.utils;

import project.model.user.User;

public class UserSessionManager {
    private static UserSessionManager instance;
    private User loggedInUser;

    private UserSessionManager() {
        // Private constructor to enforce singleton pattern
    }

    public static synchronized UserSessionManager getInstance() {
        if (instance == null) {
            instance = new UserSessionManager();
        }
        return instance;
    }

    public synchronized void setLoggedInUser(User username) {
        this.loggedInUser = username;
    }

    public synchronized User getLoggedInUser() {
        return loggedInUser;
    }

    public synchronized void clearSession() {
        this.loggedInUser = null;
    }
}

