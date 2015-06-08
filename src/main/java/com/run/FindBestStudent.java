package com.run;

import com.dao.facultyDao.FacultyDao;
import com.dao.markDao.MarkDao;
import com.entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class FindBestStudent {

    private int chooseFacultyFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        FacultyDao facultyDao = beanFactory.getBean(FacultyDao.class);

        System.out.println("List of faculties");
        System.out.println("facultyId\ttitle");
        System.out.println(facultyDao.getAllFaculties());

        String reply = keyboard("Choose faculty");
        return Integer.valueOf(reply);
    }

    public Student getBestStudentByFaculty() throws SQLException {
        int facultyId = chooseFacultyFromFist();

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
//        facultyDao facultyDao= beanFactory.getBean(facultyDao.class);
        MarkDao markDao = beanFactory.getBean(MarkDao.class);
        return markDao.getBestStudent();

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
