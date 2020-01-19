package com.smoothstack.december.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @Column(name = "publisherName")
    private String name;

    @Column(name = "publisherAddress")
    private String address;

    @Column(name = "publisherPhone")
    private String phoneNumber;

    @OneToMany(mappedBy = "publishers")
    private Set<Book> books;

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

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

}
