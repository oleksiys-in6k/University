package com.dao.markDao;

import com.dao.courseDao.CourseDao;
import com.dao.facultyDao.FacultyDao;
import com.dao.studentDao.StudentDao;
import com.entity.Course;
import com.entity.Faculty;
import com.entity.Mark;
import com.entity.Student;
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
public class MarkDaoTest {

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private MarkDao markDao;

    @Test
    public void testMarkDao() throws Exception {
        Faculty faculty = new Faculty("Economics");
        facultyDao.addFaculty(faculty);

        Student student = new Student("John Smith", faculty);
        studentDao.addStudent(student);

        Course course = new Course(faculty, "Busyness Strategy");
        courseDao.addCourse(course);

        Mark mark = new Mark(student, course, 2);
        markDao.addMark(mark);
        markDao.getSession().evict(mark);

        Mark storedMark = markDao.getMarkById(mark.getMarkId());

        assertThat(storedMark.getMark(), is(2));
        assertThat(storedMark.getCourse(), is(course));
        assertThat(storedMark.getStudent(), is(student));
    }
}