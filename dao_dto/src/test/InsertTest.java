package test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;
import util.DbUtil;
import util.Utility;

public class InsertTest {

    public static void main(String[] args) {
        // コマンドライン引数が無い場合
        if (args.length < 2) {
            System.out.println("引数を3つ(登録したいユーザーの情報[ID、名前、TelNo])指定してください");
            return;
        }

        // コマンドライン引数から入力したい情報を取得
        String userIdStr = args[0];
        String userName = args[1];
        String telNo = args[2];

        // 入力値(ユーザーID)を数値に変換
        Integer userId = Utility.checkAndParseInt(userIdStr);

        // 登録したいユーザーを作成
        User user = new User(userId, userName, telNo);

        // DB接続情報取得
        try (Connection con = DbUtil.getConnection()) {

            // DAOのインスタンス作成
            // 引数にDB接続情報を渡す
            UserDao userDao = new UserDao(con);

            // 既に同じIDで登録していないかチェック
            if (userDao.findById(userId) != null) {
                System.out.println("user_idが" + userId + "のデータは既に登録されています。");
                return;
            }

            // userDaoのinsertメソッドを呼び
            // usersテーブルにデータを登録
            // 引数には登録したいユーザーを渡す
            userDao.insert(user);
            System.out.println("登録しました！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}