package jp.co.axiz;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;

public class DbDevExam5_Update {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();

        // Retrieve the product with product_id 101 before update
        Product productBeforeUpdate = productDao.findByProductId(101);
        if (productBeforeUpdate != null) {
            System.out.println("Before update: product_id: " + productBeforeUpdate.getProductId() + ", product_name: " + productBeforeUpdate.getProductName() + ", price: " + productBeforeUpdate.getPrice());
        } else {
            System.out.println("Product not found.");
        }

        // Update the product
        Product productToUpdate = new Product();
        productToUpdate.setProductId(101);
        productToUpdate.setProductName("Sharpie Pencil");
        productToUpdate.setPrice(70);
        productDao.update(productToUpdate);

        // Retrieve the product with product_id 101 after update
        Product productAfterUpdate = productDao.findByProductId(101);
        if (productAfterUpdate != null) {
            System.out.println("After update: product_id: " + productAfterUpdate.getProductId() + ", product_name: " + productAfterUpdate.getProductName() + ", price: " + productAfterUpdate.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }
}
