package se.alex.lexicon.dao.impl;

import se.alex.lexicon.dao.PersonDAO;
import se.alex.lexicon.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PersonDAOImpl implements PersonDAO {
    private static PersonDAOImpl instance = null;
    private Collection<Person> persons = new ArrayList<>();

    private PersonDAOImpl() {}

    public static synchronized PersonDAOImpl getInstance() {
        if (instance == null) {
            instance = new PersonDAOImpl();
        }
        return instance;
    }

    @Override
    public void persist(Person person) {
        persons.add(person);
    }

    @Override
    public Person findById(Integer id) {
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person findByEmail(String email) {
        return persons.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(Person person) {
        persons.remove(person);
    }
}
