package com.amit.jpa.query.client;

import com.amit.jpa.mapping.entity.Guide;
import com.amit.jpa.query.entity.Guide1;
import com.amit.jpa.query.entity.Student1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLOutput;

public class LazyClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        Guide1 guide = em.find(Guide1.class,3L);
//        System.out.println("guide info "+guide.getName());
//        for(Student1 student: guide.getStudents()){
//            System.out.println("student "+student.getName());
//        }

        Student1 student = em.find(Student1.class,1L);
        System.out.println("First Student name.."+student.getName());
        Guide1 guide = student.getGuide();
        System.out.println("Guide name.."+guide.getName());
        for(Student1 student1:guide.getStudents()){
            System.out.println("Student name.."+student1.getName());
        }
        tx.commit();
        em.close();
    }
}
