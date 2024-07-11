package se.alex.lexicon.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.alex.lexicon.dao.impl.TodoItemDAOImpl;
import se.alex.lexicon.model.Person;
import se.alex.lexicon.model.TodoItem;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class TodoItemDAOImplTest {
    private TodoItemDAOImpl todoItemDAO;
    private Person creator;

    @BeforeEach
    void setUp() {
        todoItemDAO = TodoItemDAOImpl.getInstance();
        todoItemDAO.findAll().forEach(todoItemDAO::remove); // Clear existing data
        creator = new Person(1, "John", "Doe", "john.doe@example.com");
    }

    @Test
    void testPersist() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        todoItemDAO.persist(todoItem);

        assertThat(todoItemDAO.findAll()).hasSize(1);
    }

    @Test
    void testFindById() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        todoItemDAO.persist(todoItem);

        TodoItem found = todoItemDAO.findById(1);
        assertThat(found).isNotNull();
        assertThat(found.getTitle()).isEqualTo("Title");
    }

    @Test
    void testFindAllByDoneStatus() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        todoItem.setDone(true);
        todoItemDAO.persist(todoItem);

        assertThat(todoItemDAO.findAllByDoneStatus(true)).hasSize(1);
        assertThat(todoItemDAO.findAllByDoneStatus(false)).isEmpty();
    }

    @Test
    void testFindByTitleContains() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        todoItemDAO.persist(todoItem);

        assertThat(todoItemDAO.findByTitleContains("Tit")).hasSize(1);
        assertThat(todoItemDAO.findByTitleContains("NoMatch")).isEmpty();
    }

    @Test
    void testFindByPersonId() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        todoItemDAO.persist(todoItem);

        assertThat(todoItemDAO.findByPersonId(1)).hasSize(1);
        assertThat(todoItemDAO.findByPersonId(2)).isEmpty();
    }

    @Test
    void testFindByDeadlineBefore() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now().plusDays(1), creator);
        todoItemDAO.persist(todoItem);

        assertThat(todoItemDAO.findByDeadlineBefore(LocalDate.now().plusDays(2))).hasSize(1);
        assertThat(todoItemDAO.findByDeadlineBefore(LocalDate.now())).isEmpty();
    }

    @Test
    void testFindByDeadlineAfter() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now().plusDays(1), creator);
        todoItemDAO.persist(todoItem);

        assertThat(todoItemDAO.findByDeadlineAfter(LocalDate.now())).hasSize(1);
        assertThat(todoItemDAO.findByDeadlineAfter(LocalDate.now().plusDays(2))).isEmpty();
    }

    @Test
    void testRemove() {
        TodoItem todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        todoItemDAO.persist(todoItem);
        todoItemDAO.remove(todoItem);

        assertThat(todoItemDAO.findAll()).isEmpty();
    }
}
