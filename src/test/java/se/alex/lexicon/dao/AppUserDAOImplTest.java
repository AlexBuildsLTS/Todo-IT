package se.alex.lexicon.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.alex.lexicon.dao.impl.AppUserDAOImpl;
import se.alex.lexicon.model.AppUser;
import se.alex.lexicon.model.AppRole;

import static org.assertj.core.api.Assertions.assertThat;

class AppUserDAOImplTest {
    private AppUserDAOImpl appUserDAO;

    @BeforeEach
    void setUp() {
        appUserDAO = AppUserDAOImpl.getInstance();
        appUserDAO.findAll().forEach(appUserDAO::remove); // Clear existing data
    }

    @Test
    void testPersist() {
        AppUser appUser = new AppUser(1, "username", "password", "email@example.com", AppRole.USER);
        appUserDAO.persist(appUser);

        assertThat(appUserDAO.findAll()).hasSize(1);
    }

    @Test
    void testFindById() {
        AppUser appUser = new AppUser(1, "username", "password", "email@example.com", AppRole.USER);
        appUserDAO.persist(appUser);

        AppUser found = appUserDAO.findById(1);
        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("username");
    }

    @Test
    void testFindByUsername() {
        AppUser appUser = new AppUser(1, "username", "password", "email@example.com", AppRole.USER);
        appUserDAO.persist(appUser);

        AppUser found = appUserDAO.findByUsername("username");
        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("username");
    }

    @Test
    void testRemove() {
        AppUser appUser = new AppUser(1, "username", "password", "email@example.com", AppRole.USER);
        appUserDAO.persist(appUser);
        appUserDAO.remove(appUser);

        assertThat(appUserDAO.findAll()).isEmpty();
    }
}
