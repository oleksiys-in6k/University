package university.dao.facultyDao;

import university.entity.Faculty;

import java.util.List;

public interface FacultyDao {
    void addFaculty(Faculty faculty);
    Faculty getFacultyById(Integer id);
    void updateFaculty(Faculty faculty);
    List getAllFaculties();
    void deleteFaculty(Faculty faculty);
}
