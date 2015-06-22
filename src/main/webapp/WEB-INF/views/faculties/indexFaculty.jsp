<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div class="row">
    <div class="col-md-10">
        <div class="tab-header-area">
            <h1>List of faculties</h1>
        </div>

    </div>

    <security:authorize access="hasRole('ADMIN')">
        <div class="col-md-2">
            <a href="/faculties/new" class="glyphicon glyphicon-plus btn-lg">Add faculty</a>
        </div>
    </security:authorize>


</div>

<%--<p>--%>
<%--<a href="/faculties/new" class="btn btn-primary">Add faculty</a>--%>
<%--</p>--%>
<%--<br>--%>

<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Faculty Id</th>
        <th>Title</th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${faculties}" var="faculty">
        <tr>
            <td>${faculty.facultyId}</td>
            <td>${faculty.title}</td>
            <td>
                <security:authorize access="hasRole('ADMIN')">
                    <a href="<c:url value="/faculties/${faculty.facultyId}/edit"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>

                    <a href="<c:url value="/faculties/${faculty.facultyId}/delete"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>
                </security:authorize>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

