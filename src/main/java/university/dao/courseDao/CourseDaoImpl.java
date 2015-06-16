package university.dao.courseDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Course;

import java.util.List;

@Repository("courseDao")
@Transactional
public class CourseDaoImpl implements CourseDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCourse(Course course) {
        Session session = getSession();
        session.save(course);
    }

    public Course getCourseById(Integer id) {
        Session session = getSession();
        return (Course) session.get(Course.class, id);
    }

    public List getAllCourses() {
        Session session = getSession();
        return session.createCriteria(Course.class).list();
    }

    public void deleteCourse(Course course) {
        Session session = getSession();
        session.delete(course);
    }

    @Override
    public void updateCourse(Course course) {
        Session session = getSession();
        session.update(course);
    }
}
