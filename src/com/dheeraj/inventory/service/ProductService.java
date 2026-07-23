package service;
import model.Product;
import repository.ProductRepository;

public class ProductService{
    ProductRepository productRepository = new ProductRepository();
    public void addProduct(String id, Product product){
        productRepository.addProducts(id,product,product.getProductName(),product.getPrice());

    }
}