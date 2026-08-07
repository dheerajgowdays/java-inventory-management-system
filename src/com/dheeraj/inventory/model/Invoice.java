package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice implements Serializable {

    private final long invoiceId;
    private final String customerName;
    private final long phoneNumber;
    private final LocalDate date;
    private final ArrayList<InvoiceItems> items;
    private final int total;


    public Invoice(long invoiceId, String customerName, long phoneNumber, ArrayList<InvoiceItems> items, int total){
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.items = items;
        this.total = total;
        this.date = LocalDate.now();
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<InvoiceItems> getItems() {
        return items;
    }

    public int getTotal() {
        return total;
    }

    public void addInvoiceItem(InvoiceItems invoiceItems){
        items.add(invoiceItems);
    }
}