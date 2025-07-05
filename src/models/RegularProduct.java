package models;

import interfaces.Shippable;

public class RegularProduct extends Product implements Shippable {
    private double weight;

    public RegularProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}