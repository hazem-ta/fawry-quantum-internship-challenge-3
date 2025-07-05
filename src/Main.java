import models.*;
import services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Product cheese = new ExpirableProduct("Cheese", 100, 5, LocalDate.of(2025,7,11), 0.5);
        Product biscuits = new ExpirableProduct("Biscuits", 70, 2, LocalDate.of(2025,9,5), 0.3);
        Product scratchCard = new Product("Scratch Card", 50, 10) {};
        Product tv = new RegularProduct("TV", 200, 3, 2.0);

        // ------------------------------------------------------------------
        // Customer one Hazem
        Customer Hazem = new Customer("Hazem", 800);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(Hazem, cart);
        System.out.println("\n\n");

        // ------------------------------------------------------------------
        // Customer two Nada
        Customer Nada = new Customer("Nada", 900);

        Cart cart2 = new Cart();
        cart2.add(cheese, 2);
        cart2.add(tv, 1);
        cart2.add(scratchCard, 1);

        CheckoutService.checkout(Nada, cart);

    }
}