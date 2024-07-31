package jp.co.axiz;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;

public class DbDevExam5_Select {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        
        // Retrieve the product with product_id 102
        Product product = productDao.findByProductId(102);
        
        if (product != null) {
            System.out.println("product_id: " + product.getProductId() + ", product_name: " + product.getProductName() + ", price: " + product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }
}
