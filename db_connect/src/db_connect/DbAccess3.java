package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAccess3 {
	public static void main(String[] args) {
		// parameter
		String param = "鎌田";
		int param2 = 100;
		
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
			String sql = "SELECT * FROM users WHERE user_name = '" + param + "'" + " OR user_id = " + param2;

			// create statement
			stmt = con.prepareStatement(sql);

			// execute
			ResultSet rs = stmt.executeQuery();

			// output
			while (rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String tel = rs.getString("tel_no");

				System.out.println(id);
				System.out.println(name);
				System.out.println(tel);
			}
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