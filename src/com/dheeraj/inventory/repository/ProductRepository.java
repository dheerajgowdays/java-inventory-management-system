package repository;
import model.Product;
import java.util.Iterator;
import java.util.LinkedHashMap;
import storage.FileStorage;

public class ProductRepository {
    FileStorage storage = new FileStorage();
    LinkedHashMap<String, Product> products = storage.readProduct();
    public void addProducts(String id, Product product) {
        products.put(id,product);
        storage.writeProduct(products);
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
        storage.writeProduct(products);
    }
    public LinkedHashMap<String ,Product> getProducts(){
        return products;
    }
}