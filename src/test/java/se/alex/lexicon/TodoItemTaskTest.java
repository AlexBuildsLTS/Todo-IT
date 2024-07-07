package se.alex.lexicon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskTest {

    @Test
    public void testTodoItemTaskCreation() {
        Person assignee = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, assignee);
        TodoItemTask task = new TodoItemTask(1, item, assignee);
        assertEquals(1, task.getId());
        assertTrue(task.isAssigned());
        assertEquals(item, task.getTodoItem());
        assertEquals(assignee, task.getAssignee());
    }

    @Test
    public void testTodoItemTaskEquals() {
        Person assignee = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, assignee);
        TodoItemTask task1 = new TodoItemTask(1, item, assignee);
        TodoItemTask task2 = new TodoItemTask(1, item, assignee);
        assertEquals(task1, task2);
    }

    @Test
    public void testTodoItemTaskHashCode() {
        Person assignee = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, assignee);
        TodoItemTask task1 = new TodoItemTask(1, item, assignee);
        TodoItemTask task2 = new TodoItemTask(1, item, assignee);
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testTodoItemTaskToString() {
        Person assignee = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        TodoItem item = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(1), false, assignee);
        TodoItemTask task = new TodoItemTask(1, item, assignee);
        String expected = "TodoItemTask{id=1, assigned=true, todoItem=" + item + "}";
        assertEquals(expected, task.toString());
    }
}
