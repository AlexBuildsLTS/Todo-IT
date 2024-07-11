package se.alex.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class TodoItemTest {
    private TodoItem todoItem;
    private Person creator;

    @BeforeEach
    void setUp() {
        creator = new Person(1, "Alex", "Lexicon", "alex.lexicon@example.com");
        todoItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
    }

    @Test
    void testGetId() {
        assertThat(todoItem.getId()).isEqualTo(1);
    }

    @Test
    void testGetTitle() {
        assertThat(todoItem.getTitle()).isEqualTo("Title");
    }

    @Test
    void testGetDescription() {
        assertThat(todoItem.getDescription()).isEqualTo("Description");
    }

    @Test
    void testGetDeadline() {
        assertThat(todoItem.getDeadline()).isEqualTo(LocalDate.now());
    }

    @Test
    void testGetCreator() {
        assertThat(todoItem.getCreator()).isEqualTo(creator);
    }

    @Test
    void testSetId() {
        todoItem.setId(2);
        assertThat(todoItem.getId()).isEqualTo(2);
    }

    @Test
    void testSetTitle() {
        todoItem.setTitle("New Title");
        assertThat(todoItem.getTitle()).isEqualTo("New Title");
    }

    @Test
    void testSetDescription() {
        todoItem.setDescription("New Description");
        assertThat(todoItem.getDescription()).isEqualTo("New Description");
    }

    @Test
    void testSetDeadline() {
        LocalDate newDate = LocalDate.now().plusDays(1);
        todoItem.setDeadline(newDate);
        assertThat(todoItem.getDeadline()).isEqualTo(newDate);
    }

    @Test
    void testSetCreator() {
        Person newCreator = new Person(2, "Sandra", "Rose", "sandra.rose@example.com");
        todoItem.setCreator(newCreator);
        assertThat(todoItem.getCreator()).isEqualTo(newCreator);
    }

    @Test
    void testEquals() {
        TodoItem anotherItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        assertThat(todoItem).isEqualTo(anotherItem);
    }

    @Test
    void testHashCode() {
        TodoItem anotherItem = new TodoItem(1, "Title", "Description", LocalDate.now(), creator);
        assertThat(todoItem.hashCode()).isEqualTo(anotherItem.hashCode());
    }

    @Test
    void testToString() {
        String expected = "TodoItem{id=1, title='Title', description='Description', deadline=" + LocalDate.now() + ", creator=Person{id=1, firstName='Alex', lastName='Lexicon', email='alex.lexicon@example.com'}}";
        assertThat(todoItem.toString()).isEqualTo(expected);
    }
}
