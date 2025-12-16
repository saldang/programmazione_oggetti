---
layout: post
title: "Traccia 16 Dicembre 2025 -` EN"
date: 2025-12-16
---

## Video Game Store Management System 🎮

Develop a management system for a video game store that allows managing products of different types, customers and their sales. The program must use fundamental OOP concepts.

## 1. INHERITANCE AND ABSTRACT CLASSES

Implement a class hierarchy for products:

* Abstract class `Product` with common attributes (code, title, price, availableQuantity)
* Concrete classes: `VideoGame`, `Console`, `Accessory` (inherit from `Product`)
* Each product type must have its own specific attributes (platform, genre, type, etc.)

## 2. INTERFACES

Implement two interfaces:

* `Sellable`: methods `sell(int quantity)`, `isAvailable()`
* `Discountable`: methods `applyDiscount(double percentage)`

All products must implement `Sellable` and `Discountable`.

## 3. FILE READING AND WRITING

* **Writing**: Save to `.txt` or `.csv` file the list of completed sales with details (customer, product, quantity, total price)
* **Reading**: Load previous sales from file at startup (handle file absence)

## 4. POLYMORPHISM

* Implement a polymorphic `showDetails()` method in each `Product` class that returns specific information of the type
* Use a generic list of `Product` to store all products and invoke the polymorphic method on each

## 5. EXCEPTION HANDLING

* Custom exception `QuantityNotAvailableException` if attempting to sell more products than available
* Custom exception `InvalidCustomerException` if customer data is incomplete
* Exception for file read/write errors
* Properly handle `try-catch` in the main program

---

## PROGRAM STRUCTURE

### Classes to implement

```
Product (abstract class)
├── VideoGame
├── Console
└── Accessory

Sellable (interface)
Discountable (interface)

Customer
Sale
Store (main management class)
StoreMain (class with main for testing)
```

### Product Class (abstract)

* **Attributes**: code, title, price, availableQuantity
* **Methods**:
  * `sell(int quantity)`: implementation of `Sellable`
  * `isAvailable()`: implementation of `Sellable`
  * `applyDiscount(double percentage)`: implementation of `Discountable`
  * `showDetails()`: abstract
  * Getters and setters

### Concrete Product Classes

#### VideoGame

