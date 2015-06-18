package university.dao.markDao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.dao.courseDao.CourseDao;
import university.dao.facultyDao.FacultyDao;
import university.dao.studentDao.StudentDao;
import university.entity.Course;
import university.entity.Faculty;
import university.entity.Mark;
import university.entity.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testUniversity.xml")
@Transactional
@TransactionConfiguration
public class MarkDaoImplTest {

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private MarkDao markDao;

    @Test
//    @Ignore
    public void testAddingMarkDao() throws Exception {
        Faculty faculty = new Faculty("Economics");
        facultyDao.addFaculty(faculty);

        Student student = new Student("John Smith", faculty);
        studentDao.addStudent(student);

        Course course = new Course(faculty, "Busyness Strategy");
        courseDao.addCourse(course);

        Mark mark = new Mark(student, course, 2);
        markDao.addMark(mark);
//        markDao.getSession().evict(mark);

        Mark storedMark = markDao.getMarkById(mark.getMarkId());

        assertThat(storedMark, is(mark));
    }
}
