package jp.co.axiz.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DB接続用Utilityクラス
 */
public class DbUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnection", "root", "1234");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}