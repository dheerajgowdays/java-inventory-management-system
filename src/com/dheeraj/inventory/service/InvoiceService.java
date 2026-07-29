package service;


import model.Invoice;
import model.InvoiceItems;
import repository.InvoiceRepository;
import repository.ProductRepository;

public class InvoiceService {
    ProductRepository productRepository = new ProductRepository();
    InvoiceRepository invoiceRepository = new InvoiceRepository();
    public void addInvoice(long id, Invoice invoice){
        invoiceRepository.addInvoice(id, invoice);
        System.out.println("Invoice Created Successfully By Invoice ID:"+id);
    }

    public void ViewInvoice(long id){
        if(invoiceRepository.getById(id) != null){
            Invoice invoice = invoiceRepository.getById(id);
            System.out.println("================== INVOICE ===================");
            System.out.println("Invoice Id: "+invoice.getInvoiceId());
            System.out.println("Name:"+invoice.getCustomerName());
            System.out.println("Phone Number: "+invoice.getPhoneNumber());
            System.out.println("Date:"+invoice.getDate());
            System.out.println("Total Number of Items: "+invoice.);
            for(InvoiceItems invoiceItems : invoice.getItems() ){
                System.out.println("\n ----------------------------------");
                System.out.println("Product Id: "+invoiceItems.getProduct());
                System.out.println("Product Name: "+productRepository.getProductName(invoiceItems.getProduct()));
                System.out.println("Product Price: "+invoiceItems.getPriceAtPurchase());
                System.out.println("Product Quantity: "+invoiceItems.getQuantity());
            }
            System.out.println("Total Amount: ");
        }else{
            System.out.println("The Entered Id is Invalid");
        }
    }
}