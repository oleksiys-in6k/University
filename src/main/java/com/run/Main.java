package com.run;

import com.entity.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static String input = "1\n1\n1\n";


    public static void main(String[] args) throws SQLException {

        BeanFactory factory = new ClassPathXmlApplicationContext("spring-config.xml");
        ConsoleMarkReader consoleMarkReader = factory.getBean(ConsoleMarkReader.class);

        boolean again;
        do {
            System.out.println("Chose action");
            System.out.println("\t1 - set new mark");
            System.out.println("\t2 - get best student by faculty");
            int choose = Integer.valueOf(keyboard(""));

            switch (choose) {
                case 1:
                    consoleMarkReader.readMark();
                    break;
                case 2:
                    Student student = new FindBestStudent().getBestStudent();
                    System.out.println();
                    System.out.println("Best student are \n" + student);
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
        return scan.next();
    }


}
