<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2> search for the best student (the sum of marks) throughout the university on faculty </h2>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>autocomplete demo</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>


<body>
<div id ="conteudo">
    <h1>Auto complete com Jquery e Jsp</h1>
    <input type ="text" name ="txtnomepais" id ="nomepais"/>
</div>

<script>
    $().ready(function() {
        $("#nomepais").autocomplete("getFaculties.jsp", {
            width: 303,
            scrollHeight: 220
        });
    })
</script>



<%--<form action="/bestStudent/doneStudent" method="get">--%>
    <%--<p>--%>
        <%--Choose faculty :--%>

        <%--<label>--%>
            <%--<select name="studentFaculty" items="${faculties}">--%>
                <%--<c:forEach items="${faculties}" var="faculty">--%>
                    <%--<option value="${faculty.facultyId}">${faculty.title}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
        <%--</label>--%>
    <%--</p>--%>
    <%--<button type="submit" value=" Send" class="btn btn-success">Get best student</button>--%>
    <%--<a href="<c:url value="/"/>" class="btn btn-primary">Cancel</a>--%>

<%--</form>--%>

<h3>${msg}</h3>
