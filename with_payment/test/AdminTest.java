package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    static Admin admin1;
    static Product product1,product2,product3;
    static  List<Product> testList;

    @BeforeAll
    public static void setUp(){
        admin1 = new Admin("123", "Admin1");


        product1 = new Product(1, "product1", "group1", "subgroup1", 60.0);
        product2 = new Product(2, "product2", "group2", "subgroup1", 70.0);
        product3 = new Product(3, "product3", "group3", "subgroup1", 63.0);


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
        Assertions.assertEquals(testList,admin1.viewProduct());

    }

    @Test
    void addProduct() {
        Product p = new Product(4, "", "group3", "subgroup1", 55.0);
        Product p2 = new Product(5, "product P", "group3", "subgroup1", 0);
        Product p3 = new Product(6, "product P", "group3", "subgroup1", 55.0);
        Assertions.assertEquals("Name , group or subgroup must contain a value",admin1.addProduct(p));
        Assertions.assertEquals("product must have a valid price",admin1.addProduct(p2));

        admin1.addProduct(p3);
        Assertions.assertEquals("product already exist",admin1.addProduct(p3));

        Product p4 = new Product(7, "product P", "group3", "subgroup1", 55.0);
        Assertions.assertEquals("Successful",admin1.addProduct(p4));
    }

    @Test
    void removeProduct() {
        Product p3 = new Product(6, "product P", "group3", "subgroup1", 55.0);
        admin1.addProduct(p3);
        Assertions.assertEquals("Successfully removed.", admin1.removeProduct(p3));

        Assertions.assertEquals("product doesn't exist" , admin1.removeProduct(p3));
    }

    @Test
    void modifyProduct() {
        admin1.addProduct(product1);
        Product newProduct = new Product(1, "product1 modified", "group1", "subgroup1", 60.0);
        Assertions.assertEquals("product modification Successful!",admin1.modifyProduct(product1,newProduct));
        admin1.removeProduct(newProduct);
        Assertions.assertEquals("product doesn't exist",admin1.modifyProduct(newProduct,product1));
    }

    @Test
    void makeShiment() {
        admin1.addProduct(product1);
        Assertions.assertEquals("Shipment Successful",admin1.makeShiment(product1));

        admin1.removeProduct(product1);
        Assertions.assertEquals("Product isn't available right now", admin1.makeShiment(product1));
    }

    @Test
    void confirmDelivery() {
    }
}