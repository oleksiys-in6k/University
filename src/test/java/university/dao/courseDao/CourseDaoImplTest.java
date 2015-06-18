package university.dao.courseDao;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.dao.facultyDao.FacultyDao;
import university.entity.Course;
import university.entity.Faculty;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testUniversity.xml")
@Transactional
@TransactionConfiguration
public class CourseDaoImplTest {

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testCourseDao() throws Exception {
        Faculty faculty = new Faculty("Economics");
        facultyDao.addFaculty(faculty);

        Course course = new Course(faculty, "Busyness Strategy");
        courseDao.addCourse(course);
        evict(course);

        Course someCourse = courseDao.getCourseById(course.getCourseId());

        assertThat(someCourse, is(course));
    }

    private void evict(Object course) {
        sessionFactory.getCurrentSession().evict(course);
    }
}