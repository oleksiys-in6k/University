<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="tab-header-area">
    <h1>Admission new course</h1>
</div>

<form action="/courses/create" method="post">
    <p>
        Title : <input type="text" name="title"/>
    </p>

    <p>
        Faculty :

        <label>
            <select name="courseFaculty" items="${faculties}">
                <c:forEach items="${faculties}" var="faculty">
                    <option value="${faculty.facultyId}">${faculty.title}</option>
                </c:forEach>
            </select>
        </label>
    </p>

    <button type="submit" value=" Send" class="btn btn-success">
        Save new course
    </button>
    <a href="/courses" class="btn btn-primary">Cancel</a>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>