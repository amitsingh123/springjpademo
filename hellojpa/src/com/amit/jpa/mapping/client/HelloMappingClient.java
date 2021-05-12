package com.amit.jpa.mapping.client;

import com.amit.jpa.mapping.entity.Guide;
import com.amit.jpa.mapping.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloMappingClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //usecase  : new guide and new student
//        Guide guide = new Guide("Rocky");
//        Student student = new Student("Jhon",21,guide);
//        em.persist(student);

        //usecase 2 :- find existing guide;
//         Guide guide = em.find(Guide.class,1L);
//         System.out.println("students associated with..guide"+guide.getName() +" are "+guide.getStudents());
        //usecase 3 :- new student with existing guide;
//         Student student = new Student("Mike",22,guide);
//         em.persist(student);

        //usecase 4: bidirectional --- add students from the guide with the helper method
//            Student student = em.find(Student.class,1L);
//            Guide guide = new Guide("Jonson");
//            guide.addStudent(student);
//            em.persist(guide);
        //usecase 5:- update the detached object and save to database;
//            Guide guide = em.find(Guide.class,3L);
//            Student student1 = new Student("Dixy",22,guide);
//            em.persist(student1);
//            tx.commit();
//            em.close();
//            student1.setName("Minny");
//
//            EntityManager em1 = emf.createEntityManager();
//            EntityTransaction tx1 = em1.getTransaction();
//            tx1.begin();
//            em1.persist(student1);
//            tx1.commit();
//            em1.close();

        // Exception is thrown if we use persist method
        // Exception in thread "main" javax.persistence.PersistenceException: org.hibernate.PersistentObjectException:
        // detached entity passed to persist: com.amit.jpa.mapping.entity.Student

        //Soln: use merge method instead of persist
//        Student student1 = em.find(Student.class,3L);
//        student1.setName("Minny");
//        em.persist(student1);
//        tx.commit();
//        em.close();
//        student1.setName("Sundar");
//
//        EntityManager em1 = emf.createEntityManager();
//        EntityTransaction tx1 = em1.getTransaction();
//        tx1.begin();
//        em1.merge(student1);
//        tx1.commit();
//        em1.close();

        //usecase 6:- add new students after calling the merge method but before commit
        // it was able to add the new student with new guide even after the merge method call was over
        Guide guide = new Guide("Marley");
        em.persist(guide);
        tx.commit();
        em.close();

        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();
        Guide mergedGuide = em1.merge(guide);
        mergedGuide.addStudent(new Student("kite",22));
        mergedGuide.addStudent(new Student("Penny",25));
        tx1.commit();
        em1.close();
    }
}
