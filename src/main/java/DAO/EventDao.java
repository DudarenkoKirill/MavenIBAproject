package DAO;

import ProjPack.Event;
import ProjPack.HibernateUtil;
import ProjPack.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventDao {
    public Event findById(Integer id){
        return HibernateUtil.getSessionFactory().openSession().get(Event.class,id);
    }

    public void save(Event event){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(event);
        tx1.commit();
        session.close();
    }

    public void update(Event event){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(event);
        tx1.commit();
        session.close();
    }
    public void delete(Event event){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(event);
        tx1.commit();
        session.close();
    }
}
