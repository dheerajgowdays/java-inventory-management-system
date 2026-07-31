package model;
import model.Product;
public class InvoiceItems{

    private String product;
    private int quantity;
    private int priceAtPurchase;
    private int subPrice;

    public InvoiceItems( String product,int quantity,int priceAtPurchase,int subPrice){
        this.product = product;
        this.priceAtPurchase = priceAtPurchase;
        this.quantity = quantity;
        this.subPrice = subPrice;
    }

    public String getProduct() {
        return product;
    }
    public void setProduct(String  product){
        this.product = product;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getPriceAtPurchase(){
        return priceAtPurchase;
    }
    public void setPriceAtPurchase(int priceAtPurchase){
        this.priceAtPurchase = priceAtPurchase;
    }
    public void setSubPrice(int subPrice){
        this.subPrice = subPrice;
    }

    public int getSubPrice(){
        return subPrice;
    }
}