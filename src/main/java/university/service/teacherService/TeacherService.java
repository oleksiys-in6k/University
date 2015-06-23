package university.service.teacherService;

import university.entity.Teacher;

import java.util.List;

/**
 * Created by Lex on 23.06.2015.
 */
public interface TeacherService {

    void addTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher getTeacherById(Integer id);

    List getAllTeachers();

    Teacher findTeacherByName(String name);

}
