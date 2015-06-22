<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-md-10">
        <div class="tab-header-area">
            <h1>List of courses</h1>
        </div>

    </div>
    <security:authorize access="hasRole('ADMIN')">
        <div class="col-md-2">
            <a href="/courses/new" class="glyphicon glyphicon-plus btn-lg">Add course</a>
        </div>
    </security:authorize>
</div>

<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Course Id</th>
        <th>Title</th>
        <th>Faculty</th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.title}</td>
            <td>${course.faculty.title}</td>
            <td>

                <security:authorize access="hasRole('ADMIN')">

                <a href="<c:url value="/courses/${course.courseId}/edit"/>" class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                </a>

                <a href="<c:url value="/courses/${course.courseId}/delete"/>" class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                </a>

                </security:authorize>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

