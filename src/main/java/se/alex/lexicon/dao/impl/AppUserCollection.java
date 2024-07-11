package se.alex.lexicon.dao.impl;

import se.alex.lexicon.dao.AppUserDAO;
import se.alex.lexicon.model.AppUser;
import java.util.ArrayList;
import java.util.Collection;

public class AppUserCollection implements AppUserDAO {
    private Collection<AppUser> appUsers = new ArrayList<>();

    @Override
    public void persist(AppUser appUser) {
        appUsers.add(appUser);
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
