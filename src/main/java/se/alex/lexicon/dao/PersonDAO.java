package se.alex.lexicon.dao;

import se.alex.lexicon.model.Person;

public interface PersonDAO extends GenericDAO<Person> {
    Person findByEmail(String email);
}
