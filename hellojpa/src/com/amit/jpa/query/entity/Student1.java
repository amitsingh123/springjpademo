package com.amit.jpa.query.entity;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private int age;
    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinColumn
    private Guide1 guide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guide1 getGuide() {
        return guide;
    }

    public void setGuide(Guide1 guide) {
        this.guide = guide;
    }

    public Student1(){};
    public Student1(String name, int age, Guide1 guide){
        this.name = name;
        this.age = age;
        this.guide = guide;
    }

    public Student1(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
