package pl.edu.wszib.roomReservation.model;

import javax.persistence.*;

@Entity(name = "troom")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    @Enumerated(EnumType.STRING)
    private RoomType roomtype;
    private int price;

    public Room(int id, int number, RoomType roomtype, int price) {
        this.id = id;
        this.number = number;
        this.roomtype = roomtype;
        this.price = price;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public RoomType getRoomtype() {
        return roomtype;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRoomtype(RoomType roomtype) {
        this.roomtype = roomtype;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Room clone() {
        return new Room(this.id, this.number, this.roomtype, this.price);
    }

    @Override
    public String toString() {
        return "Room {" +
                "number=" + number +
                ", type='" + roomtype +
                ", price=" + price +
                '}';
    }

    public enum RoomType {
        ONEPERSON,
        TWOPERSON,
        THREEPERSON
    }

}
