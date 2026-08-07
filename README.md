# 📦 File-Based Inventory Management System

A **Core Java** console application that manages inventory and invoices without using a database.  
All data is persisted using **Java Serialization**, while products can also be imported/exported using **CSV files**.

This project demonstrates clean software architecture, Object-Oriented Programming, Java Collections, File Handling, Serialization, CSV Processing, and layered application design.

---

# ✨ Features

## 📦 Product Management
- Add Product
- View Products
- Search Product
- Update Product
- Delete Product

---

## 🧾 Invoice Management
- Generate Invoice
- View Invoice
- Automatic Inventory Update
- Stock Validation

---

## 📂 CSV Support
- Import Products from CSV
- Export Products to CSV

---

## 💾 Data Persistence
- Product Serialization
- Invoice Serialization
- Automatic Save on Data Modification

---

## 🔄 Backup & Restore
- Backup Product Data
- Backup Invoice Data
- Restore Product Data
- Restore Invoice Data

---

# 🛠 Technologies Used

- Java 21
- Java Collections Framework
- Object-Oriented Programming
- Java Serialization
- Java File I/O
- Java NIO (Path, Files)
- CSV File Processing
- Exception Handling

---

# 📁 Project Structure

```
Inventory-Management-System/
│
├── model/
│   ├── Product.java
│   ├── Invoice.java
│   └── InvoiceItems.java
│
├── repository/
│   ├── ProductRepository.java
│   └── InvoiceRepository.java
│
├── service/
│   ├── ProductService.java
│   ├── InvoiceService.java
│   ├── CSVService.java
│   └── BackupService.java
│
├── storage/
│   └── FileStorage.java
│
├── util/
│   ├── Validation.java
│   └── IdGenerator.java
│
├── storage/
│   ├── products.dat
│   └── invoice.dat
│
├── backup/
│   ├── products.dat
│   └── invoice.dat
│
└── Main.java
```

---

# 📋 Menu

```
1. Add Product
2. View Products
3. Search Product
4. Update Product
5. Delete Product
6. Generate Invoice
7. View Invoice
8. Import Products (CSV)
9. Export Products (CSV)
10. Backup Data
11. Restore Backup
12. Exit
```

---

# 🧱 Architecture

```
                Main
                  │
                  ▼
        -------------------
        |     Service      |
        -------------------
        │       │       │
        ▼       ▼       ▼
 Product  Invoice   CSV/Backup
 Service  Service    Service
        │
        ▼
    Repository
        │
        ▼
   File Storage
        │
        ▼
 Serialization / CSV
```

---

# 📂 Data Storage

### Serialized Files

```
storage/
├── products.dat
└── invoice.dat
```

These files store the complete application state using Java Serialization.

---

### CSV Export

```
products.csv
```

CSV files can be opened using:

- Microsoft Excel
- LibreOffice Calc
- Google Sheets
- Any Text Editor

---

# 💡 Concepts Demonstrated

- Object-Oriented Programming
- Classes & Objects
- Encapsulation
- Packages
- Layered Architecture
- Repository Pattern
- Service Layer
- Java Collections
- LinkedHashMap
- ArrayList
- Iterator
- File Handling
- BufferedReader
- BufferedWriter
- FileReader
- FileWriter
- Java Serialization
- Deserialization
- Java NIO
- CSV Import/Export
- Backup & Restore
- Exception Handling

---

# 🔄 Application Workflow

```
User
 │
 ▼
Main Menu
 │
 ▼
Service Layer
 │
 ▼
Repository Layer
 │
 ▼
File Storage
 │
 ▼
Serialized Files / CSV Files
```

---

# 🚀 Future Improvements

- Employee Authentication
- Admin/User Roles
- Product Categories
- Search using Streams
- JSON Support
- Database Integration (MySQL/PostgreSQL)
- Spring Boot REST API
- JavaFX/Desktop GUI
- Unit Testing with JUnit

---

# 📚 Learning Outcomes

This project helped reinforce:

- Designing layered applications
- Separating business logic from persistence
- Working with Java Collections
- Implementing Serialization & Deserialization
- Reading/Writing CSV files
- Building a real-world console application
- Applying clean project structure

---

# 👨‍💻 Author

**Dheeraj Gowda**

Core Java Project Series

Level 4 — File-Based Inventory Management System