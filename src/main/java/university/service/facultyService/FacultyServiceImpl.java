package university.service.facultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.dao.facultyDao.FacultyDao;
import university.entity.Faculty;

import java.util.List;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    public FacultyServiceImpl() {
    }

    public FacultyServiceImpl(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    @Override
    public void addFaculty(Faculty faculty) {
        facultyDao.addFaculty(faculty);
    }

    @Override
    public Faculty getFacultyById(Integer id) {
        return facultyDao.getFacultyById(id);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        facultyDao.updateFaculty(faculty);
    }

    @Override
    public List getAllFaculties() {
        return facultyDao.getAllFaculties();
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        facultyDao.deleteFaculty(faculty);
    }

    public void setFacultyDao(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }
}
