package se.alex.lexicon.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.alex.lexicon.dao.impl.PersonDAOImpl;
import se.alex.lexicon.model.Person;

import static org.assertj.core.api.Assertions.assertThat;

class PersonDAOImplTest {
    private PersonDAOImpl personDAO;

    @BeforeEach
    void setUp() {
        personDAO = PersonDAOImpl.getInstance();
        personDAO.findAll().forEach(personDAO::remove); // Clear existing data
    }

    @Test
    void testPersist() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        personDAO.persist(person);

        assertThat(personDAO.findAll()).hasSize(1);
    }

    @Test
    void testFindById() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        personDAO.persist(person);

        Person found = personDAO.findById(1);
        assertThat(found).isNotNull();
        assertThat(found.getFirstName()).isEqualTo("John");
    }

    @Test
    void testFindByEmail() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        personDAO.persist(person);

        Person found = personDAO.findByEmail("john.doe@example.com");
        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo("john.doe@example.com");
    }

    @Test
    void testRemove() {
        Person person = new Person(1, "John", "Doe", "john.doe@example.com");
        personDAO.persist(person);
        personDAO.remove(person);

        assertThat(personDAO.findAll()).isEmpty();
    }
}
