package com.amit.jpa.query.client;

import com.amit.jpa.query.entity.Guide1;

import javax.persistence.*;

public class JPQLClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        int guideNumber = em.createQuery("select guide from Guide1 guide").getResultList().size();
//        System.out.println("Number of Guides..."+guideNumber);

        // better approach
//        Query query = em.createQuery("select count(guide) from Guide1 guide");
//        Long numberOfGuide = (Long) query.getSingleResult();
//        System.out.println("numberOfGuide "+numberOfGuide);

        //named parameter
        Query query = em.createQuery("select guide from Guide1 guide where guide.name =:name");
        query.setParameter("name","Jonson");
        Guide1 guide = (Guide1) query.getSingleResult();
        System.out.println("guide details.."+guide.toString());

        tx.commit();
        em.close();
    }
}
