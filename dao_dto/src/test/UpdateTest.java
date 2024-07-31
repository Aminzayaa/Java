package test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;
import util.DbUtil;
import util.Utility;

public class UpdateTest {

    public static void main(String[] args) {
        // コマンドライン引数が無い場合
        if (args.length < 2) {
            System.out.println("引数を3つ(変更したいユーザーの情報[ID、名前、TelNo])指定してください");
            return;
        }

        // コマンドライン引数から入力したい情報を取得
        String userIdStr = args[0];
        String userName = args[1];
        String telNo = args[2];

        // 入力値(ユーザーID)を数値に変換
        Integer userId = Utility.checkAndParseInt(userIdStr);

        // 変更したいユーザーを作成
        User user = new User(userId, userName, telNo);

        // DB接続情報取得
        try (Connection con = DbUtil.getConnection()) {

            // DAOのインスタンス作成
            // 引数にDB接続情報を渡す
            UserDao userDao = new UserDao(con);

            // userDaoのupdateメソッドを呼び
            // データを変更する
            // 引数には変更したいユーザーの情報を渡す
            int cnt = userDao.update(user);

            // メッセージ作成
            String msg = "";
            if (cnt == 0) {
                msg = "該当のデータはありませんでした！";
            } else {
                msg = "変更しました！";
            }

            // メッセージ表示
            System.out.println(msg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}