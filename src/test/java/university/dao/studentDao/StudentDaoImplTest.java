package university.dao.studentDao;


import university.dao.courseDao.CourseDaoImpl;
import university.dao.facultyDao.FacultyDaoImpl;
import university.dao.markDao.MarkDaoImpl;
import university.dao.studentDao.StudentDaoImpl;
import university.entity.Course;
import university.entity.Faculty;
import university.entity.Mark;
import university.entity.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testSpring-config.xml")
@Transactional
@TransactionConfiguration
public class StudentDaoImplTest {

    @Autowired
    private FacultyDaoImpl facultyDaoImpl;
    @Autowired
    private StudentDaoImpl studentDaoImpl;
    @Autowired
    private MarkDaoImpl markDaoImpl;
    @Autowired
    private CourseDaoImpl courseDaoImpl;

    @Test
    public void testAddStudentDao() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);

        //when
        Student someStudent = studentDaoImpl.getStudentById(student.getStudentId());

        //then
        assertThat(someStudent, is(student));
    }

    @Test
    public void testDeleteStudentDao() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);

        //when
        studentDaoImpl.deleteStudent(student);
        Student someStudent = studentDaoImpl.getStudentById(student.getStudentId());

        //then
        assertThat(someStudent, is(nullValue()));
    }

    @Test
    public void testGetAllStudents__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);

        //when
        List <Student> students = studentDaoImpl.getAllStudents();

        //then
        assertThat(students, contains(student));
    }

    @Test
    public void testGetCountOfStudents() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);

        //when
        int count = studentDaoImpl.getCountOfStudents();

        //then
        assertThat(count, is(1));
    }

    @Test
    @Ignore
    public void searchForBestStudent__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economics");
        facultyDaoImpl.addFaculty(faculty);
        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);
        Course course = new Course(faculty, "Busyness Strategy");
        courseDaoImpl.addCourse(course);
        Mark mark = new Mark(student, course, 2);
        markDaoImpl.addMark(mark);

        // when
//        Student bestStudent = studentDaoImpl.getBestStudent(faculty);

        // then
//        assertThat(bestStudent, is(student));
    }
}

