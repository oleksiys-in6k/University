<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add new student</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1> Student admission </h1>

    <form action="/students/create" method="post">
        <p>
            Student's Name : <input type="text" name="studentName"/>
        </p>

        <p>
            Student's faculty :

            <label>
                <select name="studentFaculty" items="${faculties}">
                    <c:forEach items="${faculties}" var="faculty">
                        <option value="${faculty.facultyId}">${faculty.title}</option>
                    </c:forEach>
                </select>
            </label>
        </p>
        <button type="submit" value=" Send" class="btn btn-success">
            Add new Student</button>
        <a href="/students/" class="btn btn-primary">Cancel</a>

    </form>
</div>
</body>
</html>

