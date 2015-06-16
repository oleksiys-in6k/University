package university.dao.courseDao;

import university.entity.Course;

import java.util.List;

public interface CourseDao {
    void addCourse(Course course);
    void deleteCourse(Course course);
    void updateCourse(Course course);
    Course getCourseById(Integer id);
    List getAllCourses();

}
