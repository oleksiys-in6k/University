package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import university.entity.Student;
import university.service.facultyService.FacultyService;
import university.service.studentService.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("indexStudent");
		model.addObject("students", studentService.getAllStudents());
		return model;
	}

	@RequestMapping(value = "new" , method = RequestMethod.GET)
	public ModelAndView newStudent() {
		ModelAndView model = new ModelAndView("newStudent");
		model.addObject("faculties", facultyService.getAllFaculties());
		return model;
	}

	@RequestMapping( value = "create", method = RequestMethod.POST)
	public ModelAndView create(
			@RequestParam("studentName") String name,
			@RequestParam("studentFaculty") Integer facultyId) {

		// Uncomment this for saving in DB
		studentService.addStudent(new Student(name, facultyService.getFacultyById(facultyId)));

		ModelAndView model = new ModelAndView("indexStudent");
		model.addObject("students", studentService.getAllStudents());

		return model;
	}
	@RequestMapping( value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") Integer studentId) {

		System.out.println(studentId);
		// Uncomment this for saving in DB
		Student student = studentService.getStudentById(studentId);
		studentService.deleteStudent(student);

		ModelAndView model = new ModelAndView("indexStudent");
		model.addObject("students", studentService.getAllStudents());

		return model;
	}
}
