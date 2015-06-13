package university.dao.markDao;

import org.junit.Ignore;
import university.dao.courseDao.CourseDaoImpl;
import university.dao.facultyDao.FacultyDaoImpl;
import university.dao.markDao.MarkDaoImpl;
import university.dao.studentDao.StudentDaoImpl;
import university.entity.Course;
import university.entity.Faculty;
import university.entity.Mark;
import university.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testSpring-config.xml")
@Transactional
@TransactionConfiguration
@Ignore
public class MarkDaoImplTest {

    @Autowired
    private FacultyDaoImpl facultyDaoImpl;

    @Autowired
    private StudentDaoImpl studentDaoImpl;

    @Autowired
    private CourseDaoImpl courseDaoImpl;

    @Autowired
    private MarkDaoImpl markDaoImpl;



    @Test
    public void testMarkDao() throws Exception {
        Faculty faculty = new Faculty("Economics");
        facultyDaoImpl.addFaculty(faculty);

        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);

        Course course = new Course(faculty, "Busyness Strategy");
        courseDaoImpl.addCourse(course);

        Mark mark = new Mark(student, course, 2);
        markDaoImpl.addMark(mark);
        markDaoImpl.getSession().evict(mark);

        Mark storedMark = markDaoImpl.getMarkById(mark.getMarkId());

        assertThat(storedMark.getMark(), is(2));
        assertThat(storedMark.getCourse(), is(course));
        assertThat(storedMark.getStudent(), is(student));
    }
}