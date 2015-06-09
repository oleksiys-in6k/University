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

    public Student getBestStudent() throws SQLException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        StudentDaoImpl studentDao = beanFactory.getBean(StudentDaoImpl.class);

        Faculty faculty = getFacultyFromList(beanFactory);

        return studentDao.getBestStudent(faculty);
    }

    private Faculty getFacultyFromList(BeanFactory beanFactory) throws SQLException {
        FacultyDaoImpl facultyDao = beanFactory.getBean(FacultyDaoImpl.class);
        System.out.println("List of faculties");
        System.out.println(facultyDao.getAllFaculties());
        Integer facultyId = Integer.valueOf(keyboard("Choose faculty"));
        return facultyDao.getFacultyById(facultyId);
    }

    private String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
