package service;

import model.Product;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;

public class CSVService {
    ProductService service;
    public CSVService(ProductService service){
        this.service = service;
    }
    public void importCSV(String path){
        File file = new File(path);
        if(!file.exists()){
            System.out.println("Enter a Valid Path");
            return;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            int imported = 0;
            int skipped=0;
            int updated = 0;
            int rejected = 0;
            while((line = bufferedReader.readLine()) != null){
               if(line.trim().isEmpty() || line.startsWith("ID")){
                   skipped++;
                   continue;
               }
               String[] parts = line.split(",");
               if(parts.length == 5){
                   String productId = parts[0];
                   String productName = parts[1];
                   int productPrice = Integer.parseInt(parts[2]);
                   String productCategory = parts[3];
                   int productQuantity = Integer.parseInt(parts[4]);
                   Product product = new Product(productId,productName,productPrice,productCategory,productQuantity);
                   String v = service.csvAddProduct(productId,product);
                   if(v.equalsIgnoreCase("updated")){
                       updated++;
                   } else if (v.equalsIgnoreCase("rejected")) {
                       rejected++;
                   }else {
                       imported++;
                   }
               }else{skipped++;}
            }
            System.out.println("Successfully Loaded products from CSV");
            System.out.println("Imported: "+imported);
            System.out.println("Updated : "+updated);
            System.out.println("Rejected: "+rejected);
            System.out.println("Skipped : "+skipped);
        } catch (IOException e) {
            System.out.println("Failed to read: "+e.getMessage());
        }
    }
    public void exportCSV(){
        Path path = Paths.get(System.getProperty("user.home"), "Desktop", "export", "products.csv");
        try {
            if (path.getParent() != null && !Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("Failed to create file: " + e.getMessage());
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))){
            writer.write("ID,Name,Price,Category,Quantity");
            ArrayList<Product> list = service.csvGetAllProducts();
            for(Product prod : list){
                String[] line = new String[5];
                line[0] = prod.getProductId();
                line[1] = prod.getProductName();
                line[2] = String.valueOf(prod.getPrice());
                line[3] = prod.getCategory();
                line[4] = String.valueOf(prod.getQuantity());
                String result = String.join(",", line);
                writer.newLine();
                writer.write(result);
            }
            System.out.println("Successfully CSV is Exported");
            System.out.println("Location: "+path);
        } catch (Exception e) {
            System.out.println("Failed to write: "+e.getMessage());
        }
    }

}