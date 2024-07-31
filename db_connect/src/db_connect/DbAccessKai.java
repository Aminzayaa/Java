package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbAccessKai {
	public static void main(String[] args) {
		// SQL query string
		String sql = "SELECT * FROM users";

		try {
			// load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// try-with-resource
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/axizdb", "root", "1234");
					PreparedStatement stmt = con.prepareStatement(sql)) {

				// execute
				ResultSet rs = stmt.executeQuery();

				// output
				while (rs.next()) {
					int id = rs.getInt("user_id");
					String name = rs.getString("user_name");
					String tel = rs.getString("tel_no");

					System.out.print(id + "\t");
					System.out.print(name + "\t");
					System.out.println(tel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}