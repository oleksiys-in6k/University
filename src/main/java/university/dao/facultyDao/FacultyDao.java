package university.dao.facultyDao;

import university.entity.Faculty;

import java.sql.SQLException;
import java.util.List;

public interface FacultyDao {
    void addFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Faculty faculty);
    Faculty getFacultyById(Integer id);
    List getAllFaculties();

}
