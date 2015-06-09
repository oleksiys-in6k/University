package com.dao.facultyDao;

import com.entity.Faculty;
import com.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface FacultyDao {
    void addFaculty(Faculty faculty) throws SQLException;
    Faculty getFacultyById(Integer id) throws SQLException;
    List getAllFaculties() throws SQLException;
    void deleteFaculty(Faculty faculty) throws SQLException;
    Student getBestStudentByFacultyId (Integer id) throws SQLException;

}
