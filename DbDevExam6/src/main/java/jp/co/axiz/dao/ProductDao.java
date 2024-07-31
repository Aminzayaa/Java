package jp.co.axiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.entity.Product;
import jp.co.axiz.util.ParamUtil;

/**
 * productsテーブル用DAO
 */
public class ProductDao {

    // 全件検索用SQL
    private static final String SELECT_ALL = "SELECT * FROM products";

    // 条件を指定した検索用SQLのベース部分
    private static final String SELECT = "SELECT * FROM products WHERE ";

    // 出力順指定
    private static final String ORDER_BY = " ORDER BY product_id";

    Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }

    /**
     * 全件取得
     */
    public List<Product> findAll() {

        List<Product> list = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(SELECT_ALL + ORDER_BY)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 条件を指定した検索
     */
    public List<Product> find(Product pd) {
        // WHERE句の文字列生成用
        // 指定した条件に応じて、
        // 「product_name = ?」、「price = ?」などの文字列が入る
        ArrayList<String> conditionList = new ArrayList<>();

        // プレースホルダーに埋め込む値用
        ArrayList<Object> paramList = new ArrayList<>();

        // 各検索条件の入力値用
        String productName = null;
        Integer price = null;

        // 引数の値をセット
        if (pd != null) {
            productName = pd.getProductName();
            price = pd.getPrice();
        }

        // 各検索条件が全て未入力の場合、全件検索
        if (ParamUtil.isNullOrEmpty(productName) && price == null) {
            return findAll();
        }

        // product_nameが入力されている場合、
        // 「product_name = ?」をWHEREの条件として使用する
        if (!ParamUtil.isNullOrEmpty(productName)) {
            conditionList.add("product_name = ?"); // WHERE句の条件に使用する文字列
            paramList.add(productName); // プレースホルダーに埋め込む値
        }

        // priceが入力されている場合、
        // 「price = ?」をWHEREの条件として使用する
        if (price != null) {
            conditionList.add("price = ?"); // WHERE句の条件に使用する文字列
            paramList.add(price); // プレースホルダーに埋め込む値
        }

        // WHERE句の文字列生成
        // 「product_name = ?」、「price = ?」などの
        // 文字列の間に「 AND 」をくっつけて、一つの文字列に生成する
        // 入力パターンに応じて、下記の文字列が生成される
        // product_nameのみ入力 ⇒ 「prduct_name = ?」
        // priceのみ入力 　　　 ⇒ 「price = ?」
        // 両方入力 　　　　　　⇒ 「prduct_name = ? AND price = ?」
        String whereString = String.join(" AND ", conditionList.toArray(new String[] {}));

        List<Product> list = new ArrayList<>();

        // SQL文生成
        // (ベースのSQL文 + WHERE句の文字列 + 出力順)
        String sql = SELECT + whereString + ORDER_BY;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // プレースホルダーの値をセット
            for (int i = 0; i < paramList.size(); i++) {
                stmt.setObject(i + 1, paramList.get(i));
            }

            // SQL文実行
            ResultSet rs = stmt.executeQuery();

            // 取得した件数分、処理を繰り返す
            while (rs.next()) {
                // 取得したデータを変数listに追加
                list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}