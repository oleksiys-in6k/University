package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.dao.facultyDao.FacultyDao;
import university.dao.studentDao.StudentDao;
import university.entity.Student;

import java.sql.SQLException;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private FacultyDao facultyDao;

	@RequestMapping(value = "/studentsList", method = RequestMethod.GET)
	public ModelAndView getAllUsers() throws SQLException {
		ModelAndView model = new ModelAndView("ShowStudents");
		model.addObject("students", studentDao.getAllStudents());
		return model;
	}

	@RequestMapping(value="/newStudent", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws SQLException {
		ModelAndView model = new ModelAndView("AdmissionStudentForm");
		model.addObject("faculties", facultyDao.getAllFaculties());
		return model;
	}

	@RequestMapping(value="/doneStudent", method = RequestMethod.GET)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,
											@RequestParam("studentFaculty") String facultyId) throws SQLException {

		// Uncommon this for saving in DB
//		int id = Integer.parseInt(facultyId);
//		studentDao.addStudent(new Student(name, facultyDao.getFacultyById(id)));

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details:: Name: "+name+ ", Faculty: " + facultyId);

		return model;
	}
}