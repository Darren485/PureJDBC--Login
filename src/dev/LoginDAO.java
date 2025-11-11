package dev;

import java.sql.*;
import java.util.*;

public class LoginDAO {

    /**
     * Authenticate user with username and password Uses SELECT with WHERE
     * clause to verify credentials
     */
    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM Login WHERE username = ? AND password = ?";

        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            // If a row is found, credentials are valid
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Database error during authentication:");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Save a new user (for registration)
     */
    public void save(Login login) {
        String sql = "INSERT INTO Login (username, password) VALUES (?, ?)";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login.getUsername());
            pstmt.setString(2, login.getPassword());
            pstmt.executeUpdate();
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving user:");
            e.printStackTrace();
        }
    }

    /**
     * Get all Login (admin function)
     */
    public List<Login> getAllLogins() {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT * FROM Login";
        try (Connection conn = DB.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Login login = new Login(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                logins.add(login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logins;
    }

    /**
     * Delete a user by ID
     */
    public boolean delete(int id) {
        String sql = "DELETE FROM Login WHERE id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
