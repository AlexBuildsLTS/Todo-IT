package se.alex.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppUserTest {
    private AppUser appUser;

    @BeforeEach
    void setUp() {
        appUser = new AppUser(1, "alex", "password123", "alex.lexicon@example.com", AppRole.USER);
    }

    @Test
    void testGetId() {
        assertThat(appUser.getId()).isEqualTo(1);
    }

    @Test
    void testGetUsername() {
        assertThat(appUser.getUsername()).isEqualTo("alex");
    }

    @Test
    void testGetPassword() {
        assertThat(appUser.getPassword()).isEqualTo("password123");
    }

    @Test
    void testGetEmail() {
        assertThat(appUser.getEmail()).isEqualTo("alex.lexicon@example.com");
    }

    @Test
    void testGetRole() {
        assertThat(appUser.getRole()).isEqualTo(AppRole.USER);
    }

    @Test
    void testSetId() {
        appUser.setId(2);
        assertThat(appUser.getId()).isEqualTo(2);
    }

    @Test
    void testSetUsername() {
        appUser.setUsername("sandra");
        assertThat(appUser.getUsername()).isEqualTo("sandra");
    }

    @Test
    void testSetPassword() {
        appUser.setPassword("newpassword");
        assertThat(appUser.getPassword()).isEqualTo("newpassword");
    }

    @Test
    void testSetEmail() {
        appUser.setEmail("sandra.rose@example.com");
        assertThat(appUser.getEmail()).isEqualTo("sandra.rose@example.com");
    }

    @Test
    void testSetRole() {
        appUser.setRole(AppRole.ADMIN);
        assertThat(appUser.getRole()).isEqualTo(AppRole.ADMIN);
    }

    @Test
    void testEquals() {
        AppUser anotherUser = new AppUser(1, "alex", "password123", "alex.lexicon@example.com", AppRole.USER);
        assertThat(appUser).isEqualTo(anotherUser);
    }

    @Test
    void testHashCode() {
        AppUser anotherUser = new AppUser(1, "alex", "password123", "alex.lexicon@example.com", AppRole.USER);
        assertThat(appUser.hashCode()).isEqualTo(anotherUser.hashCode());
    }

    @Test
    void testToString() {
        String expected = "AppUser{id=1, username='alex', password='password123', email='alex.lexicon@example.com', role=USER}";
        assertThat(appUser.toString()).isEqualTo(expected);
    }
}
