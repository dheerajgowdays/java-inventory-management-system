package model;
import java.time.LocalDate;
import java.util.ArrayList;
import model.InvoiceItems;

public class Invoice{

    private final String invoiceId;
    private final String customerName;
    private final int phoneNumber;
    private final LocalDate date;
    private final ArrayList<InvoiceItems> items;
    private final int total;

    Invoice(String invoiceId, String customerName, int phoneNumber, ArrayList<InvoiceItems> items, int total){
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.items = items;
        this.total = total;
        this.date = LocalDate.now();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getPhoneNumber() {
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
}