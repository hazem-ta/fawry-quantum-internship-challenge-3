package models;

import java.time.LocalDate;

public abstract class Expirable extends Product {
    protected LocalDate expiryDate;

    public Expirable(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}