package se.alex.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    public TodoItem(int id, String title, String description, LocalDate deadline, Person creator) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.creator = creator;
        this.done = false; // Default value
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", creator=" + creator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadline, todoItem.deadline) && Objects.equals(creator, todoItem.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadline, done, creator);
    }
}
