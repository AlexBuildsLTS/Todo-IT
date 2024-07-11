package se.alex.lexicon.dao;

import java.util.Collection;

public interface GenericDAO<T> {
    void persist(T t);
    T findById(int id);
    Collection<T> findAll();
    void remove(T t);
}
