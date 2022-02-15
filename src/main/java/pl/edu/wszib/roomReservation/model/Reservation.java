package pl.edu.wszib.roomReservation.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity(name = "treservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime makingDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Reservation(User user, Room room, LocalDate startDate, LocalDate endDate){
        this.makingDate = LocalDateTime.now();
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = (int)ChronoUnit.DAYS.between(startDate, endDate) * room.getPrice();
        this.status = Status.NEW;
    }

    public Reservation() {}

    public int getId() { return id; }

    public LocalDateTime getMakingDate() { return makingDate; }

    public User getUser() { return user; }

    public Room getRoom() { return room; }

    public LocalDate getStartDate() { return startDate; }

    public LocalDate getEndDate() { return endDate; }

    public int getPrice() { return price; }

    public Status getStatus() { return status; }

    public void setId(int id) { this.id = id; }

    public void setMakingDate(LocalDateTime makingDate) { this.makingDate = makingDate; }

    public void setUser(User user) { this.user = user; }

    public void setRoom(Room room) { this.room = room; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public void setPrice(int price) { this.price = price; }

    public void setStatus(Status status) { this.status = status; }

    public enum Status {
        NEW,
        PAID,
        CANCELED
    }
}
