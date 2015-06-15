package university.dao.facultyDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Faculty;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/testSpring-config.xml")
@Transactional
@TransactionConfiguration
public class FacultyDaoImplTest {

    @Autowired
    private FacultyDao facultyDao;

    @Test
    public void testFacultyDao() throws Exception {
        Faculty faculty = new Faculty("Economical");
        facultyDao.addFaculty(faculty);

        Faculty someFaculty = facultyDao.getFacultyById(faculty.getFacultyId());

        assertThat(someFaculty.getTitle(), is("Economical"));

    }
}