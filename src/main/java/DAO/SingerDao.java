package DAO;

import ProjPack.Event;
import ProjPack.HibernateUtil;
import ProjPack.Singer;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by GAMERS on 01.11.2018.
 */
public class SingerDao {
    public Singer findById(Integer id){
        return HibernateUtil.getSessionFactory().openSession().get(Singer.class,id);
    }

    public void save(Singer singer){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(singer);
        tx1.commit();
        session.close();
    }

    public void update(Singer singer){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(singer);
        tx1.commit();
        session.close();
    }
    public void delete(Singer singer){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(singer);
        tx1.commit();
        session.close();
    }
}
