package com.dao.studentDao;


import com.dao.courseDao.CourseDaoImpl;
import com.dao.facultyDao.FacultyDaoImpl;
import com.dao.markDao.MarkDaoImpl;
import com.entity.Course;
import com.entity.Faculty;
import com.entity.Mark;
import com.entity.Student;

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
import static org.hamcrest.Matchers.*;

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
    @Ignore
    public void testGetAllStudents__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);

        //when
        List <Student> students = studentDaoImpl.getAllStudents();

        //then
        assertThat(students.size(), is(1));
    }

    @Test
    public void testGetCountOfStudents() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        Student student = new Student("John Smith", faculty);
        studentDaoImpl.addStudent(student);
        int sizeListOfAllStudent = studentDaoImpl.getAllStudents().size();

        //when
        int count = studentDaoImpl.getCountOfStudents();

        //then
        assertThat(count, is(sizeListOfAllStudent));
    }

    @Test
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
        Student bestStudent = studentDaoImpl.getBestStudent(faculty);

        // then
        assertThat(bestStudent, is(student));
    }
}

