<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="tab-header-area">
    <h1>Admission new teachers</h1>
</div>

<form action="/teachers/create" method="post">
    <p>
        Name : <input type="text" name="teacherName"/>
    </p>

    <p>
        Faculty :

        <label>
            <select name="teacherFaculty" items="${faculties}">
                <c:forEach items="${faculties}" var="faculty">
                    <option value="${faculty.facultyId}">${faculty.title}</option>
                </c:forEach>
            </select>
        </label>
    </p>
    <p>
        Login : <input type="text" name="login"/>
    </p>
    <p>
        Password : <input type="text" name="password"/>
    </p>

    <button type="submit" value=" Send" class="btn btn-success">
        Save new teacher
    </button>
    <a href="/teachers" class="btn btn-primary">Cancel</a>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>