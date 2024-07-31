package jp.co.axiz;

import java.util.List;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;

public class DbExam5 {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();

        // Register a new product
        Product newProduct = new Product();
        newProduct.setProductName("ballpoint pen");
        newProduct.setPrice(200);
        productDao.register(newProduct);
        System.out.println("Registered.");

        // Retrieve all products and print them
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println("product_id: " + product.getProductId() + ", product_name: " + product.getProductName() + ", price: " + product.getPrice());
        }
    }
}
