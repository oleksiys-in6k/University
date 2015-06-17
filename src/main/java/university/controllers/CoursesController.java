package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.entity.Course;
import university.service.courseService.CourseService;
import university.service.facultyService.FacultyService;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("indexCourse");
        model.addObject("courses", courseService.getAllCourses());
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newCourse() {
        ModelAndView model = new ModelAndView("newCourse");
        model.addObject("faculties", facultyService.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create (
            @RequestParam("title") String title,
            @RequestParam("courseFaculty") Integer facultyId) {

        // Uncomment this for saving in DB
        courseService.addCourse(new Course(facultyService.getFacultyById(facultyId), title));

        ModelAndView model = new ModelAndView("indexCourse");
        model.addObject("courses", courseService.getAllCourses());
        return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editCourse(@RequestParam("title") String title,
                                    @RequestParam("faculty") Integer facultyId,
                                    @PathVariable("id") Integer courseId) {
        ModelAndView model = new ModelAndView("indexCourse");
        Course course = courseService.getCourseById(courseId);
        course.setTitle(title);
        course.setFaculty(facultyService.getFacultyById(facultyId));
        courseService.updateCourse(course);

        model.addObject("courses", courseService.getAllCourses());

        return model;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer facultyId) {
        ModelAndView modelAndView = new ModelAndView("editCourse");
        Course course = courseService.getCourseById(facultyId);
        modelAndView.addObject("faculties", facultyService.getAllFaculties());
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer courseId) {

        System.out.println(courseId);

        // Uncomment this for saving in DB
        Course course = courseService.getCourseById(courseId);
        courseService.deleteCourse(course);
        System.out.println("delete done");

        ModelAndView model = new ModelAndView("indexCourse");
        model.addObject("courses", courseService.getAllCourses());

        return model;
    }

}
