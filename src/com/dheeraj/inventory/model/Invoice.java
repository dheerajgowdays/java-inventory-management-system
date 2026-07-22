import java.util.ArrayList;
public class Invoice{

    private final String invoiceId;
    private final Stirng customerName;
    private final int phoneNumber;
    private final LocalDate date;
    private final ArrayList<IvoiceItems> items;
    private final int total;

    Invoice(Stirng customerName,int phoneNumber){
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.date = LocaleDate.now();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public Stirng getCustomerName() {
        return customerName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<IvoiceItems> getItems() {
        return items;
    }

    public int getTotal() {
        return total;
    }
}