package Dao;

import Core.Db;
import Entity.Hotel;

import java.sql.*;
import java.util.ArrayList;

public class HotelDao {
    private final Connection connection = Db.getInstance();

    public ArrayList<Hotel> findAll() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String query = "SELECT * FROM hotels";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                hotels.add(new Hotel(
                        rs.getInt("hotel_id"),
                        rs.getString("hotel_name"),
                        rs.getString("hotel_address"),
                        rs.getString("hotel_city"),
                        rs.getString("hotel_email"),
                        rs.getString("hotel_phone"),
                        rs.getInt("hotel_star_rating"),
                        rs.getBoolean("free_parking"),
                        rs.getBoolean("free_wifi"),
                        rs.getBoolean("hotel_concierge"),
                        rs.getBoolean("room_service_24_7"),
                        rs.getBoolean("fitness_center"),
                        rs.getBoolean("spa"),
                        rs.getBoolean("swimming_pool")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public Hotel getById(int hotelId) {
        String query = "SELECT * FROM hotels WHERE hotel_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, hotelId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Hotel(
                        rs.getInt("hotel_id"),
                        rs.getString("hotel_name"),
                        rs.getString("hotel_address"),
                        rs.getString("hotel_city"),
                        rs.getString("hotel_email"),
                        rs.getString("hotel_phone"),
                        rs.getInt("hotel_star_rating"),
                        rs.getBoolean("free_parking"),
                        rs.getBoolean("free_wifi"),
                        rs.getBoolean("hotel_concierge"),
                        rs.getBoolean("room_service_24_7"),
                        rs.getBoolean("fitness_center"),
                        rs.getBoolean("spa"),
                        rs.getBoolean("swimming_pool")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean save(Hotel hotel) {
        String query = "INSERT INTO hotels (hotel_name, hotel_address, hotel_city, hotel_email, hotel_phone, hotel_star_rating, free_parking, free_wifi, hotel_concierge, room_service_24_7, fitness_center, spa, swimming_pool) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, hotel.getHotel_name());
            stmt.setString(2, hotel.getHotel_address());
            stmt.setString(3, hotel.getHotel_city());
            stmt.setString(4, hotel.getHotel_email());
            stmt.setString(5, hotel.getHotel_phone());
            stmt.setInt(6, hotel.getHotel_star_rating());
            stmt.setBoolean(7, hotel.isFree_parking());
            stmt.setBoolean(8, hotel.isFree_wifi());
            stmt.setBoolean(9, hotel.isHotel_concierge());
            stmt.setBoolean(10, hotel.isRoom_service_24_7());
            stmt.setBoolean(11, hotel.isFitness_center());
            stmt.setBoolean(12, hotel.isSpa());
            stmt.setBoolean(13, hotel.isSwimming_pool());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Hotel hotel) {
        String query = "UPDATE hotels SET hotel_name = ?, hotel_address = ?, hotel_city = ?, hotel_email = ?, hotel_phone = ?, hotel_star_rating = ?, free_parking = ?, free_wifi = ?, hotel_concierge = ?, room_service_24_7 = ?, fitness_center = ?, spa = ?, swimming_pool = ? WHERE hotel_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, hotel.getHotel_name());
            stmt.setString(2, hotel.getHotel_address());
            stmt.setString(3, hotel.getHotel_city());
            stmt.setString(4, hotel.getHotel_email());
            stmt.setString(5, hotel.getHotel_phone());
            stmt.setInt(6, hotel.getHotel_star_rating());
            stmt.setBoolean(7, hotel.isFree_parking());
            stmt.setBoolean(8, hotel.isFree_wifi());
            stmt.setBoolean(9, hotel.isHotel_concierge());
            stmt.setBoolean(10, hotel.isRoom_service_24_7());
            stmt.setBoolean(11, hotel.isFitness_center());
            stmt.setBoolean(12, hotel.isSpa());
            stmt.setBoolean(13, hotel.isSwimming_pool());
            stmt.setInt(14, hotel.getHotel_id());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int hotelId) {
        String query = "DELETE FROM hotels WHERE hotel_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, hotelId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
