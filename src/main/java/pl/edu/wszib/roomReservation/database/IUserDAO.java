package pl.edu.wszib.roomReservation.database;

import pl.edu.wszib.roomReservation.model.User;
import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    void addUser(User user);
    Optional<User> getUserById(int id);
}
