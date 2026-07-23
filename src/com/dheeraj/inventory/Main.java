import java.util.Scanner;

import service.ProductService;

import model.Product;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();
        while(true){
            System.out.println("\n ==================== Inventory Management ==================== \n");
            System.out.println("1.  Add Product");
            System.out.println("2.  View Product");
            System.out.println("3.  Search Product");
            System.out.println("4.  Update Product");
            System.out.println("5.  Delete Product");
            System.out.println("6.  Generate Invoice");
            System.out.println("7.  View Invoices");
            System.out.println("8.  Import Products (CSV)");
            System.out.println("9.  Export Products (CSV)");
            System.out.println("10. Backup Data ");
            System.out.println("11. Restore Backup ");
            System.out.println("12. Exit ");
            System.out.println("\n Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    //Add Product
                    System.out.println("\n ==================== Add Product ==================== \n");
                    System.out.print("Enter Product Id: ");
                    String productId = sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Product Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.println();
                    Product product = new Product(productId,productName,price,category,quantity);
                    service.addProduct(productId,product);
                    break;
                case 2:
                    //View Product
                    break;
                case 3:
                    //Search Product
                    break;
                case 4:
                    //Update Product
                    break;
                case 5:
                    //Delete Product
                    break;
                case 6:
                    //Generate Invoice
                    break;
                case 7:
                    //View Invoice
                    break;
                case 8:
                    //Import Products (csv)
                    break;
                case 9:
                    //Export Products (csv)
                    break;
                case 10:
                    //Backup Data
                    break;
                case 11:
                    //Restore BackUp
                    break;
                case 12:
                    //Exit
                    System.out.println("\n THANK YOU \n");
                    System.exit(0);
                default:
                    System.out.println("Enter a Valid  Choice !");
            }
        }
    }
}