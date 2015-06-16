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
    <h1> Mark admission </h1>

    <form action="/marks/create" method="post">

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
            Mark is : <input type="text" name="rating"/>
        </p>

        <button type="submit" class="btn btn-success">
            Add new mark
        </button>
        <a href="/marks" class="btn btn-primary">Cancel</a>

    </form>
</div>
</body>
</html>
