package com.run;

import com.dao.courseDao.CourseDaoImpl;
import com.dao.markDao.MarkDaoImpl;
import com.dao.studentDao.StudentDaoImpl;
import com.entity.Course;
import com.entity.Mark;
import com.entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class AddNewMark {

    public void creatingMark() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

        Course course = chooseCourseFromFist();
        Student student = chooseStudentFromFist();
        int mark = getMarFromKeyboard();

        Mark newMark = new Mark(student, course, mark);

        MarkDaoImpl markDaoImpl = beanFactory.getBean(MarkDaoImpl.class);
        markDaoImpl.addMark(newMark);
    }

    private int getMarFromKeyboard() {
        String reply = keyboard("InputMark: ");
        return Integer.valueOf(reply);
    }

    private Student chooseStudentFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDaoImpl studentDaoImpl = beanFactory.getBean(StudentDaoImpl.class);

        System.out.println("List of students:");
        System.out.println(studentDaoImpl.getAllStudents());

        String reply = keyboard("Choose student ");
        Integer index = Integer.valueOf(reply);
        return studentDaoImpl.getStudentById(index);
    }

    private Course chooseCourseFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/spring-config.xml");
        CourseDaoImpl courseDaoImpl = beanFactory.getBean(CourseDaoImpl.class);

        System.out.println("List of courses:");
        System.out.println(courseDaoImpl.getAllCourses());

        String reply = keyboard("Choose course");
        Integer index = Integer.valueOf(reply);
        return courseDaoImpl.getCourseById(index);
    }

    public String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
