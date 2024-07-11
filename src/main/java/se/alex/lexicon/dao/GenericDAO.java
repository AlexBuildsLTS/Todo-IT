package se.alex.lexicon.dao;

import java.util.Collection;

public interface GenericDAO<T, ID> {
    void persist(T entity);
    T findById(ID id);
    Collection<T> findAll();
    void remove(T entity);
}