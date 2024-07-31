import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Insert {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbconnection";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234"; // Replace with the actual password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO products (product_name, price) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "ballpoint pen");
                pstmt.setInt(2, 200);
                pstmt.executeUpdate();
                System.out.println("Registered.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
