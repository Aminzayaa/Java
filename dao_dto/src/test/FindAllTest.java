package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import entity.User;
import util.DbUtil;

public class FindAllTest {

    public static void main(String[] args) {
        // DB接続情報取得
        try (Connection con = DbUtil.getConnection()) {

            // DAOのインスタンス作成
            // 引数にDB接続情報を渡す
            UserDao userDao = new UserDao(con);

            // userDaoのfindAllメソッドを呼び
            // usersテーブルの全データを取得
            List<User> userList = userDao.findAll();

            // 取得したユーザー情報を全部表示
            for (User user : userList) {
                String userInfo = "";
                userInfo += user.getUserId();
                userInfo += " " + user.getUserName();
                userInfo += " " + user.getTelNo();
                System.out.println(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}