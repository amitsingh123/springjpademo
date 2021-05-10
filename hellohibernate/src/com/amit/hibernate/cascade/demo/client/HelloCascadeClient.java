package com.amit.hibernate.cascade.demo.client;

import com.amit.hibernate.cascade.demo.entity.Guide;
import com.amit.hibernate.cascade.demo.entity.Student;
import com.amit.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HelloCascadeClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //Usecase 1
        //Guide guide = new Guide("abc456","Rig",2000);
        //Student student = new Student("stu333","Henery",guide);

        //Guide guide = session.get(Guide.class,3L);
        //Student student = new Student("stu555","Jacky",guide);
        // with out cascade concept ..we need to use multiple save operation
        //session.save(guide);
        //session.save(student);
        // with cascade used..
        //session.persist(student);
        //cascade remove operation if guide is associated with multiple student
        Student student = session.get(Student.class,5L);
        System.out.println("student name "+student.getName());
        //session.delete(student);

        session.getTransaction().commit();
        session.close();
    }
}
