package university.service.courseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.dao.courseDao.CourseDao;
import university.entity.Course;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.addCourse(course);

    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public List getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
