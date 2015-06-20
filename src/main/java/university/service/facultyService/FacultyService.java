package university.service.facultyService;


import university.entity.Faculty;

import java.util.List;

public interface FacultyService {

    void addFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Faculty faculty);
    Faculty getFacultyById(Integer id);
    List getAllFaculties();

}
