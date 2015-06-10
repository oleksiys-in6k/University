package com.run;

import com.dao.courseDao.CourseDao;
import com.dao.courseDao.CourseDaoImpl;
import com.dao.markDao.MarkDao;
import com.dao.markDao.MarkDaoImpl;
import com.dao.studentDao.StudentDao;
import com.dao.studentDao.StudentDaoImpl;
import com.entity.Course;
import com.entity.Mark;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Scanner;


@Repository
@Transactional
public class AddNewMark {

    private Scanner scanner;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private MarkDao markDao;

    public AddNewMark() {
        this.scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void creatingMark() throws SQLException {
        Course course = chooseCourseFromFist();
        Student student = chooseStudentFromFist();
        int mark = getMarFromKeyboard();

        Mark newMark = new Mark(student, course, mark);
        markDao.addMark(newMark);
    }

    private int getMarFromKeyboard() {
        String reply = keyboard("InputMark: ");
        return Integer.valueOf(reply);
    }

    private Student chooseStudentFromFist() throws SQLException {
        System.out.println("List of students:");
        System.out.println(studentDao.getAllStudents());

        String reply = keyboard("Choose student ");
        Integer index = Integer.valueOf(reply);
        return studentDao.getStudentById(index);
    }

    private Course chooseCourseFromFist() throws SQLException {
        System.out.println("List of courses:");
        System.out.println(courseDao.getAllCourses());

        String reply = keyboard("Choose course");
        Integer index = Integer.valueOf(reply);
        return courseDao.getCourseById(index);
    }

    private String keyboard(String message) {
        System.out.println(message + " ");
        return scanner.next();
    }

    public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
        this.studentDao = studentDaoImpl;
    }

    public void setCourseDaoImpl(CourseDaoImpl courseDaoImpl) {
        this.courseDao = courseDaoImpl;
    }

    public void setMarkDaoImpl(MarkDaoImpl markDaoImpl) {
        this.markDao = markDaoImpl;
    }
}
