package university.service.bestStudentService;

import university.entity.Faculty;
import university.entity.Student;

public interface BestStudentService {
    Student getBestStudent(Faculty faculty);
}
