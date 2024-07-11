package se.alex.lexicon.dao.impl;

import se.alex.lexicon.dao.TodoItemTaskDAO;
import se.alex.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TodoItemTaskDaoImpl implements TodoItemTaskDAO {
    private static TodoItemTaskDaoImpl instance = null;
    private Collection<TodoItemTask> tasks = new ArrayList<>();

    private TodoItemTaskDaoImpl() {}

    public static synchronized TodoItemTaskDaoImpl getInstance() {
        if (instance == null) {
            instance = new TodoItemTaskDaoImpl();
        }
        return instance;
    }

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
