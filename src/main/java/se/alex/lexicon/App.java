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
import se.alex.lexicon.util.JsonUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

final class App {
    public static void main(String[] args) {
        // Initializing DAOs
        AppUserDAOImpl appUserDAO = AppUserDAOImpl.getInstance();
        PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
        TodoItemDAOImpl todoItemDAO = TodoItemDAOImpl.getInstance();
        TodoItemTaskDAOImpl todoItemTaskDAO = TodoItemTaskDAOImpl.getInstance();

        // Load data from JSON files
        try {
            Collection<AppUser> appUsers = JsonUtil.deserializeFromJsonFile("appUsers.json", AppUser.class);
            Collection<Person> persons = JsonUtil.deserializeFromJsonFile("persons.json", Person.class);
            Collection<TodoItem> todoItems = JsonUtil.deserializeFromJsonFile("todoItems.json", TodoItem.class);
            Collection<TodoItemTask> todoItemTasks = JsonUtil.deserializeFromJsonFile("todoItemTasks.json", TodoItemTask.class);

            appUsers.forEach(appUserDAO::persist);
            persons.forEach(personDAO::persist);
            todoItems.forEach(todoItemDAO::persist);
            todoItemTasks.forEach(todoItemTaskDAO::persist);
        } catch (IOException e) {
            System.err.println("Failed to load data from JSON files: " + e.getMessage());
        }

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

        // Save data to JSON files
        try {
            JsonUtil.serializeToJsonFile("appUsers.json", appUserDAO.findAll());
            JsonUtil.serializeToJsonFile("persons.json", personDAO.findAll());
            JsonUtil.serializeToJsonFile("todoItems.json", todoItemDAO.findAll());
            JsonUtil.serializeToJsonFile("todoItemTasks.json", todoItemTaskDAO.findAll());
        } catch (IOException e) {
            System.err.println("Failed to save data to JSON files: " + e.getMessage());
        }
    }
}
