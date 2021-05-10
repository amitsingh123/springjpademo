package com.amit.hibernate.mapping.demo.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street",column = @Column(name = "address_street")),
            @AttributeOverride(name = "city",column = @Column(name = "address_city"))
    })
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
