package se.alex.lexicon.dao;

import se.alex.lexicon.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PersonCollection implements PersonDAO {
    private Collection<Person> persons = new ArrayList<>();

    @Override
    public void persist(Person person) {
        persons.add(person);
    }

    @Override
    public Person findById(int id) {
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
