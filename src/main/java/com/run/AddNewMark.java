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

    private Course course;
    private Student student;
    private int mark;

    public void creatingMark() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        boolean flag;

        do {
            course = chooseCourseFromFist();
            student = chooseStudentFromFist();

            mark = getMarFromKeyboard();

            MarkDaoImpl markDaoImpl = beanFactory.getBean(MarkDaoImpl.class);
            markDaoImpl.addMark(new Mark(student, course, mark));

            flag = continueInputMark();

        } while (flag);
    }

    private int getMarFromKeyboard() {
        String reply = keyboard("InputMark: ");
        return Integer.valueOf(reply);
    }

    private Student chooseStudentFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDaoImpl studentDaoImpl = beanFactory.getBean(StudentDaoImpl.class);

        System.out.println("List of students");
        System.out.println("studentId\tfaculty\tname");
        System.out.println(studentDaoImpl.getAllStudents());

        String reply = keyboard("Choose student");
        Integer index = Integer.valueOf(reply);
        return studentDaoImpl.getStudentById(index);
    }


    private Course chooseCourseFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/spring-config.xml");
        CourseDaoImpl courseDaoImpl = beanFactory.getBean(CourseDaoImpl.class);

        System.out.println("List of courses");
        System.out.println("courseId\tfaculty\ttitle");
        System.out.println(courseDaoImpl.getAllCourses());

        String reply = keyboard("Choose course");
        Integer index = Integer.valueOf(reply);
        Course course = courseDaoImpl.getCourseById(index);
        return course;

     }

    private boolean continueInputMark() {
        System.out.println("Create new mark? ");
        System.out.println("1 - yes, 2 - no");
        String index = keyboard("");
        return (index.equals("1"));
        }

    public String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return  scan.next();
    }

}
