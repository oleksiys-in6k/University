<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>Show All Students</title>
</head>
<body>
<table border=1>
  <thead>
  <tr>
    <th>StudentId</th>
    <th>Name</th>
    <th>FacultyId</th>
    <th></th>
    <th colspan=2>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="users">
    <tr>
      <td><c:out value="${user.userid}" /></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="UserController?action=insert">Add User</a></p>
</body>
</html>