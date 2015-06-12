//package university.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import university.dao.studentDao.StudentDao;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//
//@Controller
//@RequestMapping("/students")
//public class UserController extends HttpServlet {
//
//    private static String LIST_USER = "/listUser.jsp";
//
//    @Autowired
//    StudentDao studentDAO;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String forward="";
//
//
//        forward = LIST_USER;
//        try {
//            request.setAttribute("usersList", studentDAO.getAllStudents());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        RequestDispatcher view = request.getRequestDispatcher(forward);
//        view.forward(request, response);
//    }
//}
