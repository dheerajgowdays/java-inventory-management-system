package repository;
import model.Product;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ProductRepository {
    HashMap<String, Product> products = new LinkedHashMap<>();

    public void addProducts(String id, Product product) {
        products.put(id,product);
    }

    public Iterator<Product> getAll(){
        return products.values().iterator();
    }
    public String getProductName(String id){
        Product product = products.get(id);
        return product.getProductName();
    }
    public boolean contains(String id){
        return products.containsKey(id);
    }
    public Product IfExist(String id){
        if(contains(id)){
            return products.get(id);
        }
        return null;
    }
    public void deleteProduct(String id){
        products.remove(id);
    }
    public HashMap<String ,Product> getProducts(){
        return products;
    }
}