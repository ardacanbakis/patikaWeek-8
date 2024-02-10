package Business;

import Dao.ReservationDao;
import Entity.Reservation;

import java.util.ArrayList;

public class ReservationManager {
    private final ReservationDao reservationDao = new ReservationDao();

    public ArrayList<Reservation> findAllReservations() {
        return reservationDao.findAll();
    }
    public ArrayList<Object[]> getForTable(ArrayList<Reservation> reservationList) {
        ArrayList<Object[]> reservationObjList = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            reservationObjList.add(new Object[]{
                    reservation.getReservation_id(),
                    reservation.getRoom_id(),
                    reservation.getCheck_in_date(),
                    reservation.getCheck_out_date(),
                    reservation.getTotal_price(),
                    reservation.getGuest_count(),
                    reservation.getGuest_name(),
                    reservation.getGuest_citizen_id(),
                    reservation.getGuest_mail(),
                    reservation.getGuest_phone()
            });
        }
        return reservationObjList;
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
