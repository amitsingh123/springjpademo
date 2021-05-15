package com.amit.jpa.query.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Guide")
public class Guide1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "guide",cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Set<Student1> students = new HashSet<>();

    public void addStudent(Student1 student){
        students.add(student);
        student.setGuide(this);
    }

    public Set<Student1> getStudents() {
        return students;
    }

    public void setStudents(Set<Student1> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public Guide1(){};
    public Guide1(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Guide1{" +
                "id=" + id +
                ", name='" + name +
                ", students='" + students+
                '}';
    }
}
