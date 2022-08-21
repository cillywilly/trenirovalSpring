package com.treniroval;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactory {

    public static void main(String[] args) {
        trainingExercise();
    }

    private static void exercise() {

        try (org.hibernate.SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Exercise.class)
                .addAnnotatedClass(Training.class)
                .addAnnotatedClass(Approach.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            Exercise exercise = new Exercise("Grudi");
            session.beginTransaction();
            session.save(exercise);
            session.getTransaction().commit();
        }
    }

    private static void traininig() {
        org.hibernate.SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Exercise.class)
                .addAnnotatedClass(Training.class)
                .addAnnotatedClass(Approach.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            Training training = new Training("Grudi", "1911-11-11 11:11:11", 1);
            session.beginTransaction();
            session.save(training);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void user() {
        org.hibernate.SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Exercise.class)
                .addAnnotatedClass(Training.class)
                .addAnnotatedClass(Approach.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            User user = new User("admin", "admin");
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void trainingExercise() {
        org.hibernate.SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Exercise.class)
                .addAnnotatedClass(Training.class)
                .addAnnotatedClass(Approach.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
// values (1, 1, 1, 3, 12, 40, 0)
            Approach approach = new Approach(3
                    , 1
                    , 1
                    , 12
                    , 40);
            session.beginTransaction();
            session.save(approach);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }


}
