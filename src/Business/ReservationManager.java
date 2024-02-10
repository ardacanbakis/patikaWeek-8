package Business;

import Dao.ReservationDao;
import Entity.Reservation;

import java.util.ArrayList;

public class ReservationManager {
    private final ReservationDao reservationDao = new ReservationDao();

    public ArrayList<Reservation> findAllReservations() {
        return reservationDao.findAll();
    }

    public Reservation findReservationById(int reservationId) {
        return reservationDao.getById(reservationId);
    }

    public boolean saveReservation(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    public boolean deleteReservation(int reservationId) {
        return reservationDao.delete(reservationId);
    }
}
