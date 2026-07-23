package repository;
import model.Product;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ProductRepository {
    HashMap<String , Product> products = new LinkedHashMap<>();

    public void addProducts(String id,Product product,String productName,int price){
        if(!products.containsKey(id)) {
            products.put(id, product);
            System.out.println("Product Successfully Added");
        }
        else{
            Product prod = products.get(id);
            if(!prod.getProductName().equalsIgnoreCase(productName)){
                System.out.println("For this Product Id Product Name Does Not Match ");
            } else if (!(prod.getPrice() == price)) {
                System.out.println("For this Product Id Product Prices Does Not Match ");
            }else{
                prod.setQuantity(prod.getQuantity()+1);
                System.out.println("Product Exist So One More Added Successfully");
            }
        }
    }
}