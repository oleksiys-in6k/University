package university.service.facultyService;


import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Faculty;
import university.entity.User;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testUniversity.xml")
@Transactional
@TransactionConfiguration
public class FacultyServiceImplTest {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private FacultyService facultyService;

    @Test
    public void testAddFacultyService() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);

        System.out.println("faculty" + faculty);

        //when
        Faculty someFaculty = facultyService.getFacultyById(faculty.getFacultyId());

        //then
        assertThat(someFaculty, is(faculty));
    }

    @Test
    public void testDeleteFacultyService() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);

        //when
        facultyService.deleteFaculty(faculty);
        Faculty someFaculty = facultyService.getFacultyById(faculty.getFacultyId());

        //then
        assertThat(someFaculty, is(nullValue()));
    }

    @Test
    public void testGetAllFaculties__givenOneStudentOnly() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);

        //when
        List<User> faculties = facultyService.getAllFaculties();

        System.out.println(facultyService.getAllFaculties());

        //then
        assertThat(faculties, contains(faculty));
    }

    @Test
    public void testUpdateFaculties() throws Exception {
        //given
        Faculty faculty = new Faculty("Economical");
        facultyService.addFaculty(faculty);

        //when
        String newTitle = "Technical";
        faculty.setTitle(newTitle);

        facultyService.updateFaculty(faculty);

        //then
        assertThat(faculty.getTitle(), is(newTitle));
    }
}