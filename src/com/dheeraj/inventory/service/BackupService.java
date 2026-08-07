package service;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BackupService {
    public void backupProducts(){
        Path backupPath = Paths.get("backup/product.dat");
        Path sourcePath = Paths.get("storage/product.dat");
        try{if(backupPath.getParent() != null && !Files.exists(backupPath.getParent())){
                Files.createDirectories(backupPath.getParent());
            }
            if(!Files.exists(backupPath)){
                Files.createFile(backupPath);
            }
            Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Successfully BackUp Created");
        }catch(IOException e){
            System.out.println("Failed to create file: "+e.getMessage());
        }
    }
    public void backupInvoice(){
        Path backupPath = Paths.get("backup/invoice.dat");
        Path sourcePath = Paths.get("storage/invoice.dat");
        try{if(backupPath.getParent() != null && !Files.exists(backupPath.getParent())){
            Files.createDirectories(backupPath.getParent());
        }
            if(!Files.exists(backupPath)){
                Files.createFile(backupPath);
            }
            Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Successfully BackUp Created");
        }catch(IOException e){
            System.out.println("Failed to create file: "+e.getMessage());
        }
    }
}