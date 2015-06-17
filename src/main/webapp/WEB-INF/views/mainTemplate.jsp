<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<title>--%>
        <%--<tiles:insertAttribute name="title" />--%>
    <%--</title>--%>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="left">
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="header"/>
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu"/>
        </td>
        <td>
            <tiles:insertAttribute name="body"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="footer"/>
        </td>
    </tr>
</table>
</body>
</html>
