package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    static Admin admin1;
    static Product product1,product2,product3;
    static List<Product> testList;
    static Guest guest;

    @BeforeAll
    public static void setUp(){
        admin1 = new Admin("123", "Admin1");


        product1 = new Product(1, "product1", "group1", "subgroup1", 60.0);
        product2 = new Product(2, "product2", "group2", "subgroup1", 70.0);
        product3 = new Product(3, "product3", "group3", "subgroup1", 63.0);
        guest = new Guest();

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
        Assertions.assertEquals(testList,guest.viewProduct());
    }

    @Test
    void register() {
        Assertions.assertEquals("Name, address and Phone no shouldn't be empty",guest.register("","guest address",456789));
        Assertions.assertEquals("Registration Successful",guest.register("Guest name","guest address",456789));

    }
}