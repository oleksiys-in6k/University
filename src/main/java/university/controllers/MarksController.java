package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.courseDao.CourseDao;
import university.dao.markDao.MarkDao;
import university.dao.studentDao.StudentDao;

import java.sql.SQLException;

@Controller
@Transactional
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
    public ModelAndView getAdmissionMarkForm(
    ) throws SQLException {

        ModelAndView model = new ModelAndView("mark/AdmissionMarkForm");
        model.addObject("students", studentDao.getAllStudents());
        model.addObject("courses", courseDao.getAllCourses());
        return model;
    }

    @RequestMapping(value = "/doneMark", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@RequestParam("markStudent") String studentId,
                                            @RequestParam("markCourse") String courseId,
                                            @RequestParam("rating") String rating
    ) throws SQLException {

        int studId = Integer.parseInt(studentId);
        int courId = Integer.parseInt(courseId);

        if (isString(rating)) {
            ModelAndView model = new ModelAndView("mark/AdmissionMarkForm");
            model.addObject("students", studentDao.getAllStudents());
            model.addObject("courses", courseDao.getAllCourses());

            return model;
        }

        int ratingMark = Integer.parseInt(rating);

//        markDao.addMark(new Mark(
//                studentDao.getStudentById(studId),
//                courseDao.getCourseById(courId),
//                ratingMark));

        ModelAndView model = new ModelAndView("mark/AdmissionMarkSuccess");
        model.addObject("msg", "Details:: Mark: " + ratingMark +
                ", Student: " + studentDao.getStudentById(studId).getName() + ", Course: " +
                courseDao.getCourseById(courId).getTitle());

        return model;
    }

    public boolean isString(String string) {
        if (string == null) return true;
        return !string.matches("^-?\\d+$");
    }

}
