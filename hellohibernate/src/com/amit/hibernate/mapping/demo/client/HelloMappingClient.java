package com.amit.hibernate.mapping.demo.client;

import com.amit.hibernate.mapping.demo.entity.Address;
import com.amit.hibernate.mapping.demo.entity.User;
import com.amit.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HelloMappingClient {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Address address = new Address("kodathi","bangalore","karnataka");
        User user = new User("Amit",address);
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
