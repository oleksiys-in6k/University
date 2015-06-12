package university.dao.bestStudentDao;

import org.springframework.stereotype.Repository;
import university.entity.Faculty;
import university.entity.Student;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Repository("bestStudentDao")
@Transactional
public class BestStudentDaoImpl implements BestStudentDao {

    @Autowired
    SessionFactory sessionFactory;

    public Student getBestStudent(Faculty faculty) {
        Session session = getSession();
        SQLQuery query = session.createSQLQuery(
                "SELECT student.studentId, student.name, course.facultyId, sum(Mark.mark) as sumMark " +
                        "FROM student " +
                        "INNER JOIN Mark ON student.studentId = Mark.studentId " +
                        "INNER JOIN course ON course.courseId = Mark.courseId " +
                        "WHERE course.facultyId = :facultyId " +
                        "GROUP BY student.studentId " +
                        "ORDER BY sumMark " +
                        "DESC LIMIT 1;  ");

        query.addEntity(Student.class);

        query.setParameter("facultyId", faculty.getFacultyId());

        return (Student) query.uniqueResult();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
