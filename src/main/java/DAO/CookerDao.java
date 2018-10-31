package DAO;

import ProjPack.Cooker;
import ProjPack.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CookerDao {
    public Cooker findById(Integer id){
        return HibernateUtil.getSessionFactory().openSession().get(Cooker.class,id);
    }

    public void save(Cooker cooker){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(cooker);
        tx1.commit();
        session.close();
    }

    public void update(Cooker cooker){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(cooker);
        tx1.commit();
        session.close();
    }
    public void delete(Cooker cooker){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(cooker);
        tx1.commit();
        session.close();
    }
}
