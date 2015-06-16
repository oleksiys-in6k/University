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
        <div class="col-md-3">
            <div class="list-group  navbar" id="sidebar">
                <ul class="nav" id="mynav" data-spy="affix" data-offset-top="280">
                    <li><a href="/" class="list-group-item active">Home</a></li>
                    <li><a href="/faculties" class="list-group-item" contenteditable="false">Faculties</a></li>
                    <li><a href="/students" class="list-group-item" contenteditable="false">Students</a></li>
                    <li><a href="/courses" class="list-group-item" contenteditable="false">Courses</a></li>
                </ul>

                <br>

                <ul class="nav nav-sidebar">
                    <li><a href="/marks" class="list-group-item" contenteditable="false">Marks</a></li>
                    <li><a href="bestStudent/getBestStudent" class="list-group-item" contenteditable="false">Get best
                        student via faculty</a></li>
                    <li><a href="#" class="list-group-item" contenteditable="false">Get list of all marks</a></li>
                </ul>
            </div>
            <div class="col-lg-10">


            </div>
        </div>
    </div>
    <br>

</div>
</body>
</html>
