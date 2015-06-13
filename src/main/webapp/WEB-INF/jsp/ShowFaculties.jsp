<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Show All Faculties</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <br>

    <p>
        <%--<a href="/faculties/newFaculty" class="btn btn-primary">Add faculty</a>--%>
        <a href="/" class="btn btn-primary">Back to main menu</a>
        <a href="/" class="btn btn-primary">Get best student via faculty</a>
    </p>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Faculty Id</th>
            <th>Title</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${faculties}" var="faculty">
            <tr>
                <td>${faculty.facultyId}</td>
                <td>${faculty.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
