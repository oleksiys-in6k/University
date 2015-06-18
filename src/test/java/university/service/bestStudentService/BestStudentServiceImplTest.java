package university.service.bestStudentService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Course;
import university.entity.Faculty;
import university.entity.Mark;
import university.entity.Student;
import university.service.courseService.CourseService;
import university.service.facultyService.FacultyService;
import university.service.markService.MarkService;
import university.service.studentService.StudentService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testUniversity.xml")
@Transactional
@TransactionConfiguration
public class BestStudentServiceImplTest {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarkService markService;

    @Autowired
    private BestStudentService bestStudentService;

    Faculty faculty;
    Course course;
    Student student;
    Mark mark;


    @Before
    public void setUp() throws Exception {
        faculty = new Faculty("Economics");
        facultyService.addFaculty(faculty);
        course = new Course(faculty, "karate");
        courseService.addCourse(course);
        student = new Student("Josh smith", faculty);
        studentService.addStudent(student);
        mark = new Mark(student, course, 10);
        markService.addMark(mark);

    }

    @Test
    public void searchBestStudentFromOneCourse__resultNewStudent() throws Exception {
        //given
        Student student2 = new Student("Bruce Lee ", faculty);
        studentService.addStudent(student2);
        Mark mark2 = new Mark(student2, course, 12);
        markService.addMark(mark2);

        // when
        Student bestStudent = bestStudentService.getBestStudent(faculty);

        // then
        assertThat(bestStudent, is(student2));
    }

    @Test
    public void searchBestStudentFromDifferentCourses__resultNewStudent() throws Exception {
        //given
        Student student2 = new Student("Bruce Lee ", faculty);
        studentService.addStudent(student2);
        Course course2 = new Course(faculty, "Boxing");
        courseService.addCourse(course2);
        Mark mark2 = new Mark(student2, course2, 12);
        markService.addMark(mark2);

        // when
        Student bestStudent = bestStudentService.getBestStudent(faculty);

        // then
        assertThat(bestStudent, is(student2));
    }

    @Test
    public void searchBestStudentFromDifferentFaculties__resultSetUpStudent() throws Exception {
        //given
        Faculty newFaculty = new Faculty("Not Economics");
        facultyService.addFaculty(newFaculty);

        Student newStudent = new Student("Bruce Lee ", faculty);
        studentService.addStudent(newStudent);

        Course newCourse = new Course(newFaculty, "Boxing");
        courseService.addCourse(newCourse);

        Mark newMark = new Mark(newStudent, newCourse, 100);
        markService.addMark(newMark);

        // when
        Student bestStudent = bestStudentService.getBestStudent(faculty);

        // then
        assertThat(bestStudent, is(student));
    }

}