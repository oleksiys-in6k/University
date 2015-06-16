<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <title>University</title>

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
                <li><a href="/faculties">Faculties</a></li>
                <li><a href="/students">Students</a></li>
                <li><a href="/courses">Courses</a></li>
            </ul>

            <br>

            <ul class="nav nav-sidebar">
                <li><a href="/marks">Marks</a></li>
                <li class="active"><a href="bestStudent/getBestStudent">Get best student via faculty</a></li>
                <li><a href="#">Get list of all marks</a></li>
            </ul>
        </div>
        <div class="col-lg-10">


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
