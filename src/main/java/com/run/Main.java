package com.run;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        AddNewMark addNewMark = new AddNewMark();
//        addNewMark.creatingMark();

        boolean again = false;
        do {
            System.out.println("Chose action");
            System.out.println("\t1 - set new mark");
            System.out.println("\t2 - get best student by faculty");
            int choose = Integer.valueOf(keyboard(""));

            switch (choose) {
                case 1 :
                    addNewMark.creatingMark();
                    break;
                case 2 :
                    FindBestStudent findBestStudent = new FindBestStudent();
                    System.out.println(findBestStudent.getBestStudentByFaculty());
                    break;
            }

            again = continueWorking();

        } while (again);

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

//        System.out.println("students" + studentDao.getAllStudents());
//        System.out.println("courses" + courseDao.getAllCourses());
//        System.out.println("marks" + markDao.getAllMarks());
//        System.out.println("faculties" + facultyDao.getAllFaculties());

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