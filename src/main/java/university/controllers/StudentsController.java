package university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String getAdmissionForm() {
		return "AdmissionForm";
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> reqPar) {

		String name = reqPar.get("studentName");
		String hobby = reqPar.get("hobby");

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details:: Name: "+name+ ", Hobby: " + hobby);

		return model;
	}
}