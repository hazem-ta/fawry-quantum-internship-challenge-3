package services;

import interfaces.Shippable;
import models.*;

import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        List<Shippable> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            if (item.product instanceof Expirable &&
                ((Expirable) item.product).isExpired()) {
                System.out.println("Error: " + item.product.getName() + " is expired.");
                return;
            }

            if (!item.product.isAvailable(item.quantity)) {
                System.out.println("Error: Not enough stock for " + item.product.getName());
                return;
            }

            subtotal += item.product.getPrice() * item.quantity;

            if (item.product instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    shippables.add((Shippable) item.product);
                }
            }
        }

        double shipping = shippables.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.canPay(total)) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }
        customer.pay(total);

        if (!shippables.isEmpty()) {
            System.out.println("** Shipment notice **");
            Map<String, Double> grouped = new HashMap<>();
            double totalWeight = 0;
            for (Shippable s : shippables) {
                grouped.put(s.getName(), grouped.getOrDefault(s.getName(), 0.0) + s.getWeight());
                totalWeight += s.getWeight();
            }
            for (Map.Entry<String, Double> e : grouped.entrySet()) {
                System.out.println(e.getKey() + "\t" + e.getValue() * 1000 + "g");
            }
            System.out.println("Total package weight " + (totalWeight) + "kg\n");
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.product.getName() + "\t" + (item.product.getPrice() * item.quantity));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shipping);
        System.out.println("Amount\t\t" + total);
        System.out.println("Balance left\t" + customer.getBalance());
    }
}