package repository;

import model.Invoice;

import java.util.HashMap;

public class InvoiceRepository {

    HashMap<Long, Invoice> invoices = new HashMap<>();

    public void addInvoice(long id , Invoice invoice){
        invoices.put(id,invoice);
    }

    public Invoice getById(long id){
        if(invoices.containsKey(id)){
            return invoices.get(id);
        }
        return null;
    }
}