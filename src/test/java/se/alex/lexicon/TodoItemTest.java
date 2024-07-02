package se.alex.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    private Person creator;
    private TodoItem todoItem;

    @BeforeEach
    void setUp() {
        creator = new Person(1, "John", "Doe", "john@example.com");
        todoItem = new TodoItem(1, "Test Task", LocalDate.now().plusDays(1), creator);
    }

    @Test
    void testConstructor() {
        assertEquals(1, todoItem.getId());
        assertEquals("Test Task", todoItem.getTitle());
        assertEquals(LocalDate.now().plusDays(1), todoItem.getDeadLine());
        assertEquals(creator, todoItem.getCreator());
        assertFalse(todoItem.isDone());
    }

    @Test
    void testSetTitle() {
        todoItem.setTitle("New Title");
        assertEquals("New Title", todoItem.getTitle());
    }

    @Test
    void testSetTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> todoItem.setTitle(null));
        assertThrows(IllegalArgumentException.class, () -> todoItem.setTitle(""));
        assertThrows(IllegalArgumentException.class, () -> todoItem.setTitle("  "));
    }

    @Test
    void testSetDescription() {
        todoItem.setDescription("This is a test description");
        assertEquals("This is a test description", todoItem.getDescription());
    }

    @Test
    void testSetDeadLine() {
        LocalDate newDeadline = LocalDate.now().plusDays(7);
        todoItem.setDeadLine(newDeadline);
        assertEquals(newDeadline, todoItem.getDeadLine());
    }

    @Test
    void testSetDeadLineThrowsException() {
        assertThrows(NullPointerException.class, () -> todoItem.setDeadLine(null));
    }

    @Test
    void testIsOverdue() {
        assertFalse(todoItem.isOverdue());
        todoItem.setDeadLine(LocalDate.now().minusDays(1));
        assertTrue(todoItem.isOverdue());
    }

    @Test
    void testGetSummary() {
        String expected = String.format("TodoItem{id=1, title='Test Task', description='null', deadLine=%s, done=false, creator=%s}",
                todoItem.getDeadLine(), creator.getSummary());
        assertEquals(expected, todoItem.getSummary());
    }
}