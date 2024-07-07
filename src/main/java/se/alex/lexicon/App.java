package se.alex.lexicon;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Todo Application");

        AppUser appUser1 = new AppUser("user1", "password", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("admin1", "adminpassword", AppRole.ROLE_APP_ADMIN);

        Person person1 = new Person(1, "Alex", "Youssef", "alex.youssef@example.com", appUser1);
        Person person2 = new Person(2, "Sandra", "Orlovic", "sandra.orlovic@example.com", appUser2);

        TodoItem todoItem1 = new TodoItem(1, "Change tires", "Change car tires to winter tires", LocalDate.now().plusDays(10), false, person1);
        TodoItem todoItem2 = new TodoItem(2, "Review budget", "Review the quarterly budget report", LocalDate.now().plusDays(5), false, person2);

        TodoItemTask task1 = new TodoItemTask(1, todoItem1, person1);
        TodoItemTask task2 = new TodoItemTask(2, todoItem2, person2);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(todoItem1);
        System.out.println(todoItem2);
        System.out.println(task1);
        System.out.println(task2);
    }
}
