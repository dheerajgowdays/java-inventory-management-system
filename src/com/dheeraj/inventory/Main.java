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
            System.out.println("2.  View Products");
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
                    System.out.println("\n ==================== View Product ====================\n");
                    service.getAllProduct();
                    break;
                case 3:
                    //Search Product"
                    System.out.println("\n ==================== Search Product ====================\n");
                    System.out.println("Enter the Product Id: ");
                    String sProductId = sc.nextLine();
                    service.getProduct(sProductId);
                    break;
                case 4:
                    //Update Product
                    System.out.println("\n ==================== Update Product ====================\n");
                    System.out.println("Enter Product Id:");
                    String uProductID = sc.nextLine();
                    if(service.exist(uProductID)){
                        label:
                        while (true) {
                            System.out.println("1. Update Product Name ");
                            System.out.println("2. Update Product Price");
                            System.out.println("3. Update Product Category");
                            System.out.println("4. Update Product Quantity");
                            System.out.println("5. Exit");
                            System.out.println("Enter Your Choice:");
                            int uChoice = sc.nextInt();
                            sc.nextLine();
                            switch (uChoice){
                                case 1:
                                    System.out.println("Enter the Product Name: ");
                                    String uProductName = sc.nextLine();
                                    service.UpdateName(uProductID,uProductName);
                                    break;
                                case 2:
                                    System.out.println("Enter the Product Price: ");
                                    int uPrice = sc.nextInt();
                                    service.UpdatePrice(uProductID,uPrice);
                                    break;
                                case 3:
                                    System.out.println("Enter the Product Category: ");
                                    String uCategory = sc.nextLine();
                                    service.UpdateCategory(uProductID,uCategory);
                                    break;
                                case 4:
                                    System.out.println("Enter the Product Quantity: ");
                                    int uQuantity = sc.nextInt();
                                    service.UpdateQuantity(uProductID,uQuantity);
                                    break;
                                case 5:
                                    break label;
                                default:
                                    System.out.println("Enter the Valid Choice!");
                            }
                        }
                    }else {
                        System.out.println("Enter a Valid Product Id ");
                    }
                    break;
                case 5:
                    //Delete Product
                    System.out.println("\n ==================== Delete Product ====================\n");
                    System.out.println("Enter the Product Id:");
                    String dProductId = sc.nextLine();
                    service.deleteProduct(dProductId);
                    break;
                case 6:
                    //Generate Invoice
                    System.out.println("\n ==================== Generate Invoice ====================\n");
                    break;
                case 7:
                    //View Invoice
                    System.out.println("\n ==================== View Invoice ==================== \n");
                    break;
                case 8:
                    //Import Products (csv)
                    System.out.println("\n ==================== Import Product ====================\n");
                    break;
                case 9:
                    //Export Products (csv)
                    System.out.println("\n ==================== Export Products ====================\n");
                    break;
                case 10:
                    //Backup Data
                    System.out.println("\n ==================== BackUp Data ====================\n");
                    break;
                case 11:
                    //Restore BackUp
                    System.out.println("\n ==================== Restore BackUp ====================\n");
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