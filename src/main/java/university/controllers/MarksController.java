package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.courseDao.CourseDao;
import university.dao.markDao.MarkDao;
import university.dao.studentDao.StudentDao;
import university.entity.Mark;
import university.entity.Student;

import java.sql.SQLException;

@Controller
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarkDao markDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;

    @RequestMapping(value = "/marksList", method = RequestMethod.GET)
    public ModelAndView getAllMarks() throws SQLException {
        ModelAndView model = new ModelAndView("mark/ShowMarks");
        model.addObject("marks", markDao.getAllMarks());
        return model;
    }

    @RequestMapping(value = "/newMark", method = RequestMethod.GET)
    public ModelAndView getAdmissionMarkForm() throws SQLException {
        ModelAndView model = new ModelAndView("mark/AdmissionMarkForm");
        model.addObject("students", studentDao.getAllStudents());
        model.addObject("courses", courseDao.getAllCourses());
        return model;
    }

    @RequestMapping(value = "/doneMark", method = RequestMethod.GET)
    public ModelAndView submitAdmissionForm(@RequestParam("markStudent") String studentId,
                                            @RequestParam("markCourse") String courseId,
                                            @RequestParam("markValue") String markValue) throws SQLException {

        // Uncommon this for saving in DB
        int studId = Integer.parseInt(studentId);
        int courId = Integer.parseInt(courseId);
        markDao.addMark(new Mark(
                studentDao.getStudentById(studId),
                courseDao.getCourseById(courId),
                Integer.parseInt(markValue)));

        ModelAndView model = new ModelAndView("mark/AdmissionMarkSuccess");
        model.addObject("msg", "Details:: Mark: " + markValue +
                ", Student: " + studentDao.getStudentById(studId) + ", Course: " +
                courseDao.getCourseById(courId));

        return model;
    }
}
