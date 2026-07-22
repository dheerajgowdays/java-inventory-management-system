public class InvoiceItems {

    private Product product;
    private int quantity;
    private int priceAtPurchase;
    private int subPrice;

    InvoiceItems( Product product,int quantity,int priceAtPurchase){
        this.product = product;
        this.priceAtPurchase = priceAtPurchase;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Stirng product){
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