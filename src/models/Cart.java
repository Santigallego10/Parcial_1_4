package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private User user;
    private List<Product> products;

    public Cart(User user) {
        this.user = user;
        this.products = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String displayProducts() {
        StringBuilder sb = new StringBuilder();
        double total = 0;

        for (Product product : products) {
            sb.append("Product: ").append(product.getName()).append(", Price: ").append(product.getPrice()).append("\n");
            total += product.getPrice();
        }

        sb.append("Total: ").append(total);

        return sb.toString();
    }
}
