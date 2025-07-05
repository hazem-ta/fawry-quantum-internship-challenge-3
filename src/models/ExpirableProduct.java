package models;

import interfaces.Shippable;
import java.time.LocalDate;

public class ExpirableProduct extends Expirable implements Shippable {
    private double weight;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}