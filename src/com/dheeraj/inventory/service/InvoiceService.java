package service;


import model.Invoice;
import model.InvoiceItems;
import model.Product;
import repository.InvoiceRepository;
import repository.ProductRepository;

public class InvoiceService {
    ProductRepository productRepository;
    InvoiceRepository invoiceRepository;

    public InvoiceService(ProductRepository productRepository,InvoiceRepository invoiceRepository){
        this.productRepository = productRepository;
        this.invoiceRepository = invoiceRepository;
    }
    public void addInvoice(long id, Invoice invoice){
        invoiceRepository.addInvoice(id, invoice);
        System.out.println("Invoice Created Successfully By Invoice ID:"+id);
    }
    public void getProductForInvoice(String productId){
        if(productRepository.contains(productId)) {
            Product product = productRepository.IfExist(productId);
            System.out.println("\n ----------------------------------------");
            System.out.println("Product Name    :" + product.getProductName());
            System.out.println("Product Price   :" + product.getPrice());
            System.out.println("Product Quantity:" + product.getQuantity());
            System.out.println("---------------------------------------- \n");
        }else{
            System.out.println("Enter a Valid Product ID ");
        }
    }
    public boolean validateQuantity(String productId,int quantity){
        Product product = productRepository.IfExist(productId);
        if(product.getQuantity() < quantity){
            System.out.printf("Only %d Available\n",product.getQuantity());
            return false;
        }
        productRepository.updateQuantity(product.getQuantity()-quantity,product);
        return true;
    }
    public int getProductPrice(String productId){
        Product product = productRepository.IfExist(productId);
        return product.getPrice();
    }
    public void ViewInvoice(long id){
        if(invoiceRepository.getById(id) != null){
            Invoice invoice = invoiceRepository.getById(id);
            System.out.println("\n================== INVOICE ===================\n");
            System.out.println("Invoice Id           : "+invoice.getInvoiceId());
            System.out.println("Name                 : "+invoice.getCustomerName());
            System.out.println("Phone Number         : "+invoice.getPhoneNumber());
            System.out.println("Date                 : "+invoice.getDate());
            System.out.println("Total Number of Items: "+(invoice.getItems()).size());
            for(InvoiceItems invoiceItems : invoice.getItems() ){
                System.out.println("\n----------------------------------");
                System.out.println("Product Id       : "+invoiceItems.getProduct());
                System.out.println("Product Name     : "+productRepository.getProductName(invoiceItems.getProduct()));
                System.out.println("Product Price    : "+invoiceItems.getPriceAtPurchase());
                System.out.println("Product Quantity : "+invoiceItems.getQuantity());
            }
            System.out.println("\n----------------------------------");
            System.out.println("\n Total Amount         : "+invoice.getTotal());
        }else{
            System.out.println("The Entered Id is Invalid");
        }
    }
}