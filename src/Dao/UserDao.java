package Dao;

import Core.Db;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private final Connection connection;

    public UserDao() {
        this.connection = Db.getInstance();
    }

    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "Select * FROM users";
        try {
            ResultSet rs = this.connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                userList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public ArrayList<User> findByRole(String userSearchRole) {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users WHERE role =" + "'" + userSearchRole + "'";

        try {

            ResultSet rs = this.connection.createStatement().executeQuery(query);
            while (rs.next()) {
                userList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    public User findByLogin(String username, String password) {
        User obj = null;
        String query = "SELECT user_id, username, password, role FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public boolean save(User newUser) {
        String query = "INSERT INTO users (username, password, role) VALUES (?,?,?)";
        try{
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1,newUser.getUsername());
            pr.setString(2,newUser.getPassword());
            pr.setString(3,newUser.getRole());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    public User match(ResultSet rs) throws SQLException {
        User obj = new User();
        obj.setUser_id(rs.getInt("user_id"));
        obj.setUsername(rs.getString("username"));
        obj.setPassword(rs.getString("password"));
        obj.setRole(rs.getString("role"));
        return obj;
    }
    public boolean delete(int selectedUserId) {
        String query = "DELETE FROM users WHERE user_id = ?";
        try {
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setInt(1,selectedUserId);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
