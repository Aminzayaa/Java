import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDevExam4_SelectSum {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbconnection";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234"; // Replace with the actual password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT SUM(price) AS total_price FROM products";
            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int totalPrice = rs.getInt("total_price");
                    System.out.println("Total amount: " + totalPrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
