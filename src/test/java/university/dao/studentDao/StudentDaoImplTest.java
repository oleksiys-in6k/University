package university.dao.studentDao;

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
import university.entity.UserRole;
import university.service.facultyService.FacultyService;
import university.service.studentService.StudentService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:testUniversity.xml"})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@Transactional
public class StudentDaoImplTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testFindStudentByName() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);

//        UserRole userRole = new UserRole();


        Student student = new Student("bob", faculty);
        student.setEnabled(true);
        student.setName("bob");
        student.setPassword("bob");
        studentService.addStudent(student);

        System.out.println("student" + student);

        //when
        Student someStudent = studentService.findStudentByName(student.getName());

        System.out.println("someStudent" + someStudent);

        //then
        assertThat(someStudent, is(student));

    }

}