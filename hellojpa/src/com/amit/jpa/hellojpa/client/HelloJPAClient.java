package com.amit.jpa.hellojpa.client;

import com.amit.jpa.hellojpa.entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloJPAClient {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Message message = new Message("hello jpa 1");
            entityManager.persist(message);
            tx.commit();
        }catch (Exception ex){
            if(tx != null) tx.rollback();
            ex.printStackTrace();
        }
        finally {
            if(entityManager != null)
            entityManager.close();
        }

    }
}
