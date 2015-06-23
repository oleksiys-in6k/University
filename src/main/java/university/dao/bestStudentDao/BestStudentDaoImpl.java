package university.dao.bestStudentDao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Faculty;
import university.entity.Student;
import university.entity.User;

@Repository("bestStudentDao")
@Transactional
public class BestStudentDaoImpl implements BestStudentDao {

    @Autowired
    SessionFactory sessionFactory;

    public Student getBestStudent(Faculty faculty) {
        Session session = getSession();
        SQLQuery query = session.createSQLQuery(
                "SELECT student.studentId, student.name, course.facultyId, sum(Mark.rating) AS sumMark " +
                        "FROM student " +
                        "INNER JOIN Mark ON student.studentId = Mark.studentId " +
                        "INNER JOIN course ON course.courseId = Mark.courseId " +
                        "WHERE course.facultyId = :facultyId " +
                        "GROUP BY student.studentId " +
                        "ORDER BY sumMark " +
                        "DESC LIMIT 1;  ");

        query.addEntity(User.class);

        query.setParameter("facultyId", faculty.getFacultyId());

        Student student = (Student) query.uniqueResult();

//         if (student == null)
//             student = new User(null,null);

        return student;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
