package university.service.facultyService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.dao.courseDao.CourseDao;
import university.dao.facultyDao.FacultyDao;
import university.dao.markDao.MarkDao;
import university.dao.studentDao.StudentDao;
import university.service.courseService.CourseServiceImpl;
import university.service.markService.MarkServiceImpl;
import university.service.studentService.StudentServiceImpl;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testUniversity.xml")
@Transactional
@TransactionConfiguration
public abstract class AbstractServiceTest {

    @Mock
    FacultyDao facultyDao;
    @Mock
    StudentDao studentDao;
    @Mock
    CourseDao courseDao;
    @Mock
    MarkDao markDao;
    @Autowired
    FacultyServiceImpl facultyServiceImpl;
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Autowired
    CourseServiceImpl courseServiceImpl;
    @Autowired
    MarkServiceImpl markServiceImpl;

    @Before
    public void setUp() throws Exception {
        facultyDao = mock(FacultyDao.class);
        studentDao = mock(StudentDao.class);
        courseDao = mock(CourseDao.class);
        markDao = mock(MarkDao.class);
        facultyServiceImpl.setFacultyDao(facultyDao);
        studentServiceImpl.setStudentDao(studentDao);
        courseServiceImpl.setCourseDao(courseDao);
        markServiceImpl.setMarkDao(markDao);
    }

}
