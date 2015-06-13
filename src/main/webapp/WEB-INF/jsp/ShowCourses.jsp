<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Show All Courses</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <br>
    <p>
        <%--<a href="/students/newCourses" class="btn btn-primary">Add Course</a>--%>
        <a href="/" class="btn btn-primary">Back to main menu </a>

    </p>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Course Id</th>
            <th>Title</th>
            <th>Faculty</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.courseId}</td>
                <td>${course.title}</td>
                <td>${course.faculty.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
