public class Product{

    private final String productId;
    private Stirng productName;
    private int price;
    private String category;
    private int quantity;

    Product(Stirng productName,int price,String category,int quantity){
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public Stirng getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public int getPrice(){
        return price;
    }

    public String getCategory(){
        return category;
    }

    public int getQuantity(){
        return quantity;
    }
}