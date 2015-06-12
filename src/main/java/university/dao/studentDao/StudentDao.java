package university.dao.studentDao;


import university.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    void addStudent(Student student) throws SQLException;
    Student getStudentById(Integer id) throws SQLException;
    List getAllStudents() throws SQLException;
    void deleteStudent(Student student) throws SQLException;
    Integer getCountOfStudents() throws SQLException;



}
