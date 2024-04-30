package Util;

import models.Product;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Util {

    //Genera una lista de usuarios base
    public static List<User> generateUserList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("Santi", "santi@gmail.com", "123","Cra 14"));
        userList.add(new User("Mari", "mari@gmail.com", "123","Cra 15"));
        userList.add(new User( "Santi", "jara@gmail.com", "123", "Cra 18"));
        return userList;
    }

    //Genera una lista de productos base
    public static List<Product> generateProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("iPad Air", "Tableta con pantalla Liquid Retina de 10.9 pulgadas", 2200000, 10));
        productList.add(new Product("iPhone SE", "Teléfono inteligente compacto con chip A15 Bionic", 1900000, 8));
        productList.add(new Product("MacBook Air M1", "Laptop ultradelgada con chip M1 y hasta 18 horas de duración de la batería", 4500000, 5));
        productList.add(new Product("Apple Watch SE", "Reloj inteligente con detección de caídas y seguimiento de actividad", 1600000, 12));
        productList.add(new Product("PC Gamer - Ryzen 7 5800X", "Computadora de escritorio para juegos con potente procesador", 7500000, 3));
        productList.add(new Product("Monitor Curvo Samsung 27 pulgadas", "Pantalla curva con resolución QHD y frecuencia de actualización de 144Hz", 2500000, 7));
        productList.add(new Product("Impresora Multifuncional HP", "Impresora, escáner y copiadora con conexión Wi-Fi", 900000, 15));
        productList.add(new Product("Auriculares Inalámbricos Sony WH-1000XM4", "Cancelación de ruido y calidad de sonido superior", 1600000, 10));
        productList.add(new Product("Teclado mecánico Razer BlackWidow V3", "Teclado para juegos con switches Razer Green y retroiluminación RGB", 600000, 6));
        productList.add(new Product("Cámara Mirrorless Sony Alpha a7 III", "Cámara con sensor full-frame de 24.2 MP y grabación de video 4K", 7800000, 4));
        return productList;
    }
}
