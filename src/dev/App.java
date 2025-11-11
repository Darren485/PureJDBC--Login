package dev;

import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    static LoginDAO loginDAO = new LoginDAO();

    public static void main(String[] args) {

        System.out.println("LOGIN SYSTEM");

        while (true) {
            showMenu();
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1 ->
                    addUser();

                case 2 ->
                    viewAllLogin();

                case 3 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }

                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("\nMenu:");
        System.out.println("1. Register");
        System.out.println("2. View All Login (Admin)");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addUser() {
        System.out.println("\n " + "=".repeat(40));
        System.out.println("REGISTER NEW USER");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        Login newUser = new Login(0, username, password);
        loginDAO.save(newUser);
    }

    private static void viewAllLogin() {
        System.out.println("\n " + "=".repeat(40));
        System.out.println("ALL REGISTERED Login");

        for (Login login : loginDAO.getAllLogins()) {
            System.out.println("ID: " + login.getId() + ", Username: " + login.getUsername() + ", Password: " + login.getPassword());
        }
    }

}
