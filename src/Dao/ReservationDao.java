package Dao;

import Core.Db;
import Entity.Reservation;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationDao {
    private final Connection connection = Db.getInstance();

    public ArrayList<Reservation> findAll() {
        ArrayList<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                reservations.add(match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public Reservation getById(int id) {
        String query = "SELECT * FROM reservations WHERE reservation_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean save(Reservation reservation) {
        String query = "INSERT INTO reservations (room_id, check_in_date, check_out_date, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, reservation.getRoom_id());
            stmt.setDate(2, Date.valueOf(reservation.getCheck_in_date()));
            stmt.setDate(3, Date.valueOf(reservation.getCheck_out_date()));
            stmt.setDouble(4, reservation.getTotal_price());
            stmt.setInt(5, reservation.getGuest_count());
            stmt.setString(6, reservation.getGuest_name());
            stmt.setInt(7, reservation.getGuest_citizen_id());
            stmt.setString(8, reservation.getGuest_mail());
            stmt.setString(9, reservation.getGuest_phone());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM reservations WHERE reservation_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Reservation match(ResultSet rs) throws SQLException {
        return new Reservation(
                rs.getInt("reservation_id"),
                rs.getInt("room_id"),
                rs.getDate("check_in_date").toLocalDate(),
                rs.getDate("check_out_date").toLocalDate(),
                rs.getDouble("total_price"),
                rs.getInt("guest_count"),
                rs.getString("guest_name"),
                rs.getInt("guest_citizen_id"),
                rs.getString("guest_mail"),
                rs.getString("guest_phone")
        );
    }
}
