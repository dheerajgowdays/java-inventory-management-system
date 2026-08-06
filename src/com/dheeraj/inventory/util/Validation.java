package util;

import repository.ProductRepository;

public class Validation {
    ProductRepository productRepository;
    public Validation(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public boolean product(String add){
        return add.equalsIgnoreCase("yes");
    }
    public boolean present(String productId){
        return productRepository.contains(productId);
    }
}