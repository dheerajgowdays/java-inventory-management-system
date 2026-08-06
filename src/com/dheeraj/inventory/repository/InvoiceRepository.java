package repository;

import model.Invoice;
import model.InvoiceItems;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceRepository {

    HashMap<Long, Invoice> invoices = new HashMap<>();
    ArrayList<InvoiceItems> items = new ArrayList<>();

    public void addInvoice(long id , Invoice invoice){
        invoices.put(id,invoice);
    }

    public Invoice getById(long id){
        if(invoices.containsKey(id)){
            return invoices.get(id);
        }
        return null;
    }

    public void addInvoiceItem(InvoiceItems item){
        items.add(item);
    }
}