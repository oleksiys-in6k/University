<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1> Edit student </h1>

<form action="/students/edit/${student.studentId}" method="post">

    <p>
        Name for student "${student.name}" : <input type="text" name="name"/>
    </p>

    <p>
        Choose faculty (current ${student.faculty.title}) :

        <label>
            <select name="facultyId" items="${faculties}">
                <c:forEach items="${faculties}" var="faculty">
                    <option value="${faculty.facultyId}">${faculty.title}</option>
                </c:forEach>
            </select>
        </label>
    </p>

    <button type="submit" value=" Send" class="btn btn-success">
        Submit changes
    </button>

    <a href="/students" class="btn btn-primary">Cancel</a>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>
