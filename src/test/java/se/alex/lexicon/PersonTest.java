package se.alex.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testPersonConstructor() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        assertEquals(1, person.getId());
        assertEquals("Alex", person.getFirstName());
        assertEquals("Lexicon", person.getLastName());
        assertEquals("alex@example.com", person.getEmail());
    }

    @Test
    void testSetFirstName() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        person.setFirstName("Stefan");
        assertEquals("Stefan", person.getFirstName());
    }

    @Test
    void testSetFirstNameThrowsException() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName("  "));
    }

    @Test
    void testSetLastName() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        person.setLastName("lexi");
        assertEquals("lexi", person.getLastName());
    }

    @Test
    void testSetLastNameThrowsException() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        assertThrows(IllegalArgumentException.class, () -> person.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> person.setLastName(""));
        assertThrows(IllegalArgumentException.class, () -> person.setLastName("  "));
    }

    @Test
    void testSetEmail() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        person.setEmail("alex.youssef@live.com");
        assertEquals("alex.youssef@live.com", person.getEmail());
    }

    @Test
    void testSetEmailThrowsException() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        assertThrows(IllegalArgumentException.class, () -> person.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> person.setEmail(""));
        assertThrows(IllegalArgumentException.class, () -> person.setEmail("  "));
    }

    @Test
    void testGetSummary() {
        Person person = new Person(1, "Alex", "Lexicon", "alex@example.com");
        assertEquals("{id: 1, name: Alex Lexicon, email: alex@example.com}", person.getSummary());
    }


}
