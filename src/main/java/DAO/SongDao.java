package DAO;

import ProjPack.Cooker;
import ProjPack.HibernateUtil;
import ProjPack.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by GAMERS on 01.11.2018.
 */
public class SongDao {
    public Song findById(Integer id){
        return HibernateUtil.getSessionFactory().openSession().get(Song.class,id);
    }

    public void save(Song song){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(song);
        tx1.commit();
        session.close();
    }

    public void update(Song song){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.update(song);
        tx1.commit();
        session.close();
    }
    public void delete(Song song){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(song);
        tx1.commit();
        session.close();
    }
}
