package com.amit.hibernate.cascade.demo.entity;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "passport_id",unique = true)
    private Passport passport;

    public Customer(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public Passport getPassport() {
        return passport;
    }

    public Customer(){};
}
