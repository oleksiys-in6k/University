package university.dao.teacherDao;


import university.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    void addTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    List getAllTeachers();
    Teacher findTeacherByName(String name);

}
