package com.smoothstack.december.entity;

import java.util.HashMap;
import java.util.Map;

public class LibraryBranch {
    private int id;
    private String name;
    private String address;
    private Map<Integer, Book> books;

    public LibraryBranch() {
    }

    public LibraryBranch(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public LibraryBranch(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = new HashMap<Integer, Book>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addBook(Book book) {
    }
}
