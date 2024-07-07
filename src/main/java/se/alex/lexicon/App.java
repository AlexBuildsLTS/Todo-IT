package se.alex.lexicon;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // Create AppUsers
        AppUser user1 = new AppUser("alexyoussef", "password123", AppRole.ROLE_APP_USER);
        AppUser admin1 = new AppUser("sandraorlovic", "adminpass", AppRole.ROLE_APP_ADMIN);

        // Create Persons
        Person alex = new Person(1, "Alex", "Youssef", "alex.youssef@example.com");
        alex.setCredentials(user1);

        Person sandra = new Person(2, "Sandra", "Orlovic", "sandra.orlovic@example.com");
        sandra.setCredentials(admin1);

        // Create TodoItems
        TodoItem todo1 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(10), false, alex);
        TodoItem todo2 = new TodoItem(2, "Review budget", "Review the quarterly budget report", LocalDate.now().plusDays(5), false, sandra);

        // Create TodoItemTasks
        TodoItemTask task1 = new TodoItemTask(1, todo1, alex);
        TodoItemTask task2 = new TodoItemTask(2, todo2, sandra);

        // Print out details
        System.out.println("AppUsers:");
        System.out.println(user1);
        System.out.println(admin1);

        System.out.println("\nPersons:");
        System.out.println(alex);
        System.out.println(sandra);

        System.out.println("\nTodoItems:");
        System.out.println(todo1);
        System.out.println(todo2);

        System.out.println("\nTodoItemTasks:");
        System.out.println(task1);
        System.out.println(task2);
    }
}
