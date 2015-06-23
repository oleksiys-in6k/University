package university.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import university.dao.courseDao.CourseDao;
import university.dao.facultyDao.FacultyDao;
import university.dao.studentDao.StudentDao;
import university.dao.teacherDao.TeacherDao;
import university.entity.Faculty;
import university.entity.Student;

//import university.dao.teacherDao.TeacherDao;

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

//        UserRole userRoleUser = new UserRole("USER_ROLE");
//        UserRole userRoleAdmin = new UserRole("ADMIN_ROLE");

        Faculty faculty = new Faculty("Technical");
        facultyDao.addFaculty(faculty);

        Student student = new Student("josh", faculty, "josh", "josh");
        studentDao.addStudent(student);

//        List <UserRole> userRoles = new ArrayList<>();
//        userRoles.add(userRoleAdmin);
//        student.setUserRoles(userRoles);

//        student.setUserRoles(userRoles);
//        studentDao.addStudent(student);
//
//        Course course = new Course(faculty, "Math");
//        courseDao.addCourse(course);
//
//        Teacher teacher = new Teacher("Bruce", faculty);
//        teacherDao.addTeacher(teacher);

        System.out.println(studentDao.getAllStudents());

    }
}
