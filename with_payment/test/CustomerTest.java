package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    static Customer customer1,customer2;
    static Admin admin1;
    static Product product1,product2,product3;
    static Payment payment;
    static List<Product> testList;

    @BeforeAll
    public static void setUp(){
        customer1 = new Customer("124", "customer1", "address1", 789654);
        customer2 = new Customer("123", "customer2", "address2",987456);
        admin1 = new Admin("123", "Admin1");

        product1 = new Product(1, "product1", "group1", "subgroup1", 60.0);
        product2 = new Product(2, "product2", "group2", "subgroup1", 70.0);
        product3 = new Product(3, "product3", "group3", "subgroup1", 63.0);

        payment = new Payment("124", "customer1", "Visa", "123456");
        testList = new ArrayList<>();

    }


    @Test
    void viewProduct() {
        admin1.addProduct(product1);
        admin1.addProduct(product2);
        admin1.addProduct(product3);
        testList.add(product1);
        testList.add(product2);
        testList.add(product3);
        Assertions.assertEquals(testList,customer1.viewProduct());
    }

    @Test
    void addToCart() {
        Assertions.assertEquals("Product added successfully", customer1.addToCart(product1));

        Product p = new Product(5, "p", "pg", "psg", 50.0);
        Assertions.assertEquals("Product is not available right now",customer1.addToCart(p));

    }

    @Test
    void removeFromCart() {
        Product p = new Product(5, "p", "pg", "psg", 50.0);
        admin1.addProduct(p);

        Assertions.assertEquals("Product removed successfully", customer1.removeFromCart(product1));
        Assertions.assertEquals("Product doesn't exist on cart", customer1.removeFromCart(p));

    }

    @Test
    void makePayment() {

    }

    @Test
    void buyProduct() {
        admin1.addProduct(product1);
        admin1.addProduct(product2);
        admin1.addProduct(product3);
        customer1.addToCart(product1);
        customer1.addToCart(product2);
        customer1.addToCart(product3);
        Assertions.assertEquals("Purchase Successful",customer1.buyProduct(payment));
    }
}