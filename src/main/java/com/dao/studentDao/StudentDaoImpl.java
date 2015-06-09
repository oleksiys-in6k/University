package com.dao.studentDao;

import com.entity.Student;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

//@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {


    SessionFactory sessionFactory;

    @Autowired
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

    public Integer getBestStudentFromFaculty(Integer id) throws SQLException {
        Session session = getSession();

        SQLQuery query = session.createSQLQuery(
                "SELECT student.name, sum(Mark.mark) " +
                        "FROM student INNER JOIN Mark ON student.studentId = Mark.studentId " +
                        "WHERE facultyId = 1 " +
                        "GROUP BY student.name DESC LIMIT 1;");

        System.out.println(query.list());
        Object obj[] = (Object[]) query.list().get(0);

        BigDecimal rez = (BigDecimal) obj[1];
        Integer studentId = rez.intValue();
//        Hibernate.initialize();

//        return (Student) session.load(Student.class, i);
        return studentId;
    }

}
