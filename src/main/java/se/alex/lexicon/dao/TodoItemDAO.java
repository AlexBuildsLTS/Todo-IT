package se.alex.lexicon.dao;

import se.alex.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends GenericDAO<TodoItem, Integer> {
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadlineAfter(LocalDate date);
}