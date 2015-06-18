

<%@page import="university.service.facultyService.FacultyService, university.entity.Faculty, java.util.List"%>
<%@ page import="university.service.facultyService.FacultyService" %>
<%@ page import="university.service.facultyService.FacultyServiceImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>faculties</title>
    </head>
    <body>
        <%
            FacultyService facultyService = new FacultyServiceImpl();
            List <Faculty> getFaculties = facultyService.getAllFaculties();
            for (Faculty faculty: getFaculties){
                out.println(faculty.getTitle());
            }
        %>
    </body>
</html>
