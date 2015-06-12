package university.dao.facultyDao;

import university.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


//@Repository
@Transactional
public class FacultyDaoImpl implements FacultyDao {


    SessionFactory sessionFactory;
//    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addFaculty(Faculty faculty) throws SQLException {
        Session session = getSession();
        session.save(faculty);
    }

    public Faculty getFacultyById(Integer id) throws SQLException {
        Session session = getSession();
        return (Faculty) session.get(Faculty.class, id);
    }

    public List getAllFaculties() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Faculty.class).list();
    }

    public void deleteFaculty(Faculty faculty) throws SQLException {
        Session session = getSession();
        session.delete(faculty);

    }

}
