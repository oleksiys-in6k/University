package university.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import university.entity.Faculty;
import university.service.facultyService.FacultyService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bestStudent")
public class SearchController {

    List<Faculty> data = new ArrayList<Faculty>();

    @Autowired
    private FacultyService facultyService;

    SearchController() {
        // init data for testing
        data.add(new Faculty("ruby"));
        data.add(new Faculty( "rails"));
        data.add(new Faculty( "c / c++"));
        data.add(new Faculty( ".net"));
        data.add(new Faculty( "python"));
        data.add(new Faculty( "java"));
        data.add(new Faculty( "javascript"));
        data.add(new Faculty( "jscript"));

    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("indexBestStudent");
        model.addObject("faculties", facultyService.getAllFaculties());
        return model;
    }

    @RequestMapping(value = "/getFaculty", method = RequestMethod.GET)
    public @ResponseBody
    List<Faculty> getFaculty(@RequestParam String facultyName) {

        return simulateSearchResult(facultyName);

    }

    private List<Faculty> simulateSearchResult(String facultyName) {

        List<Faculty> result = new ArrayList<Faculty>();

        // iterate a list and filter by facultyName
        for (Faculty faculty : data) {
            if (faculty.getTitle().contains(facultyName)) {
                result.add(faculty);
            }
        }

        return result;
    }

}
