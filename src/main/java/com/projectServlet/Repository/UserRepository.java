package com.projectServlet.Repository;


import com.projectServlet.model.User;
import jakarta.persistence.Id;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {
    private Session session=null;

    public UserRepository(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    public boolean createUser(User user){
        try {
            session.getTransaction().begin();
            session.persist(user);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public boolean updateUser(User user){
        try {
            session.getTransaction().begin();
            session.merge(user);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteUser(Long id){
        try {
            session.getTransaction().begin();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    public User findUserById(Long id){
        try {
            return session.get(User.class,id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public List<User> findAllUser(){
        Query<User> query = session.createNativeQuery("select * from user");
        return query.getResultList();
    }
}
