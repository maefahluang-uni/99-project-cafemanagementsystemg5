package th.mfu.Repository;

import th.mfu.Domain.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("Admin", "1234");
        USERS.put("Barista", "1234");
    }

    public static boolean isValidUser(String username, String password) {
        return USERS.containsKey(username) && USERS.get(username).equals(password);
    }
}