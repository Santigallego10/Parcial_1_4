package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private String address;
    private Cart cart;
    private List<Order> orders;

    public User(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cart = new Cart(this);
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updateInfo(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Object[] getOrderNumbers() {
        String[] orderNumbers = new String[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            orderNumbers[i] = String.valueOf(orders.get(i).getOrderNumber());
        }
        return orderNumbers;
    }

    public void addProductToCart(Product product) {
        this.cart.getProducts().add(product);
    }

    public Object displayCart() {
        return cart.displayProducts();
    }

    public void emptyCart() {
        this.cart = new Cart(this);
    }
}




