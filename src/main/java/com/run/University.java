package com.run;

import com.MarkIO.reader.MarkReader;
import com.MarkIO.writer.MarkWriter;
import com.entity.Mark;
import com.entity.Student;
import com.searchingRequests.FindBestStudent;

import java.sql.SQLException;
import java.util.Scanner;

public class University {

    MarkReader markReader;
    MarkWriter markWriter;

    public void execute() throws SQLException {

        boolean again;
        do {
            System.out.println("Chose action");
            System.out.println("\t1 - set new mark");
            System.out.println("\t2 - get best student by faculty");
            int choose = Integer.valueOf(keyboard(""));

            switch (choose) {
                case 1:
                    Mark mark = markReader.getMark();
                    markWriter.saveMark(mark);
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

    public void setMarkReader(MarkReader markReader) {
        this.markReader = markReader;
    }

    public void setMarkWriter(MarkWriter markWriter) {
        this.markWriter = markWriter;
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




