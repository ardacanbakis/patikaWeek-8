package Dao;

import Core.Db;
import Entity.Pension;
import Entity.Pension.PensionType;

import java.sql.*;
import java.util.ArrayList;

public class PensionDao {
    private final Connection connection = Db.getInstance();

    public ArrayList<Pension> findAll() {
        ArrayList<Pension> pensions = new ArrayList<>();
        String query = "SELECT * FROM pensions";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pension pension = new Pension(
                        rs.getInt("pension_id"),
                        rs.getInt("hotel_id"),
                        PensionType.valueOf(rs.getString("type"))
                );
                pensions.add(pension);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pensions;
    }

    public Pension getById(int pensionId) {
        String query = "SELECT * FROM pensions WHERE pension_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pensionId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pension(
                        rs.getInt("pension_id"),
                        rs.getInt("hotel_id"),
                        PensionType.valueOf(rs.getString("type"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean save(Pension pension) {
        String query = "INSERT INTO pensions (hotel_id, type) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pension.getHotel_id());
            stmt.setString(2, pension.getType().name());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Pension pension) {
        String query = "UPDATE pensions SET hotel_id = ?, type = ? WHERE pension_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pension.getHotel_id());
            stmt.setString(2, pension.getType().name());
            stmt.setInt(3, pension.getPension_id());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int pensionId) {
        String query = "DELETE FROM pensions WHERE pension_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pensionId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
