package OnlineShop;
import java.io.IOException;
import java.sql.*;

public class DatabaseClass {
    public Connection connection;

    public DatabaseClass() throws Exception {
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String userName = "root";
        String pass = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, userName, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new Exception("Error connecting to the database");
        }
    }

    public boolean isExist(String email, String password) throws SQLException {
        String query = "SELECT * FROM customer WHERE email=? AND pasword=?";
        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setString(1,email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void createAccount(int userName, String fname, String lname, String email, String password) throws SQLException {
        String query = "INSERT INTO customer (userName, fname, lname, email, pasword, balance) VALUES (?, ?, ?, ?, ?, 0)";
        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setInt(1, userName);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.executeUpdate();
        }
    }

    public void closeConnection() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }
}
