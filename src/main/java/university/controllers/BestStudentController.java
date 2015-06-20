//package university.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.university.web.bind.annotation.RequestMapping;
//import org.springframework.university.web.bind.annotation.RequestMethod;
//import org.springframework.university.web.bind.annotation.RequestParam;
//import org.springframework.university.web.servlet.ModelAndView;
//import university.dao.bestStudentDao.BestStudentDao;
//import university.dao.facultyDao.FacultyDao;
//import university.entity.Student;
//
//@Controller
//@RequestMapping("/bestStudent")
//public class BestStudentController {
//
//    @Autowired
//    private BestStudentDao bestStudentDao;
//
//    @Autowired
//    private FacultyDao facultyDao;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView getAdmissionForm() {
//        ModelAndView model = new ModelAndView("bestStudent");
//        model.addObject("faculties", facultyDao.getAllFaculties());
////        model.addObject("msg", "Result:: Name: , is best via Faculty: ");
//        return model;
//    }
//
//    @RequestMapping(value = "/doneStudent", method = RequestMethod.GET)
//    public ModelAndView searchingResult(@RequestParam("studentFaculty") String facultyId) {
//
//        int id = Integer.parseInt(facultyId);
//        Student bestStudent = bestStudentDao.getBestStudent(facultyDao.getFacultyById(id));
//
//
//
//        ModelAndView model = new ModelAndView("bestStudent");
//
//        model.addObject("faculties", facultyDao.getAllFaculties());
//        model.addObject("msg", "Name: " + bestStudent.getName()
//                + ", is best via Faculty: " + facultyDao.getFacultyById(id).getTitle());
//        return model;
//    }
//}
