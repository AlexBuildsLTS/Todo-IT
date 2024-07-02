package se.alex.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskTest {

    private Person creator;
    private TodoItem todoItem;
    private TodoItemTask todoItemTask;

    @BeforeEach
    void setUp() {
        creator = new Person(1, "John", "Doe", "john@example.com");
        todoItem = new TodoItem(1, "Test Task", LocalDate.now().plusDays(1), creator);
        todoItemTask = new TodoItemTask(1, todoItem);
    }

    @Test
    void testConstructor() {
        assertEquals(1, todoItemTask.getId());
        assertEquals(todoItem, todoItemTask.getTodoItem());
        assertFalse(todoItemTask.isAssigned());
        assertNull(todoItemTask.getAssignee());
    }

    @Test
    void testSetAssignee() {
        Person assignee = new Person(2, "Jane", "Doe", "jane@example.com");
        todoItemTask.setAssignee(assignee);
        assertTrue(todoItemTask.isAssigned());
        assertEquals(assignee, todoItemTask.getAssignee());
    }

    @Test
    void testSetAssigneeToNull() {
        Person assignee = new Person(2, "Jane", "Doe", "jane@example.com");
        todoItemTask.setAssignee(assignee);
        assertTrue(todoItemTask.isAssigned());

        todoItemTask.setAssignee(null);
        assertFalse(todoItemTask.isAssigned());
        assertNull(todoItemTask.getAssignee());
    }

    @Test
    void testGetSummary() {
        String expected = String.format("TodoItemTask{id=1, assigned=false, todoItem=%s, assignee=none}", todoItem.getSummary());
        assertEquals(expected, todoItemTask.getSummary());

        Person assignee = new Person(2, "Jane", "Doe", "jane@example.com");
        todoItemTask.setAssignee(assignee);
        expected = String.format("TodoItemTask{id=1, assigned=true, todoItem=%s, assignee=%s}", todoItem.getSummary(), assignee.getSummary());
        assertEquals(expected, todoItemTask.getSummary());
    }
}