package model;

public class Product{

    private final String productId;
    private String productName;
    private int price;
    private String category;
    private int quantity;

    public Product(String productId,String productName,int price,String category,int quantity){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory(){
        return category;
    }
    
    public void setQuantity(int quantity){ this.quantity = quantity;}

    public int getQuantity(){
        return quantity;
    }



}