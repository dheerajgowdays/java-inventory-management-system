package model;
import java.io.Serializable;
public class InvoiceItems implements Serializable {

    private final String product;
    private final int quantity;
    private final int priceAtPurchase;
    private final int subPrice;

    public InvoiceItems( String product,int quantity,int priceAtPurchase,int subPrice){
        this.product = product;
        this.priceAtPurchase = priceAtPurchase;
        this.quantity = quantity;
        this.subPrice = subPrice;
    }

    public String getProduct() {
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getPriceAtPurchase(){
        return priceAtPurchase;
    }
}