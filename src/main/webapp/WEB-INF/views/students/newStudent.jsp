<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="tab-header-area">
    <h1>Admission new student</h1>
</div>

<form action="/students/create" method="post">
    <p>
        Name : <input type="text" name="studentName"/>
    </p>

    <p>
        Faculty :

        <label>
            <select name="studentFaculty" items="${faculties}">
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
        Save new student
    </button>
    <a href="/students" class="btn btn-primary">Cancel</a>
</form>