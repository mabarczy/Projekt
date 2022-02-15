package pl.edu.wszib.roomReservation.database.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.roomReservation.database.IReservationDAO;
import pl.edu.wszib.roomReservation.model.Reservation;
import pl.edu.wszib.roomReservation.model.Room;

import java.util.List;

@Repository
public class ReservationDAO implements IReservationDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addReservation(Reservation reservation) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(reservation);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Reservation> getReservations() {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery("FROM pl.edu.wszib.roomReservation.model.Reservation");
        List<Reservation> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Reservation> getReservationsByUserId(int userId) {
        Session session = this.sessionFactory.openSession();
        Query<Reservation> query = session.createQuery("FROM pl.edu.wszib.roomReservation.model.Reservation WHERE user_id = :userId");
        query.setParameter("userId", userId);
        List<Reservation> result = query.getResultList();
        session.close();
        return result;
    }
}
