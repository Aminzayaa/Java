package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAccess2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			// load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// confirm
			System.out.println(" --- before connection --- ");

			// database connect
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/axizdb", "root", "1234");

			// confirm
			System.out.println(" --- after connection --- ");

			// SQL query string
			String sql = "INSERT INTO users VALUES (10, 'taro', '01011112222')";

			// create statement
			stmt = con.prepareStatement(sql);

			// execute
			ResultSet rs = stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}