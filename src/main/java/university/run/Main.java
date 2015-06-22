package university.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import university.dao.courseDao.CourseDao;
import university.dao.facultyDao.FacultyDao;
import university.dao.markDao.MarkDao;
import university.dao.studentDao.StudentDao;
import university.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
//    static String input = "1\n1\n1\n";

    public static void main(String[] args) {

//        BeanFactory factory = new ClassPathXmlApplicationContext("university.xml");
//        University universityClass = factory.getBean(University.class);
//        universityClass.execute();

        new Main().asd();
    }

    private void asd() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("university.xml");
        StudentDao studentDao = beanFactory.getBean(StudentDao.class);
        FacultyDao facultyDao = beanFactory.getBean(FacultyDao.class);

        Faculty faculty = new Faculty("Technical");
        facultyDao.addFaculty(faculty);

        Student student = new Student("josh", faculty);
        student.setPassword("josh");
        student.setEnabled(true);

        UserRole userRoleAdmin = new UserRole("ADMIN_ROLE");
        UserRole userRoleUser = new UserRole("USER_ROLE");

        List <UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRoleAdmin);
        userRoles.add(userRoleUser);

        student.setUserRoles(userRoles);
        studentDao.addStudent(student);



        System.out.println(studentDao.getAllStudents());

    }
}
