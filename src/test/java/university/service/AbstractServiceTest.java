package university.service;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.service.courseService.CourseServiceImpl;
import university.service.facultyService.FacultyServiceImpl;
import university.service.markService.MarkServiceImpl;
import university.service.studentService.StudentServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testUniversity.xml")
@Transactional
@TransactionConfiguration
public abstract class AbstractServiceTest {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    public FacultyServiceImpl facultyServiceImpl;
    @Autowired
    public StudentServiceImpl studentServiceImpl;
    @Autowired
    public CourseServiceImpl courseServiceImpl;
    @Autowired
    public MarkServiceImpl markServiceImpl;


    public void evict(Object object) {
        sessionFactory.getCurrentSession().evict(object);
    }

}
