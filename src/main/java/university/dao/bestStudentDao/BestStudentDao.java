package university.dao.bestStudentDao;

import university.entity.Faculty;
import university.entity.Student;

public interface BestStudentDao {
    Student getBestStudent(Faculty faculty);
}
