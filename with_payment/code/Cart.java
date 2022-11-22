package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {


    int id ;
    public List<Product> cartProducts;

    public Cart(){
        id = (int) ((Math.random() * (99999 - 10000)) + 10000);
        cartProducts = new ArrayList<>();
    }

    public int totalProduct(){
        return cartProducts.size();
    }

    public double totalPrice(){
        double t_price = 0.0;
        for(Product p : cartProducts){
            t_price += p.price;
        }
        return t_price;
    }

}
