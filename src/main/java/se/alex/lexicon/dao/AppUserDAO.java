package se.alex.lexicon.dao;
import java.lang.String;
import se.alex.lexicon.model.AppUser;

public interface AppUserDAO extends GenericDAO<AppUser, Integer>  {
    AppUser findByUsername(String username);
}
