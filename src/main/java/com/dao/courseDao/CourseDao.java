package com.dao.courseDao;

import com.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    void addCourse(Course course) throws SQLException;

    Course getCourseById(Integer id) throws SQLException;

    List getAllCourses() throws SQLException;

    void deleteCourse(Course course) throws SQLException;

}
