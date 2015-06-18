package university.service.courseService;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Course;
import university.entity.Faculty;
import university.service.facultyService.FacultyService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testUniversity.xml")
@Transactional
@TransactionConfiguration
public class CourseServiceImplTest {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CourseService courseService;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testCourseService() throws Exception {
        Faculty faculty = new Faculty("Economics");
        facultyService.addFaculty(faculty);

        Course course = new Course(faculty, "Busyness Strategy");
        courseService.addCourse(course);
        evict(course);

        Course someCourse = courseService.getCourseById(course.getCourseId());

        assertThat(someCourse, is(course));
    }

    private void evict(Object course) {
        sessionFactory.getCurrentSession().evict(course);
    }

    @Test
    public void testDeleteCourseService() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Course course = new Course(faculty, "Busyness Strategy");
        courseService.addCourse(course);

        //when
        courseService.deleteCourse(course);
        Course someCourse = courseService.getCourseById(course.getCourseId());

        //then
        assertThat(someCourse, is(nullValue()));
    }

    @Test
    public void testGetAllCourses__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Course course = new Course(faculty, "Busyness Strategy");
        courseService.addCourse(course);

        //when
        List<Course> courses = courseService.getAllCourses();

        //then
        assertThat(courses, contains(course));
    }

    @Test
    public void testUpdateCourse() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);
        Faculty newFaculty = new Faculty("Fight");
        facultyService.addFaculty(faculty);

        Course course = new Course(faculty, "Busyness Strategy");
        courseService.addCourse(course);

        //when
        String newTitle = "Karate";
        course.setTitle(newTitle);
        course.setFaculty(newFaculty);

        courseService.updateCourse(course);

        //then
        assertThat(course.getTitle(), is(newTitle));
        assertThat(course.getFaculty(), is(newFaculty));
    }
}