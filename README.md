## Overview

This repository contains a solution for the Fawry Rise Journey Full Stack Development Internship Challenge. The project implements a simple e-commerce system in Java.
The system simulates a basic online shopping experience. It allows defining different product types, managing a shopping cart, checking out with balance validation, and handling shipping and expiration rules.

## Features

- Define products with name, price, and quantity.
- Support for:
  - Expirable products (e.g., Cheese, Biscuits) with real expiration dates.
  - Non-expirable products (e.g., TV, Scratch Cards).
  - Shippable products that declare their weight.
- Add products to cart with a quantity limit based on available stock.
- Validate products for expiration and availability before checkout.
- Calculate and display:
  - Subtotal
  - Shipping fees (if applicable)
  - Total amount
  - Remaining customer balance
- Simulate a shipping service interface for handling shippable items.
- Print structured console output for shipment and checkout receipts.
- Handle errors for empty cart, expired products, out-of-stock items, and insufficient balance.

## How to Run

1. Clone the repository.
2. Open the project in a Java IDE (I recommend IntelliJ IDEA, VS Code, or Eclipse).
3. Ensure you have Java 8 or later is installed.
4. Run `Main.java`.
5. View the results in the console.

## Project Structure

```
src/
├── Main.java
├── interfaces/
│   └── Shippable.java
├── models/
│   ├── Product.java
│   ├── Expirable.java
│   ├── ExpirableProduct.java
│   ├── RegularProduct.java
│   ├── CartItem.java
│   ├── Cart.java
│   └── Customer.java
└── services/
    └── CheckoutService.java
```

## Sample Output

```
** Shipment notice **
Biscuits         300g
Cheese           1000g
Total package weight 1.3kg

** Checkout receipt **
2x Cheese        200.0
1x Biscuits      70.0
1x Scratch Card  50.0
----------------------
Subtotal         320.0
Shipping         30.0
Amount           380.0
Balance left     120.0
```


## Notes
- All logic is kept minimal and focused to match the challenge requirements.
