package jp.co.axiz.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;
import jp.co.axiz.util.DbUtil;

/**
 * productsテーブル用サービス
 */
public class ProductService {

    /**
     * 条件を指定した検索
     */
    public List<Product> find(Product pd) {
        List<Product> res = new ArrayList<Product>();

        try (Connection con = DbUtil.getConnection()) {
            ProductDao pdDao = new ProductDao(con);
            res = pdDao.find(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * 登録
     */
    public void insert(Product pd) {
        try (Connection con = DbUtil.getConnection()) {
            ProductDao pdDao = new ProductDao(con);
            pdDao.register(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}