package DAO;

import ProjPack.Beer;
import ProjPack.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BeerDao {
    public Beer findById(Integer id){
        return HibernateUtil.getSessionFactory().openSession().get(Beer.class,id);
    }

    public void save(Beer beer){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(beer);
        tx1.commit();
        session.close();
    }

    public void update(Beer beer){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(beer);
        tx1.commit();
        session.close();
    }
    public void delete(Beer beer){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(beer);
        tx1.commit();
        session.close();
    }
}
