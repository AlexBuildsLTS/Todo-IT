package se.alex.lexicon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    @Test
    public void testTodoItemCreation() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        Person creator = new Person(1, "Alex", "Youssef", "alex.youssef@example.com", user);
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        assertEquals(1, item.getId());
        assertEquals("Change tires", item.getTitle());
        assertEquals("Change car tires to winter tires", item.getDescription());
        assertEquals(LocalDate.now().plusDays(1), item.getDeadLine());
        assertFalse(item.isDone());
        assertEquals(creator, item.getCreator());
    }

    @Test
    public void testTodoItemEquals() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        Person creator = new Person(1, "Alex", "Youssef", "alex.youssef@example.com", user);
        TodoItem item1 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        TodoItem item2 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        assertEquals(item1, item2);
    }

    @Test
    public void testTodoItemHashCode() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        Person creator = new Person(1, "Alex", "Youssef", "alex.youssef@example.com", user);
        TodoItem item1 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        TodoItem item2 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        assertEquals(item1.hashCode(), item2.hashCode());
    }

    @Test
    public void testTodoItemToString() {
        AppUser user = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        Person creator = new Person(1, "Alex", "Youssef", "alex.youssef@example.com", user);
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        String expected = "TodoItem{id=1, title='Change tires', description='Change car tires to winter tires', deadLine=" + LocalDate.now().plusDays(1) + ", done=false, creator=" + creator + "}";
        assertEquals(expected, item.toString());
    }
}
