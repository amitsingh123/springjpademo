package com.amit.jpa.mapping.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private int age;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn
    private Guide guide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Student(){};
    public Student(String name,int age,Guide guide){
        this.name = name;
        this.age = age;
        this.guide = guide;
    }

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", guide=" + guide +
                '}';
    }
}
