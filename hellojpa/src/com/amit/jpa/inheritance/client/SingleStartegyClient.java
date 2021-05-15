package com.amit.jpa.inheritance.client;

import com.amit.jpa.inheritance.entity.Cat;
import com.amit.jpa.inheritance.entity.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SingleStartegyClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Cat cat = new Cat();
        cat.setName("Milky");

        Dog dog = new Dog();
        dog.setName("Brave");
        em.persist(cat);
        em.persist(dog);

        tx.commit();
        em.close();
    }
}
