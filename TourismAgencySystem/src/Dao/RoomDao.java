package Dao;

import Core.Db;
import Entity.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomDao {
    private final Connection connection;

    public RoomDao() {
        this.connection = Db.getInstance();
    }

    public ArrayList<Room> findAll() {
        return this.selectByQuery("SELECT * FROM rooms");
    }

    public Room getById(int id) {
        Room room = null;
        String query = "SELECT * FROM rooms WHERE room_id = ?";
        try (PreparedStatement pr = this.connection.prepareStatement(query)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                room = match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public ArrayList<Room> selectByQuery(String query) {
        ArrayList<Room> rooms = new ArrayList<>();
        try (PreparedStatement pr = this.connection.prepareStatement(query);
             ResultSet rs = pr.executeQuery()) {
            while (rs.next()) {
                rooms.add(match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public boolean save(Room room) {
        String query = "INSERT INTO rooms (hotel_id, type, stock, adult_price, child_price, bed_capacity, square_meter, television, game_console, safe, projection) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = this.connection.prepareStatement(query)) {
            pstmt.setInt(1, room.getHotel_id());
            pstmt.setString(2, room.getType());
            pstmt.setInt(3, room.getStock());
            pstmt.setDouble(4, room.getAdult_price());
            pstmt.setDouble(5, room.getChild_price());
            pstmt.setInt(6, room.getBed_capacity());
            pstmt.setInt(7, room.getSquare_meter());
            pstmt.setBoolean(8, room.isTelevision());
            pstmt.setBoolean(9, room.isGame_console());
            pstmt.setBoolean(10, room.isSafe());
            pstmt.setBoolean(11, room.isProjection());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRoom(Room room) {
        String query = "UPDATE rooms SET hotel_id = ?, type = ?, stock = ?, adult_price = ?, child_price = ?, bed_capacity = ?, square_meter = ?, television = ?, game_console = ?, safe = ?, projection = ? WHERE room_id = ?";
        try (PreparedStatement pstmt = this.connection.prepareStatement(query)) {
            pstmt.setInt(1, room.getHotel_id());
            pstmt.setString(2, room.getType());
            pstmt.setInt(3, room.getStock());
            pstmt.setDouble(4, room.getAdult_price());
            pstmt.setDouble(5, room.getChild_price());
            pstmt.setInt(6, room.getBed_capacity());
            pstmt.setInt(7, room.getSquare_meter());
            pstmt.setBoolean(8, room.isTelevision());
            pstmt.setBoolean(9, room.isGame_console());
            pstmt.setBoolean(10, room.isSafe());
            pstmt.setBoolean(11, room.isProjection());
            pstmt.setInt(12, room.getRoom_id());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRoom(int roomId) {
        String query = "DELETE FROM rooms WHERE room_id = ?";
        try (PreparedStatement pstmt = this.connection.prepareStatement(query)) {
            pstmt.setInt(1, roomId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Room match(ResultSet rs) throws SQLException {
        return new Room(
                rs.getInt("room_id"),
                rs.getInt("hotel_id"),
                rs.getString("type"),
                rs.getInt("stock"),
                rs.getDouble("adult_price"),
                rs.getDouble("child_price"),
                rs.getInt("bed_capacity"),
                rs.getInt("square_meter"),
                rs.getBoolean("television"),
                rs.getBoolean("minibar"),
                rs.getBoolean("game_console"),
                rs.getBoolean("safe"),
                rs.getBoolean("projection")
        );
    }
}
