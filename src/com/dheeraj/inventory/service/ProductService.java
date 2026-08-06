package service;
import model.Product;
import repository.ProductRepository;
import java.util.Iterator;

public class ProductService{

    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public void addProduct(String id, Product product){
        if (!productRepository.contains(id)){
            productRepository.addProducts(id,product);
            System.out.println("Product Successfully Added");
        } else {
            Product prod = productRepository.IfExist(id);
            if (!prod.getProductName().equalsIgnoreCase(product.getProductName())) {
                System.out.println("For this Product Id Product Name Does Not Match ");
            } else if (!(prod.getPrice() == product.getPrice())) {
                System.out.println("For this Product Id Product Prices Does Not Match ");
            } else {
                prod.setQuantity(prod.getQuantity() + product.getQuantity());
                System.out.println("Product Exist So More Quantity Added Successfully");
            }
        }
    }
    public  void deleteProduct(String id){
        if(productRepository.contains(id)){
            productRepository.deleteProduct(id);
            System.out.println("Product Successfully Deleted!");
        }else{
            System.out.println("Enter a Valid Product ID ");
        }
    }
    public void getProduct(String id){
        if(productRepository.contains(id)) {
            Product product = productRepository.IfExist(id);
            System.out.println("Product Id      : " + product.getProductId());
            System.out.println("Product Name    : " + product.getProductName());
            System.out.println("Product Price   : " + product.getPrice());
            System.out.println("Product Category: " + product.getCategory());
            System.out.println("Product Quantity: " + product.getQuantity());
        }else{
            System.out.println("Enter a Valid Product ID ");
        }
    }
    public boolean exist(String id){
        return productRepository.contains(id);
    }
    public void updateName(String id , String name){
        Product product = productRepository.IfExist(id);
        product.setProductName(name);
        System.out.println("\n Successfully Name Updated \n");
    }
    public void updatePrice(String id, int price){
        Product product = productRepository.IfExist(id);
        product.setPrice(price);
        System.out.println("\n Successfully Price Updated \n");
    }
    public void updateCategory(String id, String category){
        Product product = productRepository.IfExist(id);
        product.setCategory(category);
        System.out.println("\n Successfully Category Updated \n");
    }
    public void updateQuantity(String id , int quantity){
        Product product = productRepository.IfExist(id);
        product.setQuantity(quantity);
        System.out.println("\n Successfully Quantity Updated \n");
    }
    public void getAllProduct(){
        Iterator<Product> products = productRepository.getAll();
        while (products.hasNext()){
            Product product = products.next();
            System.out.println("Product Id      : " + product.getProductId());
            System.out.println("Product Name    : " + product.getProductName());
            System.out.println("Product Price   : " + product.getPrice());
            System.out.println("Product Category: " + product.getCategory());
            System.out.println("Product Quantity: " + product.getQuantity());
            System.out.println("----------------------------------------------\n");
        }
    }
}
