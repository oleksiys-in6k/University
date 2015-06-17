<div class="col-lg-10">

    <div class="page-header">
        <h1>List of faculties</h1>
    </div>
    <p>
        <a href="/faculties/new" class="btn btn-primary">Add faculty</a>
    </p>
    <br>

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

                    <a href="<c:url value="/faculties/${faculty.facultyId}/edit"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>

                    <a href="<c:url value="/faculties/${faculty.facultyId}/delete"/>" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
