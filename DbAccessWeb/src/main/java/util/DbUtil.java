package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    public static Connection getConnection() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/axizdb_web", "root", "1234");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}