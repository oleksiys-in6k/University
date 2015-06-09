package com.run;

import com.dao.facultyDao.FacultyDaoImpl;
import com.dao.studentDao.StudentDaoImpl;
import com.entity.Faculty;
import com.entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class FindBestStudent {

    private Faculty chooseFacultyFromFist() throws SQLException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        FacultyDaoImpl facultyDaoImpl = beanFactory.getBean(FacultyDaoImpl.class);

        System.out.println("List of faculties");
        System.out.println(facultyDaoImpl.getAllFaculties());

        Integer facultyId = Integer.valueOf(keyboard("Choose faculty"));
        return facultyDaoImpl.getFacultyById(facultyId);
    }

    public Student getBestStudent() throws SQLException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDaoImpl studentDao = beanFactory.getBean(StudentDaoImpl.class);

        Faculty faculty = chooseFacultyFromFist();

        return studentDao.getBestStudent(faculty);
    }

    private String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
