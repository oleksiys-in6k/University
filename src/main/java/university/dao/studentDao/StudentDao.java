package university.dao.studentDao;


import university.entity.Student;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);
    void deleteStudent(Student student);
    void updateStudent(Student student);
    Student getStudentById(Integer id);
    List getAllStudents();
    Integer getCountOfStudents();
    Student findStudentByName(String name);

}
