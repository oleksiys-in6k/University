package university.service.courseService;

import university.entity.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
    Course getCourseById(Integer id);
    List getAllCourses();

}
