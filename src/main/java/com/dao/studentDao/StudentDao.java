package com.dao.studentDao;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

//@Repository
@Transactional
public class StudentDao implements IStudentDao {


    SessionFactory sessionFactory;
//    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addStudent(Student student) throws SQLException {
        Session session = getSession();
        session.save(student);
    }

    public Student getStudentById(Integer id) throws SQLException {
        Session session = getSession();
        return (Student) session.load(Student.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Student.class).list();
    }

    public void deleteStudent(Student student) throws SQLException {
        Session session = getSession();
        session.delete(student);
    }

    public Integer getCountOfStudents() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Student.class).list().size();
    }

}
