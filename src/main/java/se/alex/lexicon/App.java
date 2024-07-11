package se.alex.lexicon;

import se.alex.lexicon.dao.impl.AppUserDAO;
import se.alex.lexicon.dao.impl.PersonDAO;
import se.alex.lexicon.dao.impl.TodoItemDAO;
import se.alex.lexicon.dao.impl.TodoItemTaskDAO;
import se.alex.lexicon.dao.impl.sequencers.AppUserIdSequencer;
import se.alex.lexicon.dao.impl.sequencers.PersonIdSequencer;
import se.alex.lexicon.dao.impl.sequencers.TodoItemIdSequencer;
import se.alex.lexicon.dao.impl.sequencers.TodoItemTaskIdSequencer;
import se.alex.lexicon.model.*;
import se.alex.lexicon.sequencers.*;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // Create DAO instances
        se.alex.lexicon.dao.AppUserDAO appUserDAO = new AppUserDAO();
        se.alex.lexicon.dao.PersonDAO personDAO = new PersonDAO();
        se.alex.lexicon.dao.TodoItemDAO todoItemDAO = new TodoItemDAO();
        se.alex.lexicon.dao.TodoItemTaskDAO todoItemTaskDAO = new TodoItemTaskDAO();

        // Create and persist some objects
        AppUser appUser = new AppUser(AppUserIdSequencer.nextId(), "username", "password", "email@example.com", AppRole.USER);
        appUserDAO.persist(appUser);

        Person person = new Person(PersonIdSequencer.nextId(), "First", "Last", "email@example.com");
        personDAO.persist(person);

        TodoItem todoItem = new TodoItem(TodoItemIdSequencer.nextId(), "Title", "Description", LocalDate.now(), person);
        todoItemDAO.persist(todoItem);

        TodoItemTask todoItemTask = new TodoItemTask(TodoItemTaskIdSequencer.nextId(), todoItem, person, true);
        todoItemTaskDAO.persist(todoItemTask);

        // Print out some data
        System.out.println("All AppUsers: " + appUserDAO.findAll());
        System.out.println("All Persons: " + personDAO.findAll());
        System.out.println("All TodoItems: " + todoItemDAO.findAll());
        System.out.println("All TodoItemTasks: " + todoItemTaskDAO.findAll());
    }
}
