package com.amit.jpa.mapping.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "guide",cascade = {CascadeType.PERSIST})
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student){
        students.add(student);
        student.setGuide(this);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public Guide(){};
    public Guide(String name){
        this.name = name;
    }
}
