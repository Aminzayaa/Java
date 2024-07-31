package jp.co.axiz.service;

import java.sql.Connection;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;
import jp.co.axiz.util.DbUtil;


public class ProductService {
    public Product findByProductId(Integer productId) {
        try (Connection con = DbUtil.getConnection()) {
            ProductDao pdDao = new ProductDao(con);
            return pdDao.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}