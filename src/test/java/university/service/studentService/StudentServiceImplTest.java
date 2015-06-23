package university.service.studentService;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Faculty;
import university.entity.Student;
import university.service.facultyService.FacultyService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:testUniversity.xml"})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@Transactional
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testAddStudentService() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Student student = new Student("John Smith", faculty, "pas1", "pas1");
        studentService.addStudent(student);

        System.out.println("student" + student);
        System.out.println("faculty" + faculty);

        //when
        Student someStudent = studentService.getStudentById(student.getStudentId());

        System.out.println("someStudent" + someStudent);

        //then
        assertThat(someStudent, is(student));

    }

    @Test
    public void testDeleteStudentService() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Student student = new Student("John Smith", faculty, "pas1", "pas1");
        studentService.addStudent(student);

        //when
        studentService.deleteStudent(student);
        Student someStudent = studentService.getStudentById(student.getStudentId());

        //then
        assertThat(someStudent, is(nullValue()));
    }

    @Test
    public void testGetAllStudents__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Student student = new Student("John Smith", faculty, "pas1", "pas1");

        studentService.addStudent(student);
        System.out.println(student);
        System.out.println(faculty);

        //when
        List<Student> students = studentService.getAllStudents();

        System.out.println(studentService.getAllStudents());

        //then
        assertThat(students, contains(student));
    }

    @Test
    public void testGetCountOfStudents() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Student student = new Student("John Smith", faculty, "pas1", "pas1");
        studentService.addStudent(student);

        //when
        int count = studentService.getCountOfStudents();

        //then
        assertThat(count, is(1));
    }
    @Test
    public void testUpdateStudent() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Faculty newFaculty = new Faculty("Fight");
        facultyService.addFaculty(newFaculty);
        Student student = new Student("John Smith", faculty, "pas1", "pas1");
        studentService.addStudent(student);

        //when
        String newName = "Bruce Lee";
        student.setName(newName);
        student.setFaculty(newFaculty);

        studentService.updateStudent(student);

        //then
        assertThat(student.getName(), is(newName));
        assertThat(student.getFaculty(), is(newFaculty));
    }

}