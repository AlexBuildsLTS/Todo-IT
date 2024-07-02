package se.alex.lexicon;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private final int id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private final Person creator;

    public TodoItem(int id, String title, LocalDate deadLine, Person creator) {
        this.id = id;
        setTitle(title);
        setDeadLine(deadLine);
        this.creator = Objects.requireNonNull(creator, "Creator cannot be null");
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = Objects.requireNonNull(deadLine, "Deadline cannot be null");
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

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }

    public String getSummary() {
        return String.format("TodoItem{id=%d, title='%s', description='%s', deadLine=%s, done=%b, creator=%s}",
                id, title, description, deadLine, done, creator.getSummary());
    }
}