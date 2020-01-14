package com.smoothstack.december.entity;

public class Publisher {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    public Publisher() {
    }

    public Publisher(int id, String name, String address, String phoneNumber) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
