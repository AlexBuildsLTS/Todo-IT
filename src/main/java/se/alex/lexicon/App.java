package se.alex.lexicon;

import se.alex.lexicon.dao.*;
import se.alex.lexicon.dao.impl.AppUserCollection;
import se.alex.lexicon.dao.impl.PersonCollection;
import se.alex.lexicon.dao.impl.TodoItemCollection;
import se.alex.lexicon.dao.impl.TodoItemTaskCollection;
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
        AppUserDAO appUserDAO = new AppUserCollection();
        PersonDAO personDAO = new PersonCollection();
        TodoItemDAO todoItemDAO = new TodoItemCollection();
        TodoItemTaskDAO todoItemTaskDAO = new TodoItemTaskCollection();

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
