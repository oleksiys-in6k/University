package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.entity.Mark;
import university.service.courseService.CourseService;
import university.service.markService.MarkService;
import university.service.studentService.StudentService;

@Controller
@Transactional
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarkService markService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("marks/index");
        model.addObject("marks", markService.getAllMarks());
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getAdmissionMarkForm() {

        ModelAndView model = new ModelAndView("marks/new");
        model.addObject("students", studentService.getAllStudents());
        model.addObject("courses", courseService.getAllCourses());
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@RequestParam("markStudent") Integer studentId,
                                            @RequestParam("markCourse") Integer courseId,
                                            @RequestParam("rating") Integer rating
    ) {

        markService.addMark(new Mark(
                studentService.getStudentById(studentId),
                courseService.getCourseById(courseId),
                rating));

        ModelAndView model = new ModelAndView("marks/index");

        model.addObject("marks", markService.getAllMarks());
        return model;
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer markId) {

        System.out.println(markId);

        // Uncomment this for saving in DB
        Mark mark = markService.getMarkById(markId);
        markService.deleteMark(mark);

        ModelAndView model = new ModelAndView("marks/index");
        model.addObject("marks", markService.getAllMarks());

        return model;
    }

}
