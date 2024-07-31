package jp.co.axiz;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;

import java.util.List;

public class DbDevExam5_Delete {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();

        // Delete the product with product_name "ballpoint pen"
        productDao.delete("ballpoint pen");
        System.out.println("Deleted.");

        // Retrieve all products and print them
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println("product_id: " + product.getProductId() + ", product_name: " + product.getProductName() + ", price: " + product.getPrice());
        }
    }
}
