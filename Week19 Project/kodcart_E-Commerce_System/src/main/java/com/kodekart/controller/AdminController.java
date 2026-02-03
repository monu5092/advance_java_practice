package com.kodekart.controller;

import java.util.Scanner;

import com.kodekart.model.Product;
import com.kodekart.service.OrderService;
import com.kodekart.service.ProductService;

public class AdminController {
    
    private Scanner sc = new Scanner(System.in);
    private ProductService productService = new ProductService();
    private OrderService orderService = new OrderService();  

    public void adminMenu() {
        while (true) {
            System.out.println("\n======= Admin Portal =======");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. View All Orders");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    updateProduct();
                    break;

                case 3:
                    deleteProduct();
                    break;

                case 4:
                    viewProduct();
                    break;

                case 5:
                    viewOrders();
                    break;

                case 6:
                    System.out.println("Logged out successfully!");
                    return;

                default:
                    System.out.println("⚠ Invalid choice! Try again...");
            }
        }
    }

    private void addProduct() {
        Product product = new Product();
        System.out.print("Product Name: ");
        product.setName(sc.nextLine());

        System.out.print("Category: ");
        product.setCategory(sc.nextLine());

        System.out.print("Price: ");
        product.setPrice(sc.nextDouble());

        System.out.print("Quantity: ");
        product.setQuantity(sc.nextInt());
        sc.nextLine();

        System.out.print("Description: ");
        product.setDescription(sc.nextLine());

        if (productService.addProduct(product)) {
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Failed to add product.");
        }
    }

    private void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Product product = new Product();
        product.setId(id);

        System.out.print("New Product Name: ");
        product.setName(sc.nextLine());

        System.out.print("New Category: ");
        product.setCategory(sc.nextLine());

        System.out.print("New Price: ");
        product.setPrice(sc.nextDouble());

        System.out.print("New Quantity: ");
        product.setQuantity(sc.nextInt());
        sc.nextLine();

        System.out.print("New Description: ");
        product.setDescription(sc.nextLine());

        if (productService.updateProduct(product)) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Failed to update product.");
        }
    }

    private void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        if (productService.deleteProduct(id)) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found or delete failed.");
        }
    }

    private void viewProduct() {
        System.out.println("\n------ Product List ------");
        productService.viewAllProduct().forEach(p ->
            System.out.println(p.getId() + " | " + p.getName() + " | " + p.getCategory() + " | ₹" + p.getPrice() + " | Qty: " + p.getQuantity())
        );
    }

    private void viewOrders() {
        System.out.println("\n------ All Orders ------");
        orderService.viewAllOrders().forEach(o ->
            System.out.println(o.getId() + " | User: " + o.getUserId() + " | Date: " + o.getOrderDate() + " | Total: ₹" + o.getTotalAmount())
        );
    }
}