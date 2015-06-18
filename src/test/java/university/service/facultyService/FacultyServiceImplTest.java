package university.service.facultyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;
import university.entity.Faculty;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FacultyServiceImplTest extends AbstractServiceTest {

    @Test
    public void deletePage() throws Exception {
        Faculty faculty = new Faculty("new");
        facultyServiceImpl.addFaculty(faculty);

        verify(facultyDao).deleteFaculty(faculty);
    }

    @Test
    public void createNewPage() throws Exception {
        facultyServiceImpl.addFaculty(new Faculty("new"));

        verify(facultyDao).addFaculty(Matchers.any(Faculty.class));
    }
}



