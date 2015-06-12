package university.dao.facultyDao;

import university.entity.Faculty;

import java.sql.SQLException;
import java.util.List;

public interface FacultyDao {
    void addFaculty(Faculty faculty) throws SQLException;
    Faculty getFacultyById(Integer id) throws SQLException;
    List getAllFaculties() throws SQLException;
    void deleteFaculty(Faculty faculty) throws SQLException;

}
