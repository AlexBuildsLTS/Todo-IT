package se.alex.lexicon;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testAppFunctionality() {
        // Create AppUsers
        AppUser user1 = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        AppUser admin1 = new AppUser("sandraorlovic", "adminpass", AppRole.ROLE_APP_ADMIN);

        // Create Persons
        Person alex = new Person(1, "Alex", "Youssef", "alex.youssef@example.com", user1);
        Person sandra = new Person(2, "Sandra", "Orlovic", "sandra.orlovic@example.com", admin1);

        // Create TodoItems
        TodoItem todo1 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(10), false, alex);
        TodoItem todo2 = new TodoItem(2, "Review budget", "Review the quarterly budget report", LocalDate.now().plusDays(5), false, sandra);

        // Create TodoItemTasks
        TodoItemTask task1 = new TodoItemTask(1, todo1, alex);
        TodoItemTask task2 = new TodoItemTask(2, todo2, sandra);

        // Verify AppUser details
        assertEquals("alexyoussef", user1.getUsername());
        assertEquals(AppRole.ROLE_APP_USER, user1.getRole());
        assertEquals("sandraorlovic", admin1.getUsername());
        assertEquals(AppRole.ROLE_APP_ADMIN, admin1.getRole());

        // Verify Person details
        assertEquals("Alex", alex.getFirstName());
        assertEquals("Youssef", alex.getLastName());
        assertEquals("alex.youssef@example.com", alex.getEmail());
        assertEquals(user1, alex.getCredentials());

        assertEquals("Sandra", sandra.getFirstName());
        assertEquals("Orlovic", sandra.getLastName());
        assertEquals("sandra.orlovic@example.com", sandra.getEmail());
        assertEquals(admin1, sandra.getCredentials());

        // Verify TodoItem details
        assertEquals("Change tires", todo1.getTitle());
        assertEquals("Change car tires to winter tires", todo1.getDescription());
        assertEquals(alex, todo1.getCreator());

        assertEquals("Review budget", todo2.getTitle());
        assertEquals("Review the quarterly budget report", todo2.getDescription());
        assertEquals(sandra, todo2.getCreator());

        // Verify TodoItemTask details
        assertEquals(todo1, task1.getTodoItem());
        assertEquals(alex, task1.getAssignee());
        assertTrue(task1.isAssigned());

        assertEquals(todo2, task2.getTodoItem());
        assertEquals(sandra, task2.getAssignee());
        assertTrue(task2.isAssigned());
    }
}
