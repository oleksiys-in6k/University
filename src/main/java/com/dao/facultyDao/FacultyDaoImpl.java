package com.dao.facultyDao;

import com.entity.Faculty;
import com.entity.Student;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


//@Repository
@Transactional
public class FacultyDaoImpl implements FacultyDao {


    SessionFactory sessionFactory;
//    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addFaculty(Faculty faculty) throws SQLException {
        Session session = getSession();
        session.save(faculty);
    }

    public Faculty getFacultyById(Integer id) throws SQLException {
        Session session = getSession();
        return (Faculty) session.load(Faculty.class, id);
    }

    public List getAllFaculties() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Faculty.class).list();
    }

    public void deleteFaculty(Faculty faculty) throws SQLException {
        Session session = getSession();
        session.delete(faculty);

    }

    public Student getBestStudentByFacultyId(Integer id) throws SQLException {
        Session session = getSession();
        SQLQuery query = session.createSQLQuery(
                "SELECT student.name, sum(Mark.mark)" +
                "FROM student INNER JOIN Mark ON student.studentId = Mark.studentId" +
                "WHERE facultyId = 1" +
                "GROUP BY student.name DESC LIMIT 1;" );

        System.out.println(query.list());



        return null;
    }

//    public Student getBestStudentByFacultyId(Integer id) throws SQLException {
//        Session session = getSession();
//
//        SQLQuery query = session.createSQLQuery(
//                "SELECT *"+
//                "from Mark "+
//                ";");
//
////        "SELECT Mark.studentId, student.name, AVG(Mark.mark)"+
////                "from Mark INNER JOIN student on student.studentId = Mark.studentId"+
////                "GROUP BY Mark.studentId"+
////                "ORDER BY mark DESC LIMIT 1;");
//
//
//
//        System.out.println(query);
//        System.out.println(query.getFirstResult());
//
//        return null;
//    }
}
