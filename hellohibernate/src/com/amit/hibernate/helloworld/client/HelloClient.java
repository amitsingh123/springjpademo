package com.amit.hibernate.helloworld.client;

import com.amit.hibernate.helloworld.entity.Message;
import com.amit.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HelloClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //saveOperation(session);
        //getOperation(session,20l);
        //updateOperation(session);
        //deleteOperation(session,21L);
        mergeOperation();
        session.getTransaction().commit();
        session.close();
    }

    public static void saveOperation(Session session){
        Message message = new Message("Hello with Hibernate and JPA with Annotation,r1");
        session.save(message);
    }

    public static void getOperation(Session session,Long id){
      Message message = session.get(Message.class,id);
        System.out.println("message :- "+message.getText());
    }

    public static void updateOperation(Session session){
         Message message = session.get(Message.class,20L);
         message.setText("Hello with Hibernate and JPA with Annotation,r2");
         session.update(message);
    }

    public static void deleteOperation(Session session, Long id){
        Message message = session.get(Message.class,id);
        session.delete(message);
    }

    public static void mergeOperation(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Message message = session.get(Message.class,20l);
        session.getTransaction().commit();
        session.close();
        message.setText("Testing for merge9");
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        Message message1 = session.get(Message.class,20l);
        //Exception in thread "main" org.hibernate.NonUniqueObjectException: A different object with the same
        // identifier value was already associated with the session
        //session1.update(message);

        // Since a message object with same id is persist in the same session so trying to add a new message object with
        // same id will not allow. to update the message content we can use merge method which will copy the content from the
        // non managed object to managed object

        session1.merge(message);
        session1.getTransaction().commit();
        session1.close();
    }
}
