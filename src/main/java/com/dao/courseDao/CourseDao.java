package com.dao.courseDao;

import com.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


//@Repository
@Transactional
public class CourseDao implements ICourseDao {

    SessionFactory sessionFactory;
//    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCourse(Course course) throws SQLException {
        Session session = getSession();
        session.save(course);
    }

    public Course getCourseById(Integer id) throws SQLException {
        Session session = getSession();
        return (Course) session.load(Course.class, id);
    }

    public List getAllCourses() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Course.class).list() ;
    }

    public void deleteCourse(Course course) throws SQLException {
        Session session = getSession();
        session.delete(course);
    }
}
