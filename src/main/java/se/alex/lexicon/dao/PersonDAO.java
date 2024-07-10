package se.alex.lexicon.dao;

import se.alex.lexicon.model.Person;
import java.util.Collection;

public interface PersonDAO {
    void persist(Person person);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void remove(Person person);
}
