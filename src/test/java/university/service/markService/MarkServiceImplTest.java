package university.service.markService;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.entity.*;
import university.service.courseService.CourseService;
import university.service.facultyService.FacultyService;
import university.service.studentService.StudentService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:testUniversity.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class MarkServiceImplTest {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private MarkService markService;

    @Test
//    @Ignore
    public void testAddingMarkService() throws Exception {
        Faculty faculty = new Faculty("Economics");
        facultyService.addFaculty(faculty);

        Student student = new Student("John Smith", faculty);
        studentService.addStudent(student);

        Course course = new Course(faculty, "Busyness Strategy");
        courseService.addCourse(course);

        Mark mark = new Mark(student, course, 2);
        markService.addMark(mark);
        sessionFactory.getCurrentSession().evict(mark);

        Mark storedMark = markService.getMarkById(mark.getMarkId());

        assertThat(storedMark, is(mark));
    }

    @Test
    public void testDeleteMarkService() throws Exception {
        //given
        Faculty faculty = new Faculty("Economics");
        facultyService.addFaculty(faculty);

        Student student = new Student("John Smith", faculty);
        studentService.addStudent(student);

        Course course = new Course(faculty, "Busyness Strategy");
        courseService.addCourse(course);

        Mark mark = new Mark(student, course, 2);
        markService.addMark(mark);

        //when
        markService.deleteMark(mark);
        Mark someMark = markService.getMarkById(mark.getMarkId());

        //then
        assertThat(someMark, is(nullValue()));
    }

    @Test
    public void testGetAllCourses__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economics");
        facultyService.addFaculty(faculty);

        Student student = new Student("John Smith", faculty);
        studentService.addStudent(student);

        Course course = new Course(faculty, "Busyness Strategy");
        courseService.addCourse(course);

        Mark mark = new Mark(student, course, 2);
        markService.addMark(mark);

        //when
        List<Mark> marks = markService.getAllMarks();

        //then
        assertThat(marks, contains(mark));
    }

}