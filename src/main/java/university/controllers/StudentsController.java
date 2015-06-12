package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.studentDao.StudentDao;
import university.entity.Faculty;
import university.entity.Student;

import java.sql.SQLException;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/studentsList", method = RequestMethod.GET)
	public ModelAndView index() throws SQLException {
		ModelAndView model = new ModelAndView("ShowStudents");

		Faculty faculty = new Faculty("Faculty");
		Student student = new Student("Josh",faculty);
		studentDao.addStudent(student);

		model.addObject("users", studentDao.getAllStudents());
		return model;
	}

	@RequestMapping(value="/new", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		return new ModelAndView("AdmissionForm");
	}

	@RequestMapping(value="/done", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,
											@RequestParam("studentHobby") String hobby) {

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details:: Name: "+name+ ", Hobby: " + hobby);

		return model;
	}
}