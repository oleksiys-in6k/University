<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1> Mark admission </h1>

    <form action="/marks/create" method="post">

        <p>
            Choose student :
            <label>
                <select name="markStudent" items="${students}">
                    <c:forEach items="${students}" var="student">
                        <option value="${student.studentId}">${student.name}</option>
                    </c:forEach>
                </select>
            </label>
        </p>

        <p>
            Choose course :
            <label>
                <select name="markCourse" items="${courses}">
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.courseId}">${course.title}</option>
                    </c:forEach>
                </select>
            </label>
        </p>

        <p>
            Mark is : <input type="text" name="rating"/>
        </p>

        <button type="submit" class="btn btn-success">
            Add new mark
        </button>
        <a href="/marks" class="btn btn-primary">Cancel</a>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>


