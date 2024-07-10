package se.alex.lexicon.dao;

import se.alex.lexicon.model.AppUser;
import java.util.Collection;

public interface AppUserDAO {
    void persist(AppUser appUser);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void remove(AppUser appUser);
}
