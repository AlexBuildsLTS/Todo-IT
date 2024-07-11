package se.alex.lexicon.dao;

import se.alex.lexicon.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO extends GenericDAO<TodoItemTask> {
    Collection<TodoItemTask> findByAssignedStatus(boolean assigned);
    Collection<TodoItemTask> findByPersonId(int personId);
}
