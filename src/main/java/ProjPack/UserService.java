package ProjPack;

import DAO.UserDao;
import org.hibernate.SessionFactory;

public class UserService {
    private UserDao userDao=new UserDao();
    public User findUser(Integer id){return  userDao.findById(id);}
}
