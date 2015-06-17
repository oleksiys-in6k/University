<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/resources/core/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/core/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">

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
<label for="autocomplete">Select a programming language: </label>
<input id="autocomplete">
<script>
    $( "#autocomplete" ).autocomplete({
        source: [ "c++", "java", "php", "coldfusion", "javascript", "asp", "ruby" ]
    });
</script>
</body>
</html>


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
