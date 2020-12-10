package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
public class SecurityConfig {
 
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
 
    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();
 
    static {
        init();
    }
 
    private static void init() {
 
        // "USER" config
        List<String> urlPatterns1 = new ArrayList<String>();
 
        urlPatterns1.add("/userInfo");
        urlPatterns1.add("/userTask");
 
        mapConfig.put(ROLE_USER, urlPatterns1);
 
        //  "ADMIN" config
        List<String> urlPatterns2 = new ArrayList<String>();
 
        urlPatterns2.add("/userInfo");
        urlPatterns2.add("/adminTask");
 
        mapConfig.put(ROLE_ADMIN, urlPatterns2);
    }
 
    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }
 
    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
 
}