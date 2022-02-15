package pl.edu.wszib.roomReservation.database.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.roomReservation.database.IRoomDAO;
import pl.edu.wszib.roomReservation.model.Room;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomDAO implements IRoomDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Room> getRooms() {
        Session session = this.sessionFactory.openSession();
        Query<Room> query = session.createQuery("FROM pl.edu.wszib.roomReservation.model.Room");
        List<Room> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Optional<Room> getRoomById(int roomId) {
        Session session = this.sessionFactory.openSession();
        Query<Room> query = session.createQuery("FROM pl.edu.wszib.roomReservation.model.Room WHERE id = :id");
        query.setParameter("id", roomId);
        try {
            Room product = query.getSingleResult();
            session.close();
            return Optional.of(product);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }

    @Override
    public void updateRoom(Room room) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(room);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}