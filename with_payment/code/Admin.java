package org.example;
import java.util.List;

public class Admin {


    public String id,  name;

    Admin(String id, String name){
        this.id = id;
        this.name = name;
    }

    public List<Product> viewProduct(){
        return Product.products;
    }

    public String addProduct(Product product){
        if(product.id==0 || product.name == "" || product.group == "" || product.subgroup == "")
            return "Name , group or subgroup must contain a value";
        if(product.price <= 0)
            return "product must have a valid price";

        if(Product.products.contains(product))
            return "product already exist";

        Product.products.add(product);
        return "Successful";
    }

    public String removeProduct (Product product) {

        if(Product.products.contains(product)){
            Product.products.remove(product);
            return "Successfully removed.";
        }else{
            return "product doesn't exist";
        }
    }

    public String modifyProduct(Product oldProduct, Product newProduct){
        if(Product.products.contains(oldProduct))
        {
            Product.products.remove(oldProduct);
            Product.products.add(newProduct);
            return "product modification Successful!";
        }
        else{
            return "product doesn't exist";
        }
    }

    public  String makeShiment(Product product){
        if(Product.products.contains(product))
            return "Shipment Successful";
        else{
            return "Product isn't available right now";
        }
    }

    public String confirmDelivery (){
        //delivery logic;
        return null;
    }

}

