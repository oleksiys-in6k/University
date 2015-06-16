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

    <div class="page-header">
        <h1>University
            <small>university</small>
        </h1>
    </div>
    <div class="row">
        <div class="col-lg-2">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/faculties/">Faculties</a></li>
                <li><a href="/students">Students</a></li>
                <li><a href="/courses">Courses</a></li>
            </ul>

            <br>

            <ul class="nav nav-sidebar">
                <li><a href="marks/">Marks</a></li>
                <li><a href="bestStudent/getBestStudent">Get best student via faculty</a></li>
            </ul>
        </div>
        <div class="col-lg-10">

            <div class="page-header">
                <h1>List of students</h1>
            </div>

            <p>
                <a href="/students/new" class="btn btn-primary">Add Student</a>
            </p>

            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Student Id</th>
                    <th>Name</th>
                    <th>Faculty</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.studentId}</td>
                        <td>${student.name}</td>
                        <td>${student.faculty.title}</td>
                        <td>
                            <a href="<c:url value="/students/${student.studentId}/edit"/>" class="btn btn-default btn-sm">
                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                            </a>

                            <a href="<c:url value="/students/${student.studentId}/delete"/>"
                               class="btn btn-default btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<br>

<p>
    <%--<a href="marks/marksList" class="btn btn-primary">Get list of all marks</a>--%>
</p>


</div>
</body>
</html>
