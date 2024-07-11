package se.alex.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(1, "Alex", "Lexicon", "alex.lexicon@example.com");
    }

    @Test
    void testGetId() {
        assertThat(person.getId()).isEqualTo(1);
    }

    @Test
    void testGetFirstName() {
        assertThat(person.getFirstName()).isEqualTo("Alex");
    }

    @Test
    void testGetLastName() {
        assertThat(person.getLastName()).isEqualTo("Lexicon");
    }

    @Test
    void testGetEmail() {
        assertThat(person.getEmail()).isEqualTo("alex.lexicon@example.com");
    }

    @Test
    void testSetId() {
        person.setId(2);
        assertThat(person.getId()).isEqualTo(2);
    }

    @Test
    void testSetFirstName() {
        person.setFirstName("Sandra");
        assertThat(person.getFirstName()).isEqualTo("Sandra");
    }

    @Test
    void testSetLastName() {
        person.setLastName("Rose");
        assertThat(person.getLastName()).isEqualTo("Rose");
    }

    @Test
    void testSetEmail() {
        person.setEmail("sandra.rose@example.com");
        assertThat(person.getEmail()).isEqualTo("sandra.rose@example.com");
    }

    @Test
    void testEquals() {
        Person anotherPerson = new Person(1, "Alex", "Lexicon", "alex.lexicon@example.com");
        assertThat(person).isEqualTo(anotherPerson);
    }

    @Test
    void testHashCode() {
        Person anotherPerson = new Person(1, "Alex", "Lexicon", "alex.lexicon@example.com");
        assertThat(person.hashCode()).isEqualTo(anotherPerson.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Person{id=1, firstName='Alex', lastName='Lexicon', email='alex.lexicon@example.com'}";
        assertThat(person.toString()).isEqualTo(expected);
    }
}
