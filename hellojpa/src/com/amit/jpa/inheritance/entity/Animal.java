package com.amit.jpa.inheritance.entity;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // for table per class inheritance startegy
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private String name;
    public abstract String makeNoise();

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "making noise "+ makeNoise();
    }
}
