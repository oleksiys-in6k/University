<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-md-10">
        <div class="tab-header-area">
            <h1>List of marks</h1>
        </div>

    </div>
    <security:authorize access="hasRole('ROLE_TEACHER')">
        <div class="col-md-2">
            <a href="/marks/new" class="glyphicon glyphicon-plus btn-lg">Add mark</a>
        </div>
    </security:authorize>
</div>


<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Mark Id</th>
        <th>Student</th>
        <th>Course</th>
        <th>Mark</th>
        <th></th>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${marks}" var="mark">
        <tr>
            <td>${mark.markId}</td>
            <td>${mark.student.name}</td>
            <td>${mark.course.title}</td>
            <td>${mark.rating}</td>
            <td>
                <security:authorize access="hasRole('ADMIN')">
                <a href="<c:url value="/marks/${mark.markId}/delete"/>"
                   class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                </a>
                </security:authorize>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>