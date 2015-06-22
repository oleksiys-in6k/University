<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="list-group  navbar" id="sidebar">
    <ul class="nav" id="mynav" data-spy="affix" data-offset-top="280">
        <li><a href="/" class="list-group-item active">Home</a></li>
        <li><a href="/faculties" class="list-group-item" contenteditable="false">Faculties</a></li>
        <li><a href="/students" class="list-group-item" contenteditable="false">Students</a></li>
        <li><a href="/courses" class="list-group-item" contenteditable="false">Courses</a></li>
    </ul>

    <br>
    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
    <ul class="nav nav-sidebar">
        <li><a href="/marks" class="list-group-item" contenteditable="false">Marks</a></li>
        <li>
            <a href="/bestStudent" class="list-group-item" contenteditable="false">Statistic</a>
        </li>
    </ul>
    </security:authorize>
</div>