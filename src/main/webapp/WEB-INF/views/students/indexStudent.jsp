<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-md-10">
        <div class="tab-header-area">
            <h1>List of students</h1>
        </div>

    </div>
    <div class="col-md-2">
        <a href="/students/new" class="glyphicon glyphicon-plus btn-lg">Add student</a>
    </div>
</div>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Student Id</th>
            <th>Title</th>
            <th>Faculty</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.studentId}</td>
                <td>${student.name}</td>
                <td>${student.faculty.title}</td>
                <td>

                    <a href="<c:url value="/students/${student.studentId}/edit"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>

                    <a href="<c:url value="/students/${student.studentId}/delete"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

