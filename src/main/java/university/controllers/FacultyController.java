package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.facultyDao.FacultyDao;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyDao facultyDao;

    @RequestMapping(value = "/facultiesList", method = RequestMethod.POST)
    public ModelAndView index() throws SQLException {
        ModelAndView model = new ModelAndView("ShowFaculties");
        model.addObject("faculties", facultyDao.getAllFaculties());
        return model;
    }

//    @RequestMapping(value="/newFaculty", method = RequestMethod.GET)
//    public ModelAndView getAdmissionForm(@RequestParam("studentFaculty") List list) throws SQLException {
//        ModelAndView model = new ModelAndView("AdmissionStudentForm");
//        model.addObject("faculties", facultyDao.getAllFaculties());
//        return model;
//    }

}
