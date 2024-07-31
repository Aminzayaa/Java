import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDevExam4_Select {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbconnection";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234"; // Replace with the actual password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM products ORDER BY product_id ASC";
            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    String productName = rs.getString("product_name");
                    int price = rs.getInt("price");
                    System.out.println("product_id: " + productId + ", product_name: " + productName + ", price: " + price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
