package university.dao.studentDao;


import university.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    void addStudent(Student student);
    void deleteStudent(Student student);
    void updateStudent(Student student);
    Student getStudentById(Integer id);
    List getAllStudents();
    Integer getCountOfStudents();



}
