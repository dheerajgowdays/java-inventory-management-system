package service;
import repository.InvoiceRepository;
import repository.ProductRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BackupService {
    ProductRepository productRepository;
    InvoiceRepository invoiceRepository;
    public BackupService(ProductRepository productRepository,InvoiceRepository invoiceRepository){
        this.productRepository = productRepository;
        this.invoiceRepository = invoiceRepository;
    }
    public void copy(Path backupPath,Path sourcePath){
        try{if(backupPath.getParent() != null && !Files.exists(backupPath.getParent())){
            Files.createDirectories(backupPath.getParent());
        }
            Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            System.out.println("Failed to create file: "+e.getMessage());
        }
    }
    public void backupProducts(){
        Path backupPath = Paths.get("backup/products.dat");
        Path sourcePath = Paths.get("storage/products.dat");
        copy(backupPath,sourcePath);
        System.out.println("Successfully BackUp Created for Products");
    }
    public void backupInvoice(){
        Path backupPath = Paths.get("backup/invoice.dat");
        Path sourcePath = Paths.get("storage/invoice.dat");
        copy(backupPath,sourcePath);
        System.out.println("Successfully BackUp Created for Invoice");

    }
    public void restoreProduct(){
        Path sourcePath = Paths.get("backup/products.dat");
        Path backupPath = Paths.get("storage/products.dat");
        copy(backupPath,sourcePath);
        productRepository.reloadProducts();
        System.out.println("Successfully Restored Products");
    }
    public void restoreInvoice(){
        Path sourcePath = Paths.get("backup/invoice.dat");
        Path backupPath = Paths.get("storage/invoice.dat");
        copy(backupPath,sourcePath);
        invoiceRepository.reloadInvoices();
        System.out.println("Successfully Restored Invoice");
    }
}