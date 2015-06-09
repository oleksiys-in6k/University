package com.run;


import com.dao.studentDao.StudentDaoImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
//        StudentDaoImpl studentDao = beanFactory.getBean(StudentDaoImpl.class);
//        System.out.println(studentDao.getBestStudentFromFaculty(1));

        boolean again = false;
        do {
            System.out.println("Chose action");
            System.out.println("\t1 - set new mark");
            System.out.println("\t2 - get best student by faculty");
            int choose = Integer.valueOf(keyboard(""));

            switch (choose) {
                case 1 :
                    AddNewMark addNewMark = new AddNewMark();
                    addNewMark.creatingMark();
                    break;
                case 2 :
                    FindBestStudent findBestStudent = new FindBestStudent();
                    System.out.println(findBestStudent.getBestStudentByFaculty());
                    break;
            }

            again = continueWorking();

        } while (again);
    }

    private static boolean continueWorking() {
        System.out.println("Continue working with program? ");
        System.out.println("1 - yes, 2 - no");
        String index = keyboard("");
        return (index.equals("1"));
    }

    public static String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return  scan.next();
    }




}
