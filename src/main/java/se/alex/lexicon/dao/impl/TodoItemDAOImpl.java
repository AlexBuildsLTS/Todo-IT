package se.alex.lexicon.dao.impl;

import se.alex.lexicon.dao.TodoItemDAO;
import se.alex.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TodoItemDAOImpl implements TodoItemDAO {
    private static TodoItemDAOImpl instance = null;
    private Collection<TodoItem> todoItems = new ArrayList<>();

    private TodoItemDAOImpl() {}

    public static synchronized TodoItemDAOImpl getInstance() {
        if (instance == null) {
            instance = new TodoItemDAOImpl();
        }
        return instance;
    }

    @Override
    public void persist(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    @Override
    public TodoItem findById(int id) {
        return todoItems.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return todoItems.stream()
                .filter(item -> item.isDone() == done)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItems.stream()
                .filter(item -> item.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItems.stream()
                .filter(item -> item.getCreator().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItems.stream()
                .filter(item -> item.getDeadline().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.stream()
                .filter(item -> item.getDeadline().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(TodoItem todoItem) {
        todoItems.remove(todoItem);
    }
}
