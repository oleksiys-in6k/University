<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Change course</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1> Edit course </h1>

    <form action="/courses/edit/${course.courseId}" method="post">

        <input>
            Title for faculty ${faculty.title} : <input type="text" name="title"> ${faculty.title}</input>
        </p>

        <button type="submit" value=" Send" class="btn btn-success">
            Change title
        </button>
        <a href="/courses" class="btn btn-primary">Cancel</a>

    </form>
</div>
</body>
</html>

