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

    private static final String SELECT_ALL = "SELECT * FROM products";
    private static final String SELECT = "SELECT * FROM products WHERE ";
    private static final String ORDER_BY = " ORDER BY product_id";
    private static final String INSERT = "INSERT INTO products (product_name, price) VALUES(?, ?)";

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
        ArrayList<String> conditionList = new ArrayList<>();
        ArrayList<Object> paramList = new ArrayList<>();

        String productName = null;
        Integer price = null;

        if (pd != null) {
            productName = pd.getProductName();
            price = pd.getPrice();
        }

        if (ParamUtil.isNullOrEmpty(productName) && price == null) {
            return findAll();
        }

        if (!ParamUtil.isNullOrEmpty(productName)) {
            conditionList.add("product_name = ?");
            paramList.add(productName);
        }

        if (price != null) {
            conditionList.add("price = ?");
            paramList.add(price);
        }

        // WHERE句の文字列生成
        String whereString = String.join(" AND ", conditionList.toArray(new String[] {}));

        List<Product> list = new ArrayList<>();

        // SQL文生成
        String sql = SELECT + whereString + ORDER_BY;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // プレースホルダーの値をセット
            for (int i = 0; i < paramList.size(); i++) {
                stmt.setObject(i + 1, paramList.get(i));
            }

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
     * 登録
     */
    public void register(Product pd) {

        try (PreparedStatement stmt = con.prepareStatement(INSERT)) {
            stmt.setString(1, pd.getProductName());
            stmt.setInt(2, pd.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}