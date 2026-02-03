package com.kodekart.controller;

import java.util.List;
import java.util.Scanner;

import com.kodekart.model.Cart;
import com.kodekart.model.Order;
import com.kodekart.model.Product;
import com.kodekart.model.User;
import com.kodekart.service.CartService;
import com.kodekart.service.OrderService;
import com.kodekart.service.ProductService;

public class UserController {

    private Scanner sc = new Scanner(System.in);
    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();
    private OrderService orderService = new OrderService();

    public void userMenu(User user) {

        while (true) {
            System.out.println("\n******* User Portal ******");
            System.out.println("1. View Products");
            System.out.println("2. Search Product");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Order History");
            System.out.println("7. Logout");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    viewProduct();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    addToCart(user);
                    break;
                case 4:
                    viewCart(user);
                    break;
                case 5:
                    placeOrder(user);
                    break;
                case 6:
                    viewOrderHistory(user);
                    break;
                case 7:
                    System.out.println("\nLogged out Successfully!!\n");
                    return;
                default:
                    System.out.println("\nInvalid Choice! Please Try Again.\n");
            }
        }
    }

   public void viewProduct() {
        System.out.println("\n--- Available Products ---");
        List<Product> products = productService.viewAllProduct();
        if (products.isEmpty()) {
            System.out.println("No products available");
        } else {
        	 products.forEach(p ->
             System.out.println("ID: " + p.getId()
                     + " | Name: " + p.getName()
                     + " | Category: " + p.getCategory()
                     + " | Price: " + p.getPrice()
                     + " | Qty: " + p.getQuantity()
                     + " | Desc: " + p.getDescription())
     );
        }
    }

    private void searchProduct() {
        System.out.print("\nEnter product name to search: ");
        sc.nextLine(); 
        String name = sc.nextLine();

        List<Product> result = productService.searchProduct(name);

        if (result.isEmpty()) {
            System.out.println("\nNo product found matching: " + name);
        } else {
            System.out.println("\n--- Search Result ---");
            result.forEach(p ->
                System.out.println(p.getId() + " | " + p.getName() + " | " + p.getPrice())
            );
        }
    }

    private void addToCart(User user) {
        System.out.print("\nEnter Product ID: ");
        int pid = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        Cart cart = new Cart();
        cart.setUserId(user.getId());  
        cart.setProductId(pid);
        cart.setQuantity(qty);

       
        boolean added = cartService.addTocart(cart);

        if (added) {
            System.out.println("\n Product added to cart!");
        } else {
            System.out.println("\n Failed to add to cart! Check your database column names.");
        }
    }


    private void viewCart(User user) {

        List<Cart> cart = cartService.getCart(user.getId());

        if (cart.isEmpty()) {
            System.out.println("\n🛒 Your cart is empty!");
        } else {
            System.out.println("\n--- Your Cart ---");
            cart.forEach(c ->
                System.out.println("Cart ID: " + c.getId()
                    + " | Product ID: " + c.getProductId()
                    + " | Qty: " + c.getQuantity())
            );
        }
    }

    private void placeOrder(User user) {

        boolean success = orderService.placeOrder(user.getId());

        if (success)
            System.out.println("\n Order placed successfully!");
        else
            System.out.println("\n Failed to place order. Cart is empty or error occurred.");
    }

    private void viewOrderHistory(User user) {

        List<Order> orders = orderService.getOrdersByUser(user.getId());

        if (orders.isEmpty()) {
            System.out.println("\n No previous orders found!");
        } else {
            System.out.println("\n--- Order History ---");
            orders.forEach(order ->
                System.out.println("Order ID: " + order.getId()
                    + " | Date: " + order.getOrderDate()
                    + " | Total: " + String.format("%.2f", order.getTotalAmount()))
            );
        }
    }
}
