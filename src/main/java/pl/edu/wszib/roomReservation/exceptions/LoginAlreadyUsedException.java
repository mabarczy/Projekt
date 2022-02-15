package pl.edu.wszib.roomReservation.exceptions;

public class LoginAlreadyUsedException extends RuntimeException{
    private String info;

    public LoginAlreadyUsedException(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
