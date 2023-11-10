package com.shoppingcart;

import com.shoppingcart.adapter.Product;
import com.shoppingcart.strategy.CashOnDeliveryPayment;
import com.shoppingcart.strategy.CreditCardPayment;
import com.shoppingcart.strategy.PayPalPayment;
import com.shoppingcart.strategy.PaymentStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = ShoppingCart.getInstance();

        System.out.println("Welcome to the Online Shopping Cart!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a product to the cart");
            System.out.println("2. View cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProductToCart(scanner, cart, Product.getProducts());
                    break;
                case 2:
                    viewCart(scanner, cart, Product.getProducts());
                    break;
                case 3:
                    checkout(cart);
                    break;
                case 4:
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProductToCart(Scanner scanner, ShoppingCart cart, List<Product> products) {
        System.out.println("Available products:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
        }

        System.out.print("Enter the number of the product you want to add to the cart: ");
        int productNumber = scanner.nextInt();

        if (productNumber < 1 || productNumber > products.size()) {
            System.out.println("Invalid product number. Please try again.");
            return;
        }

        Product selectedProduct = products.get(productNumber - 1);
        cart.addProduct(selectedProduct);
        System.out.println(selectedProduct.getName() + " added to the cart.");
    }

    private static void viewCart(Scanner scanner, ShoppingCart cart, List<Product> products) {
        System.out.println("Your Shopping Cart:");
        System.out.println("Total: $" + cart.getTotal());
        List<Product> cartProducts = cart.getProducts();
        if (cartProducts.isEmpty()) {
            System.out.println("Your cart is empty.");
            System.out.println("Press Enter to return to the main menu.");
            scanner.nextLine();
            scanner.nextLine();
            return;
        } else {
            System.out.println("Products:");
            for (int i = 0; i < cartProducts.size(); i++) {
                Product product = cartProducts.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
            }
            System.out.println((cartProducts.size() + 1) + ". Remove a product from the cart");
            System.out.println((cartProducts.size() + 2) + ". Exit cart");
        }

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > cartProducts.size() + 2) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        if (choice == cartProducts.size() + 1) {
            removeProductFromCart(scanner, cart, cartProducts);
        } else if (choice == cartProducts.size() + 2) {
            System.out.println("Exiting cart.");
        } else {
            Product selectedProduct = cartProducts.get(choice - 1);
            System.out.println(selectedProduct.getName() + " - $" + selectedProduct.getPrice() + " removed from the cart.");
            cart.removeProduct(selectedProduct);
        }
    }



    private static void removeProductFromCart(Scanner scanner, ShoppingCart cart, List<Product> products) {
        System.out.print("Enter the number of the product you want to remove from the cart: ");
        int productNumber = scanner.nextInt();

        if (productNumber < 1 || productNumber > products.size()) {
            System.out.println("Invalid product number. Please try again.");
            return;
        }

        Product selectedProduct = products.get(productNumber - 1);
        cart.removeProduct(selectedProduct);
        System.out.println(selectedProduct.getName() + " - $" + selectedProduct.getPrice() + " removed from the cart.");
    }

    private static void checkout(ShoppingCart cart) {
        System.out.println("Select a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Cash on Delivery");
        Scanner scanner = new Scanner(System.in);
        int paymentChoice = scanner.nextInt();

        PaymentStrategy paymentStrategy;

        switch (paymentChoice) {
            case 1:
                paymentStrategy = new CreditCardPayment ();
                break;
            case 2:
                paymentStrategy = new PayPalPayment ();
                break;
            case 3:
                paymentStrategy = new CashOnDeliveryPayment ();
                break;
            default:
                System.out.println("Invalid payment method. Please try again.");
                return;
        }

        paymentStrategy.pay(cart.getTotal());
        System.out.println("Payment successful. Thank you for your purchase!");
    }
}
