package university.run;

import org.springframework.beans.factory.annotation.Autowired;
import university.MarkIO.reader.MarkReader;
import university.MarkIO.writer.MarkWriter;
import university.entity.Mark;
import university.entity.Student;
import university.searchingRequests.SearchBestStudent;

import java.sql.SQLException;
import java.util.Scanner;

public class University {

    @Autowired
    MarkReader markReader;

    @Autowired
    MarkWriter markWriter;

    SearchBestStudent searchBestStudent;

    public void execute() {

        boolean again;
        do {
            System.out.println("Chose action");
            System.out.println("\t1 - set new mark");
            System.out.println("\t2 - get best student by Faculty");
            int choose = Integer.valueOf(keyboard(""));

            switch (choose) {
                case 1:
                    Mark mark = markReader.getMark();
                    markWriter.saveMark(mark);
                    break;
                case 2:
                    Student best = searchBestStudent.getBestStudent();
                    System.out.println();
                    System.out.println("Best student are \n" + best);
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

    private static String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public void setMarkReader(MarkReader markReader) {
        this.markReader = markReader;
    }

    public void setMarkWriter(MarkWriter markWriter) {
        this.markWriter = markWriter;
    }

    public void setSearchBestStudent(SearchBestStudent searchBestStudent) {
        this.searchBestStudent = searchBestStudent;
    }
}
