package com.searchingRequests;

import com.dao.bestStudentDao.BestStudentDao;
import com.dao.facultyDao.FacultyDaoImpl;
import com.entity.Faculty;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

    public void setBestStudentDao(com.dao.bestStudentDao.BestStudentDaoImpl bestStudentDao) {
        this.bestStudentDao = bestStudentDao;
    }
}
