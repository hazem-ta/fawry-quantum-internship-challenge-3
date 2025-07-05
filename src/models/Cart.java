package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int qty) {
        if (!product.isAvailable(qty)) throw new RuntimeException("Insufficient stock");
        items.add(new CartItem(product, qty));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}