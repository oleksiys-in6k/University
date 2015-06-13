<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Show All Students</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <br>
    <p>
        <a href="<c:url value="/students/newStudent"/>" class="btn btn-primary">Add Student</a>
        <a href="<c:url value="/"/>" class="btn btn-primary">Back to main menu </a>

    </p>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Student Id</th>
            <th>Name</th>
            <th>Faculty</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.studentId}</td>
                <td>${student.name}</td>
                <td>${student.faculty.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
