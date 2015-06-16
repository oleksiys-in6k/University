package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.entity.Faculty;
import university.service.facultyService.FacultyService;

@Controller
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("faculties/index");
        model.addObject("faculties", facultyService.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public ModelAndView newFaculty() {
        ModelAndView model = new ModelAndView("faculties/new");
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("title") String title) {
        ModelAndView model = new ModelAndView("faculties/index");
        Faculty faculty = new Faculty(title);
        facultyService.addFaculty(faculty);

        model.addObject("faculties", facultyService.getAllFaculties());

        return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editStudent(@RequestParam("title") String title,
                                    @PathVariable("id") Integer facultyId) {
        ModelAndView model = new ModelAndView("faculties/index");
        Faculty faculty = facultyService.getFacultyById(facultyId);
        faculty.setTitle(title);
        facultyService.updateFaculty(faculty);

        model.addObject("faculties", facultyService.getAllFaculties());

        return model;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer facultyId) {
        ModelAndView modelAndView = new ModelAndView("faculties/edit");
        Faculty faculty = facultyService.getFacultyById(facultyId);
        modelAndView.addObject("faculty", faculty);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer facultyId) {

        System.out.println(facultyId);

        // Uncomment this for saving in DB
        Faculty faculty = facultyService.getFacultyById(facultyId);
        facultyService.deleteFaculty(faculty);

        ModelAndView model = new ModelAndView("faculties/index");
        model.addObject("faculties", facultyService.getAllFaculties());

        return model;
    }

}
