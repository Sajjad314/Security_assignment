package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String name, id, address;
    int phnNo;

    public static List<Customer> customers = new ArrayList<>();

    Customer(String id, String name, String address, int phnNo){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phnNo = phnNo;
    }

    private Cart cart = new Cart();

    public List<Product> viewProduct(){
        return Product.products;
    }

    public String addToCart(Product p){
        if(Product.products.contains(p)){
            cart.cartProducts.add(p);
            return "Product added successfully";
        }
        else{
            return "Product is not available right now";
        }
    }

    public String removeFromCart(Product p){
        if(cart.cartProducts.contains(p)){
            cart.cartProducts.remove(p);
            return "Product removed successfully";
        }
        else{
            return "Product doesn't exist on cart";
        }
    }

    public String makePayment(double amount, Payment payment){
        return "Payment Successful";
    }

    public  String buyProduct(Payment payment){
        double amount = cart.totalPrice();
        String p = makePayment(amount,payment);
        if(p.equals("Payment Successful")){
            return "Purchase Successful";

        }
        else{
            return "Purchase unsuccessful";
        }
    }


}

