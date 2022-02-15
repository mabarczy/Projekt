package pl.edu.wszib.roomReservation.services;

import pl.edu.wszib.roomReservation.model.view.RegisterUser;

public interface IAuthenticationService {
    void authenticate(String login, String password);
    void register(RegisterUser registerUser);
}
