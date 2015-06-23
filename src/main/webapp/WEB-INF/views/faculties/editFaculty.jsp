<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1> Edit faculty </h1>

    <form action="/faculties/edit/${faculty.facultyId}" method="post">

        <p>
            Enter new title for faculty ${faculty.title} : <input type="text" name="title"/>
        </p>

        <button type="submit" value=" Send" class="btn btn-success">
            Change title
        </button>
        <a href="<c:url value="/"/>" class="btn btn-primary">Cancel</a>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>
