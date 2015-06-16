<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Searching best Student via faculty</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h2> search for the best student (the sum of marks) throughout the university on faculty </h2>

    <form action="/bestStudent/doneStudent" method="get">
        <p>
            Choose faculty :

            <label>
                <select name="studentFaculty" items="${faculties}">
                    <c:forEach items="${faculties}" var="faculty">
                        <option value="${faculty.facultyId}">${faculty.title}</option>
                    </c:forEach>
                </select>
            </label>
        </p>
        <button type="submit" value=" Send" class="btn btn-success">Get best student</button>
        <a href="<c:url value="/"/>" class="btn btn-primary">Back to main menu</a>

    </form>
</div>
</body>
</html>

