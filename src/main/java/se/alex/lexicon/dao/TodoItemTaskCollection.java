package se.alex.lexicon.dao;

import se.alex.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TodoItemTaskCollection implements TodoItemTaskDAO {
    private Collection<TodoItemTask> tasks = new ArrayList<>();

    @Override
    public void persist(TodoItemTask todoItemTask) {
        tasks.add(todoItemTask);
    }

    @Override
    public TodoItemTask findById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        return tasks.stream()
                .filter(task -> task.isAssigned() == assigned)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return tasks.stream()
                .filter(task -> task.getAssignee().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(TodoItemTask todoItemTask) {
        tasks.remove(todoItemTask);
    }
}
