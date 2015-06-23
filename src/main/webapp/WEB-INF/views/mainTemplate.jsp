<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <title>
        <tiles:insertAttribute name="title"/>
    </title>
</head>
<body>

<div class="container">

    <div class="page-header">
        <tiles:insertAttribute name="header"/>
    </div>

    <security:authorize access="isAuthenticated()">
        <tiles:insertAttribute name="logoutButton"/>
    </security:authorize>

    <security:authorize access="isAnonymous()">
        <tiles:insertAttribute name="loginButton"/>
    </security:authorize>


    <div class="row">
        <div class="col-md-3">
            <tiles:insertAttribute name="menu"/>
        </div>
        <div class="col-lg-9">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
    <div class="row" align="center">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>
</body>
</html>





