<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
<h1> STUDENT ADMISSION </h1>

<form action="/students/done" method="post">
    <p>
        Student's Name : <input type="text" name="studentName"/>
    </p>

    <p>
        Student's faculty :

            <select name="roleName">
                <option value="faculty1"selected='selected'>Technical</option>
                <option value="faculty2">Economical</option>
                <option value="faculty3">Historical</option>
            </select>


    <%--ToDo here --%>

    <%--<select items="${faculties}">--%>
        <%--<c:forEach items="${faculties}" var="student">--%>
            <%--<option value="${faculty.facultyId}">${faculty.title}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>


    </p>
    <input type="submit" value="Submit this form by clicking here"/>
</form>
</div>
</body>
</html>

