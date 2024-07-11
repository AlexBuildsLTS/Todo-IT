package se.alex.lexicon.dao.impl;

import se.alex.lexicon.dao.TodoItemTaskDAO;
import se.alex.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO {
    private static TodoItemTaskDAOImpl instance = null;
    private Collection<TodoItemTask> tasks = new ArrayList<>();

    private TodoItemTaskDAOImpl() {}

    public static synchronized TodoItemTaskDAOImpl getInstance() {
        if (instance == null) {
            instance = new TodoItemTaskDAOImpl();
        }
        return instance;
    }

    @Override
    public void persist(TodoItemTask todoItemTask) {
        tasks.add(todoItemTask);
    }

    @Override
    public TodoItemTask findById(Integer id) {
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
