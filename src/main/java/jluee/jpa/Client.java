package jluee.jpa;

import jluee.jpa.student.Address;
import jluee.jpa.student.Student;

import javax.persistence.*;

public class Client {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("simpleJPA", null);
        EntityManager manager = factory.createEntityManager();
        try {
//            testsave1(manager);
            createStudent(manager);
//            showAll(manager);
        } finally {
            manager.close();
            factory.close();
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

