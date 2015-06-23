package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.entity.Teacher;
import university.service.facultyService.FacultyService;
import university.service.teacherService.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("indexTeacher");
        model.addObject("teachers", teacherService.getAllTeachers());
        return model;
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public ModelAndView newTeacher() {
        ModelAndView model = new ModelAndView("newTeacher");
        model.addObject("faculties", facultyService.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(
            @RequestParam("teacherName") String name,
            @RequestParam("teacherFaculty") Integer facultyId,
            @RequestParam("login") String login,
            @RequestParam("password") String password) {

        teacherService.addTeacher(new Teacher(name, facultyService.getFacultyById(facultyId), login, password));

        ModelAndView model = new ModelAndView("indexTeacher");
        model.addObject("teachers", teacherService.getAllTeachers());

        return model;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer teacherId) {

//		System.out.println(teacherId);
        // Uncomment this for saving in DB
        Teacher teacher = teacherService.getTeacherById(teacherId);
        teacherService.deleteTeacher(teacher);

        ModelAndView model = new ModelAndView("indexTeacher");
        model.addObject("teachers", teacherService.getAllTeachers());

        return model;
    }
}
