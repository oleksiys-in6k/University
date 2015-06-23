package university.dao.userDao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.User;

import java.util.List;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addUser(User user) {
        Session session = getSession();
        session.save(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = getSession();
        session.delete(user);
    }

    @Override
    public List getAllUsers() {
        Session session = getSession();
        return session.createCriteria(User.class).list();
    }

    @Override
    public User findUserByName(String login) {
        Session session = getSession();

        SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE login=:userName");
        query.setParameter("userName", login);

        User user = (User) query.addEntity(User.class).uniqueResult();

//        String s = (String) query.uniqueResult();

//        User student = null;

        return user;
    }
}
