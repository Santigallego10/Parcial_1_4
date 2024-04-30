package models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class WebStore {
    private String webStoreName;
    private List<User> users;
    private List<Product> products;
    private User activeUser;

    public WebStore(String webStoreName) {
        this.webStoreName = webStoreName;
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public String getWebStoreName() {
        return webStoreName;
    }

    public void setWebStoreName(String webStoreName) {
        this.webStoreName = webStoreName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User login(String email, String password) {
        for(User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void editUser() {
        User user = this.getActiveUser();

        String newName = (String) JOptionPane.showInputDialog(null, "Nombre:", "Editar Usuario", JOptionPane.QUESTION_MESSAGE, null, null, user.getName());
        user.setName(newName);

        String newEmail = (String) JOptionPane.showInputDialog(null, "Email:", "Editar Usuario", JOptionPane.QUESTION_MESSAGE, null, null, user.getEmail());
        user.setEmail(newEmail);

        String newPassword = (String) JOptionPane.showInputDialog(null, "Contraseña:", "Editar Usuario", JOptionPane.QUESTION_MESSAGE, null, null, user.getPassword());
        user.setPassword(newPassword);

        String newAddress = (String) JOptionPane.showInputDialog(null, "Dirección:", "Editar Usuario", JOptionPane.QUESTION_MESSAGE, null, null, user.getAddress());
        user.setAddress(newAddress);
    }

    public Order findByNumber(int orderNumber) {
        for (Order order : activeUser.getOrders()) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }

    public Object[] getProductNames() {
        String[] productNames = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            productNames[i] = products.get(i).getName();
        }
        return productNames;
    }

    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