* **Base price**: variable (to be specified)
* **Specific attributes**:
  * `platform: String` (e.g., "PlayStation 5", "Xbox Series X", "Nintendo Switch")
  * `genre: String` (e.g., "Action", "RPG", "Sports")
  * `used: boolean` (if it's used, default false)
* **applyDiscount() method**:
  * If used: discount already applied of 30% on base price
  * Otherwise: apply the requested discount normally
* **showDetails() method**: prints code, title, platform, genre, price, if it's used
* **toString() method**: format "[VideoGame] Title - Platform - €X.XX"

#### Console

* **Base price**: variable (to be specified)
* **Specific attributes**:
  * `brand: String` (e.g., "Sony", "Microsoft", "Nintendo")
  * `model: String` (e.g., "PlayStation 5", "Xbox Series X")
  * `storage: int` (capacity in GB, e.g., 512, 1024)
* **applyDiscount() method**:
  * Consoles have limited discounts: maximum 10% discount
  * If requested discount is greater than 10%, apply only 10%
* **showDetails() method**: prints code, title, brand, model, storage, price
* **toString() method**: format "[Console] Brand Model - Storage GB - €X.XX"

#### Accessory

* **Base price**: variable (to be specified)
* **Specific attributes**:
  * `type: String` (e.g., "Controller", "Headset", "HDMI Cable")
  * `compatibility: String` (e.g., "Universal", "PlayStation", "Xbox")
  * `wireless: boolean` (if it's wireless, default false)
* **applyDiscount() method**:
  * Apply the requested discount normally
  * If wireless: maximum discount of 15%
* **showDetails() method**: prints code, title, type, compatibility, if it's wireless, price
* **toString() method**: format "[Accessory] Type - Title - €X.XX"

### Customer Class

* **Attributes**:
  * `firstName: String`
  * `lastName: String`
  * `email: String`
  * `loyaltyCard: String` (loyalty card code)
* **Validation methods** (must throw `InvalidCustomerException`):
  * **FirstName**: not null, not empty, at least 2 characters
  * **LastName**: not null, not empty, at least 2 characters
  * **Email**: not null, not empty, must contain "@" and "."
* **Methods**:
  * `toString()`: format "[Customer] FirstName LastName - Email: email"
  * `equals()` and `hashCode()` (comparison based on email)

### Sale Class

* **Attributes**: customer, product, quantity, totalPrice, saleDate
* **Methods**: toString() for display, method to save to file

### Store Class

* **Attributes**: name, list of products, list of sales
* **Methods**:
  * `addProduct(Product p)`
  * `findProduct(String title)`: returns product with that title
  * `createSale(Customer c, Product p, int quantity)`:
    * Check availability, throw `QuantityNotAvailableException` if insufficient quantity
    * Check customer validity, throw `InvalidCustomerException` if not valid
    * Create sale and update product quantity
  * `loadSalesFromFile(String fileName)`: file exception handling
  * `saveSalesToFile(String fileName)`: file exception handling
  * `displaySales()`
  * `displayAllProducts()`

### Custom Exceptions

#### QuantityNotAvailableException

* **Used when**: attempting to sell more products than available in stock
* **Suggested message**: "Quantity not available for 'Title' (Requested: X, Available: Y)"

#### InvalidCustomerException

* **Used when**: customer data does not meet validation criteria
* **Constructor**:

  ```java
  public InvalidCustomerException(String message, String field)
  ```

* **Failed validation fields**:
  * "FIRSTNAME" - if first name not valid
  * "LASTNAME" - if last name not valid
  * "EMAIL" - if email not valid
* **Suggested message**: "Error in field FIELD: specific message"

### StoreMain Class

Implement a test program that:

1. **Creates a store** with 5 products:
   * 2 VideoGames (one new, one used)
   * 2 Consoles (different brands)
   * 1 Accessory (wireless)
2. **Creates 3 test customers**:
   * Customer 1: valid (e.g., "Mark Smith", "<mark@email.com>", "LOYALTY001")
   * Customer 2: valid (e.g., "Sarah Johnson", "<sarah@email.com>", "LOYALTY002")
   * Customer 3: NOT valid (test exception, e.g., email without @)
3. **Attempts to create invalid customer** and catch `InvalidCustomerException`
4. **Makes 3 valid sales**:
   * Sale 1: Customer 1, new VideoGame, quantity 1
   * Sale 2: Customer 2, Console, quantity 1
   * Sale 3: Customer 1, Accessory, quantity 2
5. **Applies discounts** to some products:
   * 20% discount on video game
   * 15% discount on console (will be limited to 10%)
6. **Attempts sale with unavailable quantity** and catch `QuantityNotAvailableException`
7. **Saves sales to file** (`sales.txt` or `sales.csv`):
   * Handle `IOException` if save fails
   * CSV format: `Customer,Product,Quantity,UnitPrice,TotalPrice,Date`
8. **Loads sales from file** and display
9. **Displays all products** with their details (polymorphism)

**Expected output**:

```
==== VIDEO GAME STORE ====
[Creating store and 5 products]
[Creating customers]
ERROR CAUGHT: Error in field EMAIL: invalid email format
[Applying discounts]
20% discount applied to: VideoGame X
Discount limited to 10% for: Console Y (maximum allowed)
[Creating 3 valid sales]
Sale 1: Mark Smith - VideoGame "Title" x1 - €XX.XX
Sale 2: Sarah Johnson - Console "Model" x1 - €XXX.XX
Sale 3: Mark Smith - Accessory "Name" x2 - €XX.XX
ERROR CAUGHT: Quantity not available for 'Title' (Requested: 10, Available: 2)
[Saving sales to file]
[Loading sales from file]
[Displaying details of all products]
==== END TEST ====
```

---

## TEST MAIN IMPLEMENTATION EXAMPLE

```java
public class StoreMain {
    public static void main(String[] args) {
        System.out.println("==== VIDEO GAME STORE ====\n");

        // 1. Store creation
        Store store = new Store("GameWorld");

        // 2. Product creation
        System.out.println("[Creating store and 5 products]");
        VideoGame game1 = new VideoGame("VG001", "The Last of Us Part II", 69.99, 5, "PlayStation 5", "Action", false);
        VideoGame game2 = new VideoGame("VG002", "FIFA 23", 39.99, 3, "PlayStation 5", "Sports", true);
        Console console1 = new Console("CN001", "PlayStation 5 Digital", 449.99, 2, "Sony", "PS5 Digital", 825);
        Console console2 = new Console("CN002", "Xbox Series S", 299.99, 4, "Microsoft", "Series S", 512);
        Accessory acc1 = new Accessory("AC001", "DualSense Controller", 69.99, 10, "Controller", "PlayStation", true);

        store.addProduct(game1);
        store.addProduct(game2);
        store.addProduct(console1);
        store.addProduct(console2);
        store.addProduct(acc1);
        System.out.println("Products added to catalog.\n");

        // 3. Customer creation
        System.out.println("[Creating customers]");
        Customer customer1 = null;
        Customer customer2 = null;
        Customer customer3 = null;

        try {
            customer1 = new Customer("Mark", "Smith", "mark@email.com", "LOYALTY001");
            System.out.println("Customer 1 created: " + customer1);
        } catch (InvalidCustomerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            customer2 = new Customer("Sarah", "Johnson", "sarah@email.com", "LOYALTY002");
            System.out.println("Customer 2 created: " + customer2);
        } catch (InvalidCustomerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Invalid customer - email without @
        try {
            customer3 = new Customer("Paul", "Green", "paulemail.com", "LOYALTY003");
            System.out.println("Customer 3 created: " + customer3);
        } catch (InvalidCustomerException e) {
            System.out.println("ERROR CAUGHT: " + e.getMessage());
        }
        System.out.println();

        // 4. Applying discounts
        System.out.println("[Applying discounts]");
        game1.applyDiscount(20.0);
        System.out.println("20% discount applied to: " + game1.getTitle() + " - New price: €" +
                           String.format("%.2f", game1.getPrice()));

        console1.applyDiscount(15.0);
        System.out.println("15% discount requested for: " + console1.getTitle() +
                           " (limited to 10% maximum) - New price: €" +
                           String.format("%.2f", console1.getPrice()));
        System.out.println();

        // 5. Creating valid sales
        System.out.println("[Creating 3 valid sales]");
        try {
            store.createSale(customer1, game1, 1);
            System.out.println("Sale 1: Mark Smith - " + game1.getTitle() + " x1 - €" +
                               String.format("%.2f", game1.getPrice()));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            store.createSale(customer2, console1, 1);
            System.out.println("Sale 2: Sarah Johnson - " + console1.getTitle() + " x1 - €" +
                               String.format("%.2f", console1.getPrice()));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            store.createSale(customer1, acc1, 2);
            System.out.println("Sale 3: Mark Smith - " + acc1.getTitle() + " x2 - €" +
                               String.format("%.2f", acc1.getPrice() * 2));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println();

        // 6. Attempting sale with unavailable quantity
        System.out.println("[Attempting sale with excessive quantity]");
        try {
            store.createSale(customer2, game1, 10);
        } catch (QuantityNotAvailableException e) {
            System.out.println("ERROR CAUGHT: " + e.getMessage());
        } catch (InvalidCustomerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println();

        // 7. Saving sales to file
        System.out.println("[Saving sales to file]");
        try {
            store.saveSalesToFile("sales.csv");
            System.out.println("Sales saved successfully to sales.csv");
        } catch (IOException e) {
            System.out.println("ERROR saving: " + e.getMessage());
        }
        System.out.println();

        // 8. Loading sales from file
        System.out.println("[Loading sales from file]");
        try {
            store.loadSalesFromFile("sales.csv");
            System.out.println("Sales loaded successfully from sales.csv");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR reading: " + e.getMessage());
        }
        System.out.println();

        // 9. Displaying all sales
        System.out.println("[Displaying sales]");
        store.displaySales();
        System.out.println();

        // 10. Displaying all products (polymorphism)
        System.out.println("[Displaying details of all products - POLYMORPHISM]");
        store.displayAllProducts();

        System.out.println("\n==== END TEST ====");
    }
}
```

---

## EXAMPLE SALES CSV FILE

File: `sales.csv`

```csv
Customer,Product,Quantity,UnitPrice,TotalPrice,Date
Mark Smith,The Last of Us Part II,1,55.99,55.99,2024-11-12
Sarah Johnson,PlayStation 5 Digital,1,404.99,404.99,2024-11-12
Mark Smith,DualSense Controller,2,69.99,139.98,2024-11-12
```

### CSV Format Explanation

* **Customer**: Customer's full name (FirstName LastName)
* **Product**: Title of the sold product
* **Quantity**: Number of units sold
* **UnitPrice**: Price per single unit (with any discounts already applied)
* **TotalPrice**: Total sale price (UnitPrice × Quantity)
* **Date**: Sale date in YYYY-MM-DD format

### Implementation Notes

When saving to file, the `Store` class should:

1. Open the file in write mode
2. Write the header row
3. For each sale, write a row with comma-separated data
4. Properly handle IOException exceptions

When loading from file, the `Store` class should:

1. Verify that the file exists (handle FileNotFoundException)
2. Read the first row (header) and discard it
3. Read each subsequent row and parse the data
4. Reconstruct Sale objects with the read data
5. Properly handle any format errors
