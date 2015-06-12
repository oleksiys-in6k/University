package university.dao.courseDao;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.dao.facultyDao.FacultyDaoImpl;
import university.entity.Course;
import university.entity.Faculty;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testSpring-config.xml")
@Transactional
@TransactionConfiguration
public class CourseDaoImplTest {

    @Autowired
    private FacultyDaoImpl facultyDaoImpl;

    @Autowired
    private CourseDaoImpl courseDaoImpl;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testCourseDao() throws Exception {
        Faculty faculty = new Faculty("Economics");
        facultyDaoImpl.addFaculty(faculty);

        Course course = new Course(faculty, "Busyness Strategy");
        courseDaoImpl.addCourse(course);
        evict(course);

        Course someCourse = courseDaoImpl.getCourseById(course.getCourseId());

        assertThat(someCourse, is(course));
    }

    private void evict(Object course) {
        sessionFactory.getCurrentSession().evict(course);
    }
}