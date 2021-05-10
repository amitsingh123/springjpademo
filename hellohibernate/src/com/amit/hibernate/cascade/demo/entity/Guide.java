package com.amit.hibernate.cascade.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String staffId;
    private String name;
    private Integer salary;

    @OneToMany(mappedBy = "guide",cascade = {CascadeType.PERSIST},orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
        student.setGuide(this);
    }

    public Guide(){};

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
