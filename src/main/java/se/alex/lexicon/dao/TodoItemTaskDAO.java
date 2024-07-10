package se.alex.lexicon.dao;

import se.alex.lexicon.model.TodoItemTask;
import java.util.Collection;

public interface TodoItemTaskDAO {
    void persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean assigned);
    Collection<TodoItemTask> findByPersonId(int personId);
    void remove(TodoItemTask todoItemTask);
}
