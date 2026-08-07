package repository;
import model.Invoice;
import storage.FileStorage;
import java.util.LinkedHashMap;

public class InvoiceRepository {
    FileStorage fileStorage = new FileStorage();
    LinkedHashMap<Long, Invoice> invoices = fileStorage.readInvoice();

    public void addInvoice(long id , Invoice invoice){
        invoices.put(id,invoice);
        fileStorage.writeInvoice(invoices);
    }

    public Invoice getById(long id){
        if(invoices.containsKey(id)){
            return invoices.get(id);
        }
        return null;
    }
    public void reloadInvoices(){
        invoices = fileStorage.readInvoice();
    }
}