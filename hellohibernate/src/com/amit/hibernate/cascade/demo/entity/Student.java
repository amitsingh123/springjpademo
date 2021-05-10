package com.amit.hibernate.cascade.demo.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enrollmentId;
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Guide guide;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

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

    public Student(String enrollmentId, String name, Guide guide) {
        this.enrollmentId = enrollmentId;
        this.name = name;
        this.guide = guide;
    }

    public Student(){};

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", enrollmentId='" + enrollmentId + '\'' +
                ", name='" + name + '\'' +
                ", guide=" + guide +
                '}';
    }
}
