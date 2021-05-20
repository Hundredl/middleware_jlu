package jluee.jpa;

import javax.persistence.*;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("simpleJPA", null);
        EntityManager manager = factory.createEntityManager();
        try {
//            testsave1(manager);
            createStudent(manager);
            showAll(manager);
        } finally {
            manager.close();
            factory.close();
        }
    }

    public static void testsave1(EntityManager manager) {
        Student p = new Student();
        p.setName("jase");
        p.setGender("female");
        p.setMajor("Computer Science");
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(p);
        transaction.commit();
    }

    public static void showAll(EntityManager manager) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Query q = manager.createQuery("select c from Student c");
        List results = q.getResultList();
        transaction.commit();
        for (Object result : results) {
            Student p = (Student) result;
            System.out.print(p.getId() + "\t");
            System.out.print(p.getName() + "\t");
            System.out.println(p.getGender() + "\t");
        }
    }

    public static void createStudent(EntityManager manager) {
        Student p = new Student();
        p.setName("wangwu6");
        p.setGender("male");
        p.setMajor("computer");

        Address ad = new Address();
        ad.setDetail("address2");
        p.setAddress(ad);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(p);
        transaction.commit();
    }
}

