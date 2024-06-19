package com.cinema.Controller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.cinema.Model.userSession;

public class SessionManager {
    public static Map<String, userSession> sessionMap = new HashMap<>();

    public static void addSession(String email, UUID userId, String userName) {
        sessionMap.put(email, new userSession(userId, userName));
    }

    public static void removeSession(String email) {
        sessionMap.remove(email);
    }

    public static boolean isUserLoggedIn(String email) {
        return sessionMap.containsKey(email);
    }

    public static userSession getUserSession(String email) {
        return sessionMap.get(email);
    }

    public static userSession getUserDataFromSession(UUID userId) {
        for (Map.Entry<String, userSession> entry : sessionMap.entrySet()) {
            if (entry.getValue().getUserId().equals(userId)) {
                return entry.getValue();
            }
        }
        return null;
    }

}