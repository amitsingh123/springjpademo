package com.amit.hibernate.cascade.demo.client;

import com.amit.hibernate.cascade.demo.entity.Customer;
import com.amit.hibernate.cascade.demo.entity.Passport;
import com.amit.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HelloOneToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Passport passport = new Passport("us1234");
        Customer customer = new Customer("jack",passport);
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }
}
