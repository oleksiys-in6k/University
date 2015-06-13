<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add new student</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
    <h1> Student admission </h1>

    <form action="/students/doneStudent" method="get">
        <p>
            Student's Name : <input type="text" name="studentName"/>
        </p>

        <p>
            Student's faculty :

            <select name="studentFaculty" items="${faculties}">
                <c:forEach items="${faculties}" var="faculty">
                    <option value="${faculty.facultyId}">${faculty.title}</option>
                </c:forEach>
            </select>
        </p>
        <button type="submit" value=" Send" class="btn btn-success">
            Submit this form by clicking here</button>
        <a href="/" class="btn btn-primary">Back to main menu</a>


    </form>
</div>
</body>
</html>

