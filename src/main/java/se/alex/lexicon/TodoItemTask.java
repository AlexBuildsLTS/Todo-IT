package se.alex.lexicon;

import java.util.Objects;

public class TodoItemTask {
    private final int id;
    private boolean assigned;
    private final TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id, TodoItem todoItem) {
        this.id = id;
        this.todoItem = Objects.requireNonNull(todoItem, "TodoItem cannot be null");
        this.assigned = false;
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    public String getSummary() {
        return String.format("TodoItemTask{id=%d, assigned=%b, todoItem=%s, assignee=%s}",
                id, assigned, todoItem.getSummary(), assignee != null ? assignee.getSummary() : "none");
    }
}