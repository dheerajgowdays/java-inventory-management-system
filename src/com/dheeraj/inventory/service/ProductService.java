package service;
import model.Product;
import repository.ProductRepository;

import java.util.HashMap;

public class ProductService{
    ProductRepository productRepository = new ProductRepository();
    public void addProduct(String id, Product product){
        HashMap<String,Product> products = productRepository.pr
        if (!products.containsKey(id)) {
            products.put(id, product);
            System.out.println("Product Successfully Added");
        } else {
            Product prod = products.get(id);
            if (!prod.getProductName().equalsIgnoreCase(productName)) {
                System.out.println("For this Product Id Product Name Does Not Match ");
            } else if (!(prod.getPrice() == price)) {
                System.out.println("For this Product Id Product Prices Does Not Match ");
            } else {
                prod.setQuantity(prod.getQuantity() + 1);
                System.out.println("Product Exist So One More Added Successfully");
            }
        }
    }
    public void getProduct(){
        HashMap<String,Product> products = productRepository.getAll();
        for(Product product : products.values()){
            System.out.println("Product Id      : " + product.getProductId());
            System.out.println("Product Name    : " + product.getProductName());
            System.out.println("Product Price   : " + product.getPrice());
            System.out.println("Product Category: " + product.getCategory());
            System.out.println("Product Quantity: " + product.getQuantity());
            System.out.println("----------------------------------------------\n");
        }
    }
    
}
