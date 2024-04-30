package models;

import java.util.Date;
import java.util.List;

public class Order {
    private static int orderCounter = 1; // Contador de órdenes
    private int orderNumber;
    private User user;
    private Date date;
    private Double total;
    private List<Product> products;

    public Order(User user, Date date, List<Product> products) {
        this.orderNumber = orderCounter++; // Asigna el número de orden e incrementa el contador
        this.user = user;
        this.date = date;
        this.products = products;
        this.total = calculateTotal(products);
    }

    private double calculateTotal(List<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", user=" + user +
                ", date=" + date +
                ", total=" + total +
                ", products=" + products +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }
}
