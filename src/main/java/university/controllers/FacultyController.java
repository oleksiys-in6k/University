package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.facultyDao.FacultyDao;
import university.entity.Faculty;
import university.service.facultyService.FacultyService;

import java.sql.SQLException;

@Controller
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/faculties/index");
        model.addObject("faculties", facultyService.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "/newFaculty", method = RequestMethod.GET)
    public ModelAndView newFaculty() {
        ModelAndView model = new ModelAndView("/faculties/new");
        model.addObject("faculties", facultyService.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createFaculty(@RequestParam("title") String title) {
        ModelAndView model = new ModelAndView("/faculties/index");
        facultyService.addFaculty(new Faculty(title));
        System.out.println("crete new faculty");
        model.addObject("faculties", facultyService.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "/{facultyId}/edit", method = RequestMethod.GET)
    public ModelAndView editFaculty(@PathVariable("facultyId") String facultyId) {
        ModelAndView model = new ModelAndView("/faculties/edit");

        Faculty faculty = facultyService.getFacultyById(Integer.valueOf(facultyId));

        System.out.println("edit faculty " + faculty);

        model.addObject("faculty", faculty);

        return model;
    }

    @RequestMapping(value = "/edit/{facultyId}", method = RequestMethod.POST)
    public ModelAndView submitEdit(@RequestParam("title") String title,
                                   @PathVariable("facultyId") String facultyId) {
        ModelAndView model = new ModelAndView("/faculties/index");

        Faculty faculty = facultyService.getFacultyById(Integer.valueOf(facultyId));
        faculty.setTitle(title);
        facultyService.updateFaculty(faculty);

        System.out.println("edit faculty " + faculty);

        model.addObject("faculties", facultyService.getAllFaculties());

        return model;
    }

    @RequestMapping(value = "/{facultyId}/delete", method = RequestMethod.GET)
    public ModelAndView deleteFaculty(@PathVariable("facultyId") String facultyId) {
        ModelAndView model = new ModelAndView("/faculties/index");

        facultyService.deleteFaculty(facultyService.getFacultyById(Integer.valueOf(facultyId)));
        System.out.println("delete faculty by id");

        model.addObject("faculties", facultyService.getAllFaculties());

        return model;
    }

}
