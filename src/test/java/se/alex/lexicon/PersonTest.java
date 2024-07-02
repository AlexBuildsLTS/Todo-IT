package se.alex.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testPersonConstructor() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        assertEquals(1, person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("john@example.com", person.getEmail());
    }

    @Test
    void testSetFirstName() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    void testSetFirstNameThrowsException() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName("  "));
    }

    @Test
    void testSetLastName() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test
    void testSetLastNameThrowsException() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        assertThrows(IllegalArgumentException.class, () -> person.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> person.setLastName(""));
        assertThrows(IllegalArgumentException.class, () -> person.setLastName("  "));
    }

    @Test
    void testSetEmail() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        person.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", person.getEmail());
    }

    @Test
    void testSetEmailThrowsException() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        assertThrows(IllegalArgumentException.class, () -> person.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> person.setEmail(""));
        assertThrows(IllegalArgumentException.class, () -> person.setEmail("  "));
    }

    @Test
    void testGetSummary() {
        Person person = new Person(1, "John", "Doe", "john@example.com");
        assertEquals("{id: 1, name: John Doe, email: john@example.com}", person.getSummary());
    }
}