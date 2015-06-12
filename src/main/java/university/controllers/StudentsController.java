package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.studentDao.StudentDao;

import java.sql.SQLException;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/studentsList", method = RequestMethod.GET)
	public ModelAndView index() throws SQLException {
		ModelAndView model = new ModelAndView("ShowStudents");
		model.addObject("students", studentDao.getAllStudents());
		return model;
	}

	@RequestMapping(value="/newStudent", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		return new ModelAndView("AdmissionStudentForm");
	}

	@RequestMapping(value="/done", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,
											@RequestParam("studentFaculty") String faculty) {

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details:: Name: "+name+ ", Faculty: " + faculty);

		return model;
	}
}