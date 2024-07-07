package se.alex.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    @Test
    public void testAppUserCreation() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        assertEquals("alexyoussef", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals(AppRole.ROLE_APP_USER, user.getRole());
    }

    @Test
    public void testAppUserSetUsername() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        user.setUsername("newusername");
        assertEquals("newusername", user.getUsername());
    }

    @Test
    public void testAppUserSetPassword() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testAppUserSetRole() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        user.setRole(AppRole.ROLE_APP_ADMIN);
        assertEquals(AppRole.ROLE_APP_ADMIN, user.getRole());
    }

    @Test
    public void testAppUserEqualsAndHashCode() {
        AppUser user1 = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("sandraorovic", "password456", AppRole.ROLE_APP_USER);
        AppUser user3 = new AppUser("adminpass", "adminpass", AppRole.ROLE_APP_ADMIN);

        assertEquals(user1, user2); // Same username and role
        assertNotEquals(user1, user3); // Different username and role
        assertEquals(user1.hashCode(), user2.hashCode());
        assertNotEquals(user1.hashCode(), user3.hashCode());
    }

    @Test
    public void testAppUserToString() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        String expected = "AppUser{username='alexyoussef', role=ROLE_APP_USER}";
        assertEquals(expected, user.toString());
    }

    @Test
    public void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppUser(null, "password123", AppRole.ROLE_APP_USER);
        });
        assertEquals("Username cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppUser("", "password123", AppRole.ROLE_APP_USER);
        });
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppUser("alexyoussef", null, AppRole.ROLE_APP_USER);
        });
        assertEquals("Password cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppUser("alexyoussef", "", AppRole.ROLE_APP_USER);
        });
        assertEquals("Password cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testInvalidRole() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppUser("alexyoussef", "password123", null);
        });
        assertEquals("Role cannot be null", exception.getMessage());
    }
}
