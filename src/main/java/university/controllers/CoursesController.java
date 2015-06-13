package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import university.dao.courseDao.CourseDao;

import java.sql.SQLException;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CourseDao courseDao;

    @RequestMapping(value = "/coursesList", method = RequestMethod.GET)
    public ModelAndView index() throws SQLException {
        ModelAndView model = new ModelAndView("course/ShowCourses");
        model.addObject("courses", courseDao.getAllCourses());
        return model;
    }
}
