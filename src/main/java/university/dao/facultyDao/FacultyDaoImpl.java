package university.dao.facultyDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Faculty;

import java.util.List;


@Repository("facultyDao")
@Transactional
public class FacultyDaoImpl implements FacultyDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addFaculty(Faculty faculty){
        Session session = getSession();
        session.save(faculty);
    }

    public Faculty getFacultyById(Integer id) {
        Session session = getSession();
        return (Faculty) session.get(Faculty.class, id);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        Session session = getSession();
        session.update(faculty);
    }

    public List getAllFaculties(){
        Session session = getSession();
        return session.createCriteria(Faculty.class).list();
    }

    public void deleteFaculty(Faculty faculty) {
        Session session = getSession();
        session.delete(faculty);
    }

}
