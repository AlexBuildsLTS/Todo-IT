package se.alex.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TodoItemTaskTest {
    private TodoItemTask todoItemTask;
    private TodoItem todoItem;
    private Person assignee;

    @BeforeEach
    void setUp() {
        assignee = new Person(1, "Alex", "Lexicon", "alex.lexicon@example.com");
        todoItem = new TodoItem(1, "Title", "Description", java.time.LocalDate.now(), assignee);
        todoItemTask = new TodoItemTask(1, todoItem, assignee, true);
    }

    @Test
    void testGetId() {
        assertThat(todoItemTask.getId()).isEqualTo(1);
    }

    @Test
    void testGetTodoItem() {
        assertThat(todoItemTask.getTodoItem()).isEqualTo(todoItem);
    }

    @Test
    void testGetAssignee() {
        assertThat(todoItemTask.getAssignee()).isEqualTo(assignee);
    }

    @Test
    void testIsAssigned() {
        assertThat(todoItemTask.isAssigned()).isTrue();
    }

    @Test
    void testSetId() {
        todoItemTask.setId(2);
        assertThat(todoItemTask.getId()).isEqualTo(2);
    }

    @Test
    void testSetTodoItem() {
        TodoItem newTodoItem = new TodoItem(2, "New Title", "New Description", java.time.LocalDate.now(), assignee);
        todoItemTask.setTodoItem(newTodoItem);
        assertThat(todoItemTask.getTodoItem()).isEqualTo(newTodoItem);
    }

    @Test
    void testSetAssignee() {
        Person newAssignee = new Person(2, "Sandra", "Rose", "sandra.rose@example.com");
        todoItemTask.setAssignee(newAssignee);
        assertThat(todoItemTask.getAssignee()).isEqualTo(newAssignee);
    }

    @Test
    void testSetAssigned() {
        todoItemTask.setAssigned(false);
        assertThat(todoItemTask.isAssigned()).isFalse();
    }

    @Test
    void testEquals() {
        TodoItemTask anotherTask = new TodoItemTask(1, todoItem, assignee, true);
        assertThat(todoItemTask).isEqualTo(anotherTask);
    }

    @Test
    void testHashCode() {
        TodoItemTask anotherTask = new TodoItemTask(1, todoItem, assignee, true);
        assertThat(todoItemTask.hashCode()).isEqualTo(anotherTask.hashCode());
    }

    @Test
    void testToString() {
        String expected = "TodoItemTask{id=1, todoItem=" + todoItem.toString() + ", assignee=" + assignee.toString() + ", assigned=true}";
        assertThat(todoItemTask.toString()).isEqualTo(expected);
    }
}
