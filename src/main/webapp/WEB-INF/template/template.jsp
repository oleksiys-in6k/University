<!DOCTYPE HTML>
<%@ include file="/WEB-INF/template/includes.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>

  <title><tiles:insertAttribute name="title" ignore="true"/></title>

</head>
<body>
<div id="banner">
  <tiles:insertAttribute name="header" />
</div>
<div></div>
<tiles:insertAttribute name="navigation_bar" />
<div></div>
<div id="page">
  <tiles:insertAttribute name="content" />
</div>
<div></div>
<div id="footer_wrapper">
  <tiles:insertAttribute name="footer" />
</div>
</body>
</html>