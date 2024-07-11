package se.alex.lexicon.dao;

import se.alex.lexicon.model.AppUser;

public interface AppUserDAO extends GenericDAO<AppUser> {
    AppUser findByUsername(String username);
}
