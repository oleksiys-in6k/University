package university.searchingRequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import university.dao.bestStudentDao.BestStudentDao;
import university.dao.facultyDao.FacultyDao;
import university.entity.Faculty;
import university.entity.Student;
import university.service.facultyService.FacultyService;

import java.sql.SQLException;
import java.util.Scanner;

@Transactional
public class SearchBestStudentImpl implements SearchBestStudent {

    @Autowired
    private BestStudentDao bestStudentDao;

    @Autowired
    private FacultyService facultyService;

    public Student getBestStudent() {
        Faculty faculty = getFacultyFromList();
        return bestStudentDao.getBestStudent(faculty);
    }

    private Faculty getFacultyFromList() {
        System.out.println("List of faculties");
        System.out.println(facultyService.getAllFaculties());
        Integer facultyId = Integer.valueOf(keyboard("Choose faculty"));
        return facultyService.getFacultyById(facultyId);
    }

    private String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
