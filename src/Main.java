import models.*;
import Util.Util;
import models.WebStore;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        WebStore store = new WebStore("Tienda Web");

        store.setUsers(Util.generateUserList());
        store.setProducts(Util.generateProductList());

        if(login(store)){
            boolean flag = true;
            while(flag){
                int opcion = mainMenu(store);

                switch(opcion){
                    case 0:
                        flag = false;
                        break;
                    case 1:
                        myAccountMessage(store);
                        break;
                    case 2:
                        myOrders(store);
                        break;
                    case 3:
                        buyMessage(store);
                        break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Login Failed");
        }
    }

    private static void myAccountMessage(WebStore store) {
        boolean flag = true;

        String[] opciones
                ={"Atras","Editar mi información"};

        while(flag){

            int opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opcion",
                    store.getWebStoreName(), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones,
                    null);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    store.editUser();
                    break;
                case 2:
                    myOrders(store);
                    break;
                case 3:
                    buy(store);
                    break;
            }
        }
    }

    private static void buyMessage(WebStore store) {
        boolean flag = true;

        String[] opciones
                ={"Atras","Pagar Carrito","Mi carrito","Agregar productos"};

        while(flag){
            int opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opcion",
                    store.getWebStoreName(), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones,
                    null);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    payCart(store);
                    break;
                case 2:
                    myCar(store);
                    break;
                case 3:
                    buy(store);
                    break;
            }
        }
    }

    private static void payCart(WebStore store) {
        User user = store.getActiveUser();

        boolean flag = true;

        String[] opciones
                ={"Atras","Vaciar Carrito", "Confirmar Compra"};

        while(flag){
            int opcion = JOptionPane.showOptionDialog(null,
                    user.displayCart(),
                    "Carrito de: "+user.getName(), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones,
                    null);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    user.emptyCart();
                    break;
                case 2:
                    createOrder(store);
                    break;
            }
        }
    }

    private static void createOrder(WebStore store) {
        User user = store.getActiveUser();
        Date currentDate = new Date();

        List<Product> listaProductos = user.getCart().getProducts();

        Order order = new Order(user, currentDate, listaProductos);

        user.emptyCart();

        user.getOrders().add(order);
    }

    private static void myCar(WebStore store) {
        User user = store.getActiveUser();

        JOptionPane.showMessageDialog(null, user.displayCart());
    }

    private static void buy(WebStore store) {
        User user = store.getActiveUser();

        String productName = (String) JOptionPane.showInputDialog(null,
                "Abajo seleccione el producto que desea:", store.getWebStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, store.getProductNames(), null);

        Product product = store.findProductByName(productName);

        user.addProductToCart(product);

        JOptionPane.showMessageDialog(null, "El producto: "+product.getName() + "Ha sido agregado a su carrito");
    }

    private static void myOrders(WebStore store) {
        User user = store.getActiveUser();

        String orderNumber = (String) JOptionPane.showInputDialog(null,
                "Seleccione la compra que desea ver", store.getWebStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, user.getOrderNumbers(), null);

        Order order = store.findByNumber(Integer.parseInt(orderNumber));

        JOptionPane.showMessageDialog(null, order.toString());
    }

    private static boolean login(WebStore store) {
        String username = (String) JOptionPane.showInputDialog(null, "Ingrese su email");
        String password = (String) JOptionPane.showInputDialog(null, "Ingrese su contraseña");

        User user = store.login(username, password);

        store.setActiveUser(user);

        return true;
    }

    private static int mainMenu(WebStore store) {
        String[] opciones
                ={"Salir","Mi cuenta","Mis compras","Tienda"};

        int opcion = JOptionPane.showOptionDialog(null,
                "Bienvenido a la tienda online",
                store.getWebStoreName(), JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones,
                null);

        return opcion;
    }

    /*
    private static void manageInventoryMessage(WebStore store)
    {
        boolean flag = true;

        String[] opciones
                ={"Menu principal","Aumentar/reducir stock de Producto","Ver inventario"};

        while(flag){

            int opcion = JOptionPane.showOptionDialog(null,
                    "",
                    store.getWebStoreName(), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones,
                    null);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    changeStockMessage(store);
                    break;
                case 2:
                    viewInventory(store);
                    break;
            }
        }
    }

    private static void viewInventory(WebStore store) {

    }

    private static void changeStockMessage(WebStore store) {
        String name = (String) JOptionPane.showInputDialog(null,
                "Seleccione el producto", store.getWebStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, store.getProducts().toArray(), null);

        Product product = store.findByName(name);

        String stock = (String) JOptionPane.showInputDialog(null,"Edite la cantidad","Editar stock",JOptionPane.QUESTION_MESSAGE, null, null, product.getStock());

        product.setStock(Integer.parseInt(stock));
    }

    private static void manageProductMessage(WebStore store)
    {
        boolean flag = true;

        String[] opciones
                ={"Menu principal","Eliminar Producto","Editar produdcto","Agregar Producto"};

        while(flag){
            int opcion = JOptionPane.showOptionDialog(null,
                    "",
                    store.getWebStoreName(), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones,
                    null);

            switch(opcion){
                case 0:
                    flag = false;
                    break;
                case 1:
                    deleteProductMessage(store);
                    break;
                case 2:
                    editProductMessage(store);
                    break;
                case 3:
                    addProductMessage(store);
                    break;
            }
        }
    }
*/
    /*
    private static void addProductMessage(Store store) {
        String name = (String) JOptionPane.showInputDialog(null,"Ingrese el nombre","Crear Producto",JOptionPane.QUESTION_MESSAGE, null, null, null);
        String price = (String) JOptionPane.showInputDialog(null,"Ingrese el precio","Crear Producto",JOptionPane.QUESTION_MESSAGE, null, null, null);
        String stock = (String) JOptionPane.showInputDialog(null,"Ingrese la cantidad inicial","Crear Producto",JOptionPane.QUESTION_MESSAGE, null, null, null);


        Product product = new Product(name, Double.parseDouble(price),Integer.parseInt(stock));
        store.addProduct(product);
    }

    private static void editProductMessage(Store store) {
        String name = (String) JOptionPane.showInputDialog(null,
                "Seleccione el producto que desea editar", store.getStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, store.getProductNames(), null);

        Product product = store.findByName(name);

        String newName = (String) JOptionPane.showInputDialog(null,"Ingrese el nuevo nombre","Editar Producto",JOptionPane.QUESTION_MESSAGE, null, null, product.getName());
        String newPrice = (String) JOptionPane.showInputDialog(null,"Ingrese el nuevo precio","Editar Producto",JOptionPane.QUESTION_MESSAGE, null, null, product.getPrice());

        product.setName(newName);
        product.setPrice(Double.parseDouble(newPrice));
    }

    private static void deleteProductMessage(Store store)
    {
        String name = (String) JOptionPane.showInputDialog(null,
                "Seleccione el producto", store.getStoreName(),
                JOptionPane.QUESTION_MESSAGE, null, store.getProductNames(), null);

        int r = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de eliminar el producto?",
                "Confirmar eliminación",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);

        Product product = store.findByName(name);
        store.deleteProduct(product);
    }
    */

}