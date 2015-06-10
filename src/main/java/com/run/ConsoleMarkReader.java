package com.run;

import com.dao.courseDao.CourseDao;
import com.dao.studentDao.StudentDao;
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
public class ConsoleMarkReader {

    private Scanner scanner;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    public ConsoleMarkReader() {
        this.scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Mark readMark() throws SQLException {
        Course course = chooseCourseFromFist();
        Student student = chooseStudentFromFist();
        int score = getMarFromKeyboard();

        return new Mark(student, course, score);
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

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
