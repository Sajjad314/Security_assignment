package org.example;

import java.util.*;

public class Product {

    public static List<Product> products = new ArrayList<>();

    int id;
    public String name , group , subgroup;
    double price;

    Product(int id, String name, String group, String subgroup, double price){
        this.id = id;
        this.name = name;
        this.group = group;
        this.subgroup = subgroup;
        this.price = price;
    }
}

