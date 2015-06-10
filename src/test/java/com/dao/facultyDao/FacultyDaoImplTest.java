package com.dao.facultyDao;

import com.entity.Faculty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testSpring-config.xml")
@Transactional
@TransactionConfiguration
public class FacultyDaoImplTest {

    @Autowired
    private FacultyDaoImpl facultyDaoImpl;

    @Test
    public void testFacultyDao() throws Exception {
        Faculty faculty = new Faculty("Economical");
        facultyDaoImpl.addFaculty(faculty);

        Faculty someFaculty = facultyDaoImpl.getFacultyById(faculty.getFacultyId());

        assertThat(someFaculty.getTitle(), is("Economical"));

    }
}