package se.alex.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        Person person = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        assertEquals(1, person.getId());
        assertEquals("Alex", person.getFirstName());
        assertEquals("Youssef", person.getLastName());
        assertEquals("alex.youssef@example.com", person.getEmail());
    }

    @Test
    public void testPersonSetCredentials() {
        Person person = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        AppUser appUser = new AppUser("alexyoussef", "password", AppRole.ROLE_APP_USER);
        person.setCredentials(appUser);
        assertEquals(appUser, person.getCredentials());
    }

    @Test
    public void testPersonEquals() {
        Person person1 = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        Person person2 = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        assertEquals(person1, person2);
    }

    @Test
    public void testPersonHashCode() {
        Person person1 = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        Person person2 = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void testPersonToString() {
        Person person = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        String expected = "Person{id=1, firstName='Alex', lastName='Youssef', email='alex.youssef@example.com'}";
        assertEquals(expected, person.toString());
    }
}
