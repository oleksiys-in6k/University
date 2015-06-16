<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add new course</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1> Add new course </h1>

    <form action="/courses/create" method="post">
        <p>
            Title : <input type="text" name="title"/>
        </p>

        <p>
            Faculty :

            <label>
                <select name="courseFaculty" items="${faculties}">
                    <c:forEach items="${faculties}" var="faculty">
                        <option value="${faculty.facultyId}">${faculty.title}</option>
                    </c:forEach>
                </select>
            </label>
        </p>


        <button type="submit" value=" Send" class="btn btn-success">
            Save new course
        </button>
        <a href="/faculties" class="btn btn-primary">Cancel</a>

    </form>
</div>
</body>
</html>

