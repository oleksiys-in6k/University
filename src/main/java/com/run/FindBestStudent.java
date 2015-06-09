package com.run;

import com.dao.facultyDao.FacultyDaoImpl;
import com.dao.markDao.MarkDaoImpl;
import com.dao.studentDao.StudentDaoImpl;
import com.entity.Student;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class FindBestStudent {

    private int chooseFacultyFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        FacultyDaoImpl facultyDaoImpl = beanFactory.getBean(FacultyDaoImpl.class);

        System.out.println("List of faculties");
        System.out.println("facultyId\ttitle");
        System.out.println(facultyDaoImpl.getAllFaculties());

        String reply = keyboard("Choose faculty");
        return Integer.valueOf(reply);
    }

    public Student getBestStudentByFaculty() throws SQLException {
        int facultyId = chooseFacultyFromFist();

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDaoImpl studentDao = beanFactory.getBean(StudentDaoImpl.class);

        Integer studentId = studentDao.getBestStudentFromFaculty(facultyId);

        Student student = studentDao.getStudentById(studentId);

        Hibernate.initialize(student);

        return student;
    }
    public Student getBestStudentByFaculty(Integer studentId) throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDaoImpl studentDao = beanFactory.getBean(StudentDaoImpl.class);
        Student student = studentDao.getStudentById(studentId);
        return student;
    }

//    public void printBestStudent (Student student) {
//        System.out.println("Id" + student.getStudentId());
//        System.out.println("name - " + student.getName());
//        System.out.println("faculty" + student.getFaculty());
//    }



    private String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return  scan.next();
    }

}
