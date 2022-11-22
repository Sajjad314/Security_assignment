package org.example;

public class Payment {

    String customerId, name , cardType, cardNo;

    public Payment(String customerId, String name, String cardType, String cardNo){
        if(!cardType.equals("Visa") && !cardType.equals("MasterCard") && !cardType.equals("AmericanExpress"))
            throw new IllegalArgumentException();
        this.customerId = customerId;
        this.name = name;
        this.cardType = cardType;
        this.cardNo = cardNo;
    }
}
