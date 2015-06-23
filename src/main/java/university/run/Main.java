package university.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import university.dao.courseDao.CourseDao;
import university.dao.facultyDao.FacultyDao;
import university.dao.studentDao.StudentDao;
import university.dao.teacherDao.TeacherDao;
import university.entity.*;

import java.util.ArrayList;
import java.util.List;

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
        CourseDao courseDao = beanFactory.getBean(CourseDao.class);
        TeacherDao teacherDao = beanFactory.getBean(TeacherDao.class);



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

        Course course = new Course(faculty, "Math");
        courseDao.addCourse(course);

        Teacher teacher = new Teacher("Bruce", course);
        teacherDao.addTeacher(teacher);



        System.out.println(studentDao.getAllStudents());

    }
}
