package util;
public class IdGenerator {

    long invoiceID = 100000L;

    public long generateInvoiceId(){
        return invoiceID++;
    }
}