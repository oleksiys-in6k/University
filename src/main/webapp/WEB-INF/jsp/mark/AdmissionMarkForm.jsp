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

    <form action="<c:url value="/marks/doneMark"/>" method="get">

        <p>
            Choose student :
            <label>
                <select name="markStudent" items="${students}">
                    <c:forEach items="${students}" var="student">
                        <option value="${student.studentId}">${student.name}</option>
                    </c:forEach>
                </select>
            </label>
        </p>

        <p>
            Choose course :
            <label>
                <select name="markCourse" items="${courses}">
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.courseId}">${course.title}</option>
                    </c:forEach>
                </select>
            </label>
        </p>
        <p>
            Mark is : <input type="text" name="markValue"/>
        </p>

        <button type="submit" value=" Send" class="btn btn-success">
            Submit this form by clicking here</button>
        <a href="<c:url value="/"/>" class="btn btn-primary">Back to main menu</a>

    </form>
</div>
</body>
</html>

