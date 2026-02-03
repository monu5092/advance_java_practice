package com.kodekart.controller;

import java.util.Scanner;

import com.kodekart.dao.UserDao;
import com.kodekart.model.User;
import com.kodekart.service.UserService;

public class MainController {

    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService();

    public void startApp() {
        while (true) {
            System.out.println("\n********* Welcome To KodeKart **********");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); 

            switch (ch) {
                case 1:
                    doRegister();
                    break;
                case 2:
                    doLogin();
                    break;
                case 3:
                    System.out.println("Thank you! Goodbye");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private void doRegister() {
        User user = new User();

        System.out.println("\nRegister As:");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("Enter choice: ");

        int roleChoice = sc.nextInt();
        sc.nextLine();

        user.setRole(roleChoice == 2 ? "admin" : "user");

        System.out.print("Enter Name: ");
        user.setName(sc.nextLine());

        System.out.print("Enter Email: ");
        user.setEmail(sc.nextLine());

        System.out.print("Enter Phone: ");
        user.setPhone(sc.nextLine());

        System.out.print("Enter Password: ");
        user.setPassword(sc.nextLine());

        if (userService.getRegister(user)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("\nRegistration failed!");
        }
    }

    private void doLogin() {
        System.out.println("\nLogin As:");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = userService.getLogin(email, password);

        if (user == null) {
            System.out.println("\nInvalid credentials!");
            return;
        }

        switch (choice) {
            case 1: 
                if (user!= null && user.getRole().equalsIgnoreCase("user") &&
                    email.equalsIgnoreCase(user.getEmail()) &&
                    password.equals(user.getPassword())) {

                    System.out.println("\nLogged in as User!");
                    new UserController().userMenu(user);
                } else {
                    System.out.println("\nRole mismatch! You are not a User.");
                }
                break;

            case 2: 
                if (user != null && user.getRole().equalsIgnoreCase("admin") &&
                    email.equalsIgnoreCase(user.getEmail()) &&
                    password.equals(user.getPassword())) {

                    System.out.println("\nLogged in as Admin!");
                    new AdminController().adminMenu();
                    
                } else {
                    System.out.println("\nRole mismatch! You are not an Admin.");
                }
                break;

            default:
                System.out.println("\nInvalid login option!");
                break;
        }
    }

}
