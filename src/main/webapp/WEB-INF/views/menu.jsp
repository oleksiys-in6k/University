<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<ul class="nav nav-sidebar">
    <li class="active"><a href="/">Home<span class="sr-only">(current)</span></a></li>
    <li><a href="/faculties">Faculties</a></li>
    <li><a href="/students">Students</a></li>
    <li><a href="/courses">Courses</a></li>
    <security:authorize access="isAuthenticated()">

        <li><a href="/marks" class="list-group-item" contenteditable="false">Marks</a></li>
        <li>
            <a href="/bestStudent" class="list-group-item" contenteditable="false">Statistic</a>
        </li>
    </security:authorize>
</ul>

