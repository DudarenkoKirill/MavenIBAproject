package DAO;

import ProjPack.HibernateUtil;
import ProjPack.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDao {
    public User findById(Integer id){
        return HibernateUtil.getSessionFactory().openSession().get(User.class,id);
    }

    public void save(User user){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }
    public void delete(User user){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
