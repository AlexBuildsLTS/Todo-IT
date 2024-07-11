package se.alex.lexicon.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.alex.lexicon.dao.impl.TodoItemTaskDAOImpl;
import se.alex.lexicon.model.Person;
import se.alex.lexicon.model.TodoItem;
import se.alex.lexicon.model.TodoItemTask;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class TodoItemTaskDAOImplTest {
    private TodoItemTaskDAOImpl todoItemTaskDAO;
    private TodoItem todoItem;
    private Person assignee;

    @BeforeEach
    void setUp() {
        todoItemTaskDAO = TodoItemTaskDAOImpl.getInstance();
        todoItemTaskDAO.findAll().forEach(todoItemTaskDAO::remove); // Clear existing data

        assignee = new Person(1, "John", "Doe", "john.doe@example.com");
        todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), assignee);
    }

    @Test
    void testPersist() {
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee, true);
        todoItemTaskDAO.persist(todoItemTask);

        assertThat(todoItemTaskDAO.findAll()).hasSize(1);
    }

    @Test
    void testFindById() {
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee, true);
        todoItemTaskDAO.persist(todoItemTask);

        TodoItemTask found = todoItemTaskDAO.findById(1);
        assertThat(found).isNotNull();
        assertThat(found.getTodoItem()).isEqualTo(todoItem);
    }

    @Test
    void testFindByAssignedStatus() {
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee, true);
        todoItemTaskDAO.persist(todoItemTask);

        assertThat(todoItemTaskDAO.findByAssignedStatus(true)).hasSize(1);
        assertThat(todoItemTaskDAO.findByAssignedStatus(false)).isEmpty();
    }

    @Test
    void testFindByPersonId() {
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee, true);
        todoItemTaskDAO.persist(todoItemTask);

        assertThat(todoItemTaskDAO.findByPersonId(1)).hasSize(1);
        assertThat(todoItemTaskDAO.findByPersonId(2)).isEmpty();
    }

    @Test
    void testRemove() {
        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee, true);
        todoItemTaskDAO.persist(todoItemTask);
        todoItemTaskDAO.remove(todoItemTask);

        assertThat(todoItemTaskDAO.findAll()).isEmpty();
    }
}
