package university.dao.studentDao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.dao.facultyDao.FacultyDao;
import university.entity.Faculty;
import university.entity.Student;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:testUniversity.xml"})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@Transactional
public class StudentDaoImplTest {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private FacultyDao facultyDao;

    @Test
    public void testAddStudentDao() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyDao.addFaculty(faculty);
        Student student = new Student("John Smith", faculty);
        studentDao.addStudent(student);

        System.out.println("student" + student);
        System.out.println("faculty" + faculty);

        //when
        Student someStudent = studentDao.getStudentById(student.getStudentId());

        System.out.println("someStudent" + someStudent);

        //then
        assertThat(someStudent, is(student));

    }

    @Test
    public void testDeleteStudentDao() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyDao.addFaculty(faculty);
        Student student = new Student("John Smith", faculty);
        studentDao.addStudent(student);

        //when
        studentDao.deleteStudent(student);
        Student someStudent = studentDao.getStudentById(student.getStudentId());

        //then
        assertThat(someStudent, is(nullValue()));
    }

    @Test
    public void testGetAllStudents__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyDao.addFaculty(faculty);
        Student student = new Student("John Smith", faculty);

        studentDao.addStudent(student);
        System.out.println(student);
        System.out.println(faculty);

        //when
        List <Student> students = studentDao.getAllStudents();

        System.out.println(studentDao.getAllStudents());

        //then
        assertThat(students, contains(student));
    }

    @Test
    public void testGetCountOfStudents() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyDao.addFaculty(faculty);
        Student student = new Student("John Smith", faculty);
        studentDao.addStudent(student);

        //when
        int count = studentDao.getCountOfStudents();

        //then
        assertThat(count, is(1));
    }
}

