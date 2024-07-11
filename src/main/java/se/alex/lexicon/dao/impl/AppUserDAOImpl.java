package se.alex.lexicon.dao.impl;

import se.alex.lexicon.dao.AppUserDAO;
import se.alex.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDAOImpl implements AppUserDAO {
    private static AppUserDAOImpl instance = null;
    private Collection<AppUser> appUsers = new ArrayList<>();

    private AppUserDAOImpl() {}

    public static synchronized AppUserDAOImpl getInstance() {
        if (instance == null) {
            instance = new AppUserDAOImpl();
        }
        return instance;
    }

    @Override
    public void persist(AppUser appUser) {
        appUsers.add(appUser);
    }

    @Override
    public AppUser findById(int id) {
        return appUsers.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUsers.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(AppUser appUser) {
        appUsers.remove(appUser);
    }
}
