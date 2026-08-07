package storage;

import model.Invoice;
import model.Product;

import java.io.*;
import java.util.LinkedHashMap;

public class FileStorage  {

    public void writeProduct(LinkedHashMap<String, Product> products){
        try(FileOutputStream fos = new FileOutputStream("storage/products.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(products);
            System.out.println("   -> Save complete.\n");
        }catch (Exception e){
            System.out.println("Failed to write: "+e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public LinkedHashMap<String,Product> readProduct(){
        try(FileInputStream fis = new FileInputStream("storage/products.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Object obj = ois.readObject();
            System.out.println("Reading file Data");
            return (LinkedHashMap<String, Product>) obj;
        }catch (Exception e){
            System.out.println("Failed to read: "+e.getMessage());
        }
        return new LinkedHashMap<>();
    }
    public void writeInvoice(LinkedHashMap<Long, Invoice> invoice){
        try(FileOutputStream fos = new FileOutputStream("storage/invoice.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(invoice);
            System.out.println(" -> Save complete.\n");
        }catch (Exception e){
            System.out.println("Failed to write: "+e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public LinkedHashMap<Long,Invoice> readInvoice(){
        try(FileInputStream fis = new FileInputStream("storage/invoice.dat");
        ObjectInputStream ois = new ObjectInputStream(fis)){
            Object obj = ois.readObject();
            System.out.println("Reading Invoice Data");
            return (LinkedHashMap<Long, Invoice>) obj;
        }catch (Exception e){
            System.out.println("Failed to read: "+e.getMessage());
        }
        return new LinkedHashMap<>();
    }
}