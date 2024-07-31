package test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import util.DbUtil;
import util.Utility;

public class DeleteTest {

    public static void main(String[] args) {
        // コマンドライン引数が無い場合
        if (args.length == 0) {
            System.out.println("引数(削除したいユーザーのID)を指定してください");
            return;
        }

        // 入力値(ユーザーID)を数値に変換
        Integer userId = Utility.checkAndParseInt(args[0]);

        // DB接続情報取得
        try (Connection con = DbUtil.getConnection()) {

            // DAOのインスタンス作成
            // 引数にDB接続情報を渡す
            UserDao userDao = new UserDao(con);

            // userDaoのdeleteメソッドを呼び
            // データを削除する
            // 引数には削除したいユーザーのIDを渡す
            int cnt = userDao.delete(userId);

            // メッセージ作成
            String msg = "";
            if (cnt == 0) {
                msg = "該当のデータはありませんでした！";
            } else {
                msg = "削除しました！";
            }

            // メッセージ表示
            System.out.println(msg);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}