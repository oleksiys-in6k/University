package university.dao.bestStudentDao;

import university.entity.Faculty;
import university.entity.Student;

/**
 * Created by employee on 6/10/15.
 */
public interface BestStudentDao {
    Student getBestStudent(Faculty faculty);
}
