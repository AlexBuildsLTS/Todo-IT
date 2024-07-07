package se.alex.lexicon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    @Test
    public void testTodoItemCreation() {
        Person creator = new Person(1, "Sandra", "Orlovic", "sandra.orlovic@example.com");
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        assertEquals(1, item.getId());
        assertEquals("Change tires", item.getTitle());
        assertEquals("Change car tires to winter tires", item.getDescription());
        assertFalse(item.isDone());
        assertEquals(creator, item.getCreator());
    }

    @Test
    public void testTodoItemIsOverdue() {
        Person creator = new Person(1, "Sandra", "Orlovic", "sandra.orlovic@example.com");
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().minusDays(1), false, creator);
        assertTrue(item.isOverdue());
    }

    @Test
    public void testTodoItemEquals() {
        Person creator = new Person(1, "Sandra", "Orlovic", "sandra.orlovic@example.com");
        TodoItem item1 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        TodoItem item2 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        assertEquals(item1, item2);
    }

    @Test
    public void testTodoItemHashCode() {
        Person creator = new Person(1, "Sandra", "Orlovic", "sandra.orlovic@example.com");
        TodoItem item1 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        TodoItem item2 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        assertEquals(item1.hashCode(), item2.hashCode());
    }

    @Test
    public void testTodoItemToString() {
        Person creator = new Person(1, "Sandra", "Orlovic", "sandra.orlovic@example.com");
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, creator);
        String expected = "TodoItem{id=1, title='Change tires', description='Change car tires to winter tires', deadLine=" + item.getDeadLine() + ", done=false}";
        assertEquals(expected, item.toString());
    }
}
