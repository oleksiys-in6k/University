package university.searchingRequests;

import university.dao.bestStudentDao.BestStudentDao;
import university.dao.facultyDao.FacultyDaoImpl;
import university.entity.Faculty;
import university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import university.dao.bestStudentDao.BestStudentDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

@Transactional
public class SearchBestStudentImpl implements SearchBestStudent {

    @Autowired
    private BestStudentDao bestStudentDao;

    @Autowired
    private FacultyDaoImpl facultyDao;

    public Student getBestStudent() throws SQLException {
        Faculty faculty = getFacultyFromList();
        return bestStudentDao.getBestStudent(faculty);
    }

    private Faculty getFacultyFromList() throws SQLException {
        System.out.println("List of faculties");
        System.out.println(facultyDao.getAllFaculties());
        Integer facultyId = Integer.valueOf(keyboard("Choose faculty"));
        return facultyDao.getFacultyById(facultyId);
    }

    private String keyboard(String message) {
        System.out.println(message + " ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public void setFacultyDao(FacultyDaoImpl facultyDao) {
        this.facultyDao = facultyDao;
    }

    public void setBestStudentDao(BestStudentDaoImpl bestStudentDao) {
        this.bestStudentDao = bestStudentDao;
    }
}
