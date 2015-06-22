package university.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import university.dao.courseDao.CourseDao;
import university.dao.facultyDao.FacultyDao;
import university.dao.markDao.MarkDao;
import university.dao.studentDao.StudentDao;
import university.entity.Course;
import university.entity.Faculty;
import university.entity.Student;
import university.entity.UserRole;

import java.util.HashSet;
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
        FacultyDao facultyDao = beanFactory.getBean(FacultyDao.class);
        StudentDao studentDao = beanFactory.getBean(StudentDao.class);
        CourseDao courseDao = beanFactory.getBean(CourseDao.class);
        MarkDao markDao = beanFactory.getBean(MarkDao.class);


        System.out.println(studentDao.getAllStudents());

    }
}
