package com.run;

import com.dao.CourseDao.CourseDao;
import com.dao.MarkDao.MarkDao;
import com.dao.StudentDao.StudentDao;
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

            MarkDao markDao = beanFactory.getBean(MarkDao.class);
            markDao.addMark(new Mark(student, course, mark));

            flag = continueInputMark();

        } while (flag);
    }

    private int getMarFromKeyboard() {
        String reply = keyboard("InputMark: ");
        return Integer.valueOf(reply);
    }

    private Student chooseStudentFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDao studentDao = beanFactory.getBean(StudentDao.class);

        System.out.println("List of students");
        System.out.println("studentId\tfaculty\tname");
        System.out.println(studentDao.getAllStudents());

        String reply = keyboard("Choose student");
        Integer index = Integer.valueOf(reply);
        return studentDao.getStudentById(index);
    }


    private Course chooseCourseFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        CourseDao courseDao = beanFactory.getBean(CourseDao.class);

        System.out.println("List of courses");
        System.out.println("courseId\tfaculty\ttitle");
        System.out.println(courseDao.getAllCourses());

        String reply = keyboard("Choose course");
        Integer index = Integer.valueOf(reply);
        return courseDao.getCourseById(index);

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
