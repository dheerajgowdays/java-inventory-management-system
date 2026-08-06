import java.util.ArrayList;
import java.util.Scanner;
import model.Invoice;
import model.InvoiceItems;
import model.Product;
import repository.InvoiceRepository;
import repository.ProductRepository;
import service.InvoiceService;
import service.ProductService;
import util.IdGenerator;
import util.Validation;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        ProductService service = new ProductService(productRepository);
        InvoiceService invoiceService = new InvoiceService(productRepository,invoiceRepository);
        IdGenerator idGenerator = new IdGenerator();
        Validation validation = new Validation(productRepository);
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
                    System.out.print("Enter Product Id      : ");
                    String productId = sc.nextLine();
                    System.out.print("Enter Product Name    : ");
                    String productName = sc.nextLine();
                    System.out.print("Enter Product Price   : ");
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
                    System.out.print("Enter the Product Id: ");
                    String sProductId = sc.nextLine();
                    service.getProduct(sProductId);
                    break;
                case 4:
                    //Update Product
                    System.out.println("\n ==================== Update Product ====================\n");
                    System.out.print("Enter Product Id:");
                    String uProductID = sc.nextLine();
                    if(service.exist(uProductID)){
                        label:
                        while (true) {
                            System.out.println("\n1. Update Product Name ");
                            System.out.println("2. Update Product Price");
                            System.out.println("3. Update Product Category");
                            System.out.println("4. Update Product Quantity");
                            System.out.println("5. Exit");
                            System.out.println("\nEnter Your Choice:");
                            int uChoice = sc.nextInt();
                            sc.nextLine();
                            switch(uChoice){
                                case 1:
                                    System.out.print("Enter the Product Name: ");
                                    String uProductName = sc.nextLine();
                                    service.updateName(uProductID,uProductName);
                                    break;
                                case 2:
                                    System.out.print("Enter the Product Price: ");
                                    int uPrice = sc.nextInt();
                                    service.updatePrice(uProductID,uPrice);
                                    break;
                                case 3:
                                    System.out.print("Enter the Product Category: ");
                                    String uCategory = sc.nextLine();
                                    service.updateCategory(uProductID,uCategory);
                                    break;
                                case 4:
                                    System.out.print("Enter the Product Quantity: ");
                                    int uQuantity = sc.nextInt();
                                    service.updateQuantity(uProductID,uQuantity);
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
                    System.out.print("Enter the Product Id:");
                    String dProductId = sc.nextLine();
                    service.deleteProduct(dProductId);
                    break;
                case 6:
                    //Generate Invoice
                    ArrayList<InvoiceItems> items = new ArrayList<>();
                    System.out.println("\n ==================== Generate Invoice ====================\n");
                    System.out.print("Enter Customer Name       : ");
                    String customerName = sc.nextLine();
                    System.out.print("Enter Customer PhoneNumber: ");
                    long customerNumber = sc.nextLong();
                    sc.nextLine();
                    boolean yes;
                    int subTotal =0;
                    do {
                        System.out.println("\n -------------------------------- \n");
                        String iProductId;
                        do {
                            System.out.print("Enter the Product Id      : ");
                            iProductId = sc.nextLine();
                        }
                        while (!validation.present(iProductId));
                        invoiceService.getProductForInvoice(iProductId);
                        int iQuantity;
                        do {
                            System.out.print("Enter the Product Quantity: ");
                            iQuantity = sc.nextInt();
                            sc.nextLine();
                        }while(!invoiceService.validateQuantity(iProductId,iQuantity));
                        System.out.print("Add Another Product? (Yes/NO): ");
                        String add = sc.nextLine();
                        yes = validation.product(add);
                        int total = iQuantity*invoiceService.getProductPrice(iProductId);
                        subTotal+=total;
                        InvoiceItems invoiceItems = new InvoiceItems(iProductId,invoiceService.getProductPrice(iProductId),iQuantity,total);
                        invoiceService.addInvoiceItem(invoiceItems);
                    }while(yes);
                    long id = idGenerator.generateInvoiceId();
                    Invoice invoice = new Invoice(id,customerName,customerNumber,items,subTotal);
                    invoiceService.addInvoice(id,invoice);
                    break;
                case 7:
                    //View Invoice
                    System.out.println("\n ==================== View Invoice ==================== \n");
                    System.out.println("Enter the Invoice Id");
                    long invoiceId = sc.nextInt();
                    invoiceService.ViewInvoice(invoiceId);
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