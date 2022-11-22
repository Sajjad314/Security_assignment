package org.example;

import java.util.List;

public class Guest {

    public List<Product> viewProduct(){
        return Product.products;
    }

    public String register(String name, String address, int phnNo){
        if(name == "" || address == "" || phnNo == 0){
            return "Name, address and Phone no shouldn't be empty";
        }
        else{
            String id = Integer.toString( Customer.customers.size()+1);
            Customer newCustomer = new Customer(id, name, address, phnNo);
            Customer.customers.add(newCustomer);
            return "Registration Successful";
        }
    }
}

