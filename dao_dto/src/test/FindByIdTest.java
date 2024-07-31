package test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;
import util.DbUtil;
import util.Utility;

public class FindByIdTest {

    public static void main(String[] args) {
        // コマンドライン引数が無い場合
        if (args.length == 0) {
            System.out.println("引数(取得したいユーザーのID)を指定してください");
            return;
        }

        // 入力値(ユーザーID)を数値に変換
        Integer userId = Utility.checkAndParseInt(args[0]);

        // DB接続情報取得
        try (Connection con = DbUtil.getConnection()) {

            // DAOのインスタンス作成
            // 引数にDB接続情報を渡す
            UserDao userDao = new UserDao(con);

            // userDaoのfindByIdメソッドを呼び
            // usersテーブルから対象のデータを取得
            // 引数には取得したいユーザーのIDを渡す
            User user = userDao.findById(userId);

            // ユーザー情報を取得
            String userInfo = "";
            if (user == null) {
                userInfo = "対象のデータはありません。";
            } else {
                userInfo += user.getUserId();
                userInfo += " " + user.getUserName();
                userInfo += " " + user.getTelNo();
            }

            // ユーザー情報を表示
            System.out.println(userInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}