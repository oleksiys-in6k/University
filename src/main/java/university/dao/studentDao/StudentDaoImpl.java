package university.dao.studentDao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Student;

import java.util.List;

@Repository("studentDao")
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addStudent(Student student) {
        Session session = getSession();
        session.save(student);
    }

    public Student getStudentById(Integer id) {
        Session session = getSession();
        return (Student) session.get(Student.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
        Session session = getSession();
        return session.createCriteria(Student.class).list();
    }

    public void deleteStudent(Student student) {
        Session session = getSession();
        session.delete(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = getSession();
        session.update(student);
    }

    public Integer getCountOfStudents() {
        Session session = getSession();
        return session.createCriteria(Student.class).list().size();
    }

    @Override
    public Student findStudentByName(String name) {
        Session session = getSession();

        SQLQuery query = session.createSQLQuery("SELECT * from student where name=:name");
        query.setParameter("name", name);

        query.addEntity(Student.class);

        Student student = null;

        try {
            student = (Student) query.uniqueResult();
        } catch (Exception e) {
            e.getMessage();
        }

        return student;
    }
}
