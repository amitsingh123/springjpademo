package com.amit.hibernate.cascade.demo.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Long id;
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Customer customer;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Passport(){};

    public Customer getCustomer() {
        return customer;
    }
}
