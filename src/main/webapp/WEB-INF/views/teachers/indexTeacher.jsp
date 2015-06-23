<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-md-10">
        <div class="tab-header-area">
            <h1>List of teachers</h1>
        </div>

    </div>
    <security:authorize access="hasRole('ADMIN')">
        <div class="col-md-2">
            <a href="/students/new" class="glyphicon glyphicon-plus btn-lg">Add student</a>
        </div>
    </security:authorize>
</div>

<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Teacher Id</th>
        <th>Name</th>
        <th>Faculty</th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td>${teacher.studentId}</td>
            <td>${teacher.name}</td>
            <td>${teacher.faculty.title}</td>
            <td>
                <security:authorize access="hasRole('ADMIN')">
                    <a href="<c:url value="/teachers/${student.studentId}/edit"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>

                    <a href="<c:url value="/teachers/${student.studentId}/delete"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>
                </security:authorize>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

