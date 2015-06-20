package university.service.bestStudentService;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.dao.bestStudentDao.BestStudentDao;
import university.entity.Faculty;
import university.entity.Student;

@Service
@Transactional
public class BestStudentServiceImpl implements BestStudentService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    BestStudentDao bestStudentDao;

    @Override
    public Student getBestStudent(Faculty faculty) {
        return bestStudentDao.getBestStudent(faculty);
    }
}
