<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Show All Marks</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <br>
    <p>
        <a href="<c:url value="/marks/newMark"/>" class="btn btn-primary">Add new mark</a>
        <a href="<c:url value="/"/>" class="btn btn-primary">Back to main menu </a>

    </p>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Mark Id</th>
            <th>Student</th>
            <th>Course</th>
            <th>Mark</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${marks}" var="mark">
            <tr>
                <td>${mark.markId}</td>
                <td>${mark.student.name}</td>
                <td>${mark.course.title}</td>
                <td>${mark.rating}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
