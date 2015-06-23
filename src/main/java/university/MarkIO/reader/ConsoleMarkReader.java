package university.MarkIO.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Course;
import university.entity.Mark;
import university.entity.Student;
import university.service.courseService.CourseService;
import university.service.studentService.StudentService;

import java.util.Scanner;

@Transactional
public class ConsoleMarkReader implements MarkReader {

    private Scanner scanner;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    private int getMarFromKeyboard() {
        String reply = keyboard("InputMark: ");
        return Integer.valueOf(reply);
    }

    private Student chooseStudentFromFist() {
        System.out.println("List of students:");
        System.out.println(studentService.getAllStudents());

        String reply = keyboard("Choose student ");
        Integer index = Integer.valueOf(reply);
        return studentService.getStudentById(index);
    }

    private Course chooseCourseFromFist() {
        System.out.println("List of courses:");
        System.out.println(courseService.getAllCourses());

        String reply = keyboard("Choose course");
        Integer index = Integer.valueOf(reply);
        return courseService.getCourseById(index);
    }

    private String keyboard(String message) {
        System.out.println(message + " ");
        return scanner.next();
    }

    public void setStudentDao(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setCourseDao(CourseService courseService) {
        this.courseService = courseService;
    }

    public ConsoleMarkReader() {
        this.scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public Mark getMark() {
        Course course = chooseCourseFromFist();
        Student student = chooseStudentFromFist();

        int score = getMarFromKeyboard();

        return new Mark(student, course, score);
    }
}
