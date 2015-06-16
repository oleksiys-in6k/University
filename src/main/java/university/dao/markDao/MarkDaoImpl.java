package university.dao.markDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Mark;

import java.util.List;

@Repository("markDao")
@Transactional
public class MarkDaoImpl implements MarkDao {

    @Autowired
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addMark(Mark mark) {
        Session session = getSession();
        session.save(mark);
    }

    public Mark getMarkById(Integer id) {
        Session session = getSession();
        return (Mark) session.get(Mark.class, id);
    }

    public List getAllMarks(){
        Session session = getSession();
        return session.createCriteria(Mark.class).list();
    }

    public void deleteMark(Mark mark) {
        Session session = getSession();


        Mark delMark = (Mark) session.createCriteria(Mark.class)
                .add(Restrictions.idEq(mark.getMarkId()))
                .uniqueResult();


        if (delMark != null)
        {
            session.delete(delMark);
        }
    }

}
