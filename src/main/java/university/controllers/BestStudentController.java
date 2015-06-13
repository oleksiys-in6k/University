package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.bestStudentDao.BestStudentDao;
import university.dao.facultyDao.FacultyDao;
import university.dao.studentDao.StudentDao;
import university.entity.Student;

import java.sql.SQLException;

@Controller
@RequestMapping("/bestStudent")
public class BestStudentController {

    @Autowired
    private BestStudentDao bestStudentDao;

    @Autowired
    private FacultyDao facultyDao;

    @RequestMapping(value = "/getBestStudent", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm() throws SQLException {
        ModelAndView model = new ModelAndView("SearchingBestStudent");
        model.addObject("faculties", facultyDao.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "/doneStudent", method = RequestMethod.GET)
    public ModelAndView searchingResult(@RequestParam("studentFaculty") String facultyId) throws SQLException {

        int id = Integer.parseInt(facultyId);
        Student bestStudent = bestStudentDao.getBestStudent(facultyDao.getFacultyById(id));

        ModelAndView model = new ModelAndView("SearchingResult");
        model.addObject("msg", "Result:: Name: " + bestStudent.getName()
                + ", is best via faculty: " + facultyDao.getFacultyById(id).getTitle());
        return model;
    }
}
