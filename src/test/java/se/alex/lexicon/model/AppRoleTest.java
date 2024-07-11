package se.alex.lexicon;

import se.alex.lexicon.dao.impl.AppUserDAOImpl;
import se.alex.lexicon.dao.impl.PersonDAOImpl;
import se.alex.lexicon.dao.impl.TodoItemDAOImpl;
import se.alex.lexicon.dao.impl.TodoItemTaskDAOImpl;
import se.alex.lexicon.dao.impl.sequencer.AppUserIdSequencer;
import se.alex.lexicon.dao.impl.sequencer.PersonIdSequencer;
import se.alex.lexicon.dao.impl.sequencer.TodoItemIdSequencer;
import se.alex.lexicon.dao.impl.sequencer.TodoItemTaskIdSequencer;
import se.alex.lexicon.model.AppUser;
import se.alex.lexicon.model.AppRole;
import se.alex.lexicon.model.Person;
import se.alex.lexicon.model.TodoItem;
import se.alex.lexicon.model.TodoItemTask;

import java.time.LocalDate;

final class App {
    public static void main(String[] args) {
        // Initializing DAOs
        AppUserDAOImpl appUserDAO = AppUserDAOImpl.getInstance();
        PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
        TodoItemDAOImpl todoItemDAO = TodoItemDAOImpl.getInstance();
        TodoItemTaskDAOImpl todoItemTaskDAO = TodoItemTaskDAOImpl.getInstance();

        // Creating sample data
        AppUser appUser = new AppUser(AppUserIdSequencer.nextId(), "alex", "password123", "alex.lexicon@example.com", AppRole.USER);
        Person person = new Person(PersonIdSequencer.nextId(), "Alex", "Lexicon", "alex.lexicon@example.com");
        TodoItem todoItem = new TodoItem(TodoItemIdSequencer.nextId(), "Title", "Description", LocalDate.now(), person);
        TodoItemTask todoItemTask = new TodoItemTask(TodoItemTaskIdSequencer.nextId(), todoItem, person, true);

        // Persisting sample data
        appUserDAO.persist(appUser);
        personDAO.persist(person);
        todoItemDAO.persist(todoItem);
        todoItemTaskDAO.persist(todoItemTask);

        // Retrieving and printing data
        System.out.println("AppUsers:");
        appUserDAO.findAll().forEach(System.out::println);

        System.out.println("Persons:");
        personDAO.findAll().forEach(System.out::println);

        System.out.println("TodoItems:");
        todoItemDAO.findAll().forEach(System.out::println);

        System.out.println("TodoItemTasks:");
        todoItemTaskDAO.findAll().forEach(System.out::println);
    }
}
