package se.alex.lexicon.model;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private TodoItem todoItem;
    private Person assignee;
    private boolean assigned;

    public TodoItemTask(int id, TodoItem todoItem, Person assignee, boolean assigned) {
        this.id = id;
        this.todoItem = todoItem;
        this.assignee = assignee;
        this.assigned = assigned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", todoItem=" + todoItem +
                ", assignee=" + assignee +
                ", assigned=" + assigned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id && assigned == that.assigned && Objects.equals(todoItem, that.todoItem) && Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, todoItem, assignee, assigned);
    }
}
