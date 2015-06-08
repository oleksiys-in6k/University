package com.dao.MarkDao;

import com.entity.Mark;
import com.entity.Student;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public class MarkDao implements IMarkDao {

    public SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addMark(Mark mark) throws SQLException {
        Session session = getSession();
        session.save(mark);
    }

    public Mark getMarkById(Long id) throws SQLException {
        Session session = getSession();
        return (Mark) session.load(Mark.class, id);
    }

    public List getAllMarks() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Mark.class).list();
    }

    public void deleteMark(Mark mark) throws SQLException {
        Session session = getSession();
        session.delete(mark);
    }

    public String getBestStudentEver() throws SQLException {
        return null;
    }

    public Student getBestStudent() throws SQLException {
            Session session = getSession();

            SQLQuery query = session.createSQLQuery(
                    "SELECT *"+
                            "from Mark "+
                            ";");

//        "SELECT Mark.studentId, student.name, AVG(Mark.mark)"+
//                "from Mark INNER JOIN student on student.studentId = Mark.studentId"+
//                "GROUP BY Mark.studentId"+
//                "ORDER BY mark DESC LIMIT 1;");



            System.out.println(query);
            System.out.println(query.getFirstResult());

            return null;
        }

}
