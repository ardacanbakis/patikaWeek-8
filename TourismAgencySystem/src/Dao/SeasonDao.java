package Dao;

import Core.Db;
import Entity.Season;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeasonDao {
    private final Connection connection = Db.getInstance();

    public ArrayList<Season> findAll() {
        ArrayList<Season> seasons = new ArrayList<>();
        String query = "SELECT * FROM seasons";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                seasons.add(match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seasons;
    }

    public Season getById(int seasonId) {
        String query = "SELECT * FROM seasons WHERE season_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, seasonId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean save(Season season) {
        String query = "INSERT INTO seasons (hotel_id, start_date, end_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, season.getHotel_id());
            stmt.setDate(2, Date.valueOf(season.getStart_date()));
            stmt.setDate(3, Date.valueOf(season.getEnd_date()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Season season) {
        String query = "UPDATE seasons SET hotel_id = ?, start_date = ?, end_date = ? WHERE season_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, season.getHotel_id());
            stmt.setDate(2, Date.valueOf(season.getStart_date()));
            stmt.setDate(3, Date.valueOf(season.getEnd_date()));
            stmt.setInt(4, season.getSeason_id());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int seasonId) {
        String query = "DELETE FROM seasons WHERE season_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, seasonId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Season match(ResultSet rs) throws SQLException {
        return new Season(
                rs.getInt("season_id"),
                rs.getInt("hotel_id"),
                rs.getDate("start_date").toLocalDate(),
                rs.getDate("end_date").toLocalDate()
        );
    }
}
