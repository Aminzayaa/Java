package jp.co.axiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.axiz.entity.Product;

/**
 * productsテーブル用DAO
 */
public class ProductDao {

    private static final String SELECT_BY_PRODUCT_ID = "SELECT * FROM products WHERE product_id = ? ORDER BY product_id";

    Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }

    /**
     * product_idを指定して検索
     */
    public Product findByProductId(Integer productId) {
        try (PreparedStatement stmt = con.prepareStatement(SELECT_BY_PRODUCT_ID);) {
            stmt.setInt(1, productId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}