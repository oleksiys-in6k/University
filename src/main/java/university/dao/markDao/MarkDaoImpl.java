package university.dao.markDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Mark;

import java.sql.SQLException;
import java.util.List;

@Repository("markDao")
@Transactional
public class MarkDaoImpl implements MarkDao {

    @Autowired
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addMark(Mark mark) throws SQLException {
        Session session = getSession();
        session.save(mark);
    }

    public Mark getMarkById(Integer id) throws SQLException {
        Session session = getSession();
        return (Mark) session.get(Mark.class, id);
    }

    public List getAllMarks() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Mark.class).list();
    }

    public void deleteMark(Mark mark) throws SQLException {
        Session session = getSession();
        session.delete(mark);
    }

}
