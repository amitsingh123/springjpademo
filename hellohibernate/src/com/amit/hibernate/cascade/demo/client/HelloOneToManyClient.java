package com.amit.hibernate.cascade.demo.client;

import com.amit.hibernate.cascade.demo.entity.Guide;
import com.amit.hibernate.cascade.demo.entity.Student;
import com.amit.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HelloOneToManyClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //Usecase 1
        //Guide guide = new Guide("abc552","Ginny",2000);
        //Student student = new Student("stu442","Obama",guide);

        //Guide guide = session.get(Guide.class,5L);
        //Student student = new Student("abc553","Jordan",guide);
        // with cascade used..
        //session.persist(student);
        //cascade remove operation if guide is associated with multiple student
        //Student student = session.get(Student.class,5L);
        //System.out.println("student name "+student.getName());
        //System.out.println("student name "+student.getName());
        //session.delete(student);

        //try to update the student from guide
        //Guide guide = session.get(Guide.class,5L);
        //System.out.println("guide name.."+guide.getName());
        //Student student = session.get(Student.class,6L);
        //System.out.println("student name "+student.getName());

        // it did not worked , not able to update the student entry in db
        //guide.getStudents().add(student);

        // soln:- added a helper method in Guide entity to add the student
        //guide.addStudent(student);
        //session.persist(guide);

        //removal of orphanage records
        Student student = session.get(Student.class,6L);
        System.out.println("student name "+student.getName());
        session.delete(student);

        session.getTransaction().commit();
        session.close();
    }
}
