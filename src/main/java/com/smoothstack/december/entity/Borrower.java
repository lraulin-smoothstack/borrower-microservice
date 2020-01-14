package com.smoothstack.december.entity;

public class Borrower {
    private int cardNumber;
    private String name;
    private String address;
    private String phoneNumber;

    public Borrower() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Borrower(int cardNumber, String name, String address, String phoneNumber) {
        this.setCardNumber(cardNumber);
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }

}
