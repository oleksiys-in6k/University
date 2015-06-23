package university.dao.teacherDao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Teacher;

import java.util.List;

@Repository("teacherDao")
@Transactional
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addTeacher(Teacher teacher) {
        Session session = getSession();
        session.save(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        Session session = getSession();
        session.save(teacher);
    }

    @Override
    public List getAllTeachers() {
        Session session = getSession();
        return session.createCriteria(Teacher.class).list();
    }

    @Override
    public Teacher findTeacherByName(String name) {
        Session session = getSession();

        SQLQuery query = session.createSQLQuery("SELECT * FROM teacher WHERE name=:userName");
        query.setParameter("userName", name);

        Teacher teacher = (Teacher) query.addEntity(Teacher.class).uniqueResult();

        return teacher;
    }

}
