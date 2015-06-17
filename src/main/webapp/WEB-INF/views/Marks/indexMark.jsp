<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
  <div class="col-md-10">
    <div class="tab-header-area">
      <h1>List of marks</h1>
    </div>

  </div>
  <div class="col-md-2">
    <a href="/marks/new" class="glyphicon glyphicon-plus btn-lg">Add mark</a>
  </div>
</div>


<table class="table table-striped table-bordered">
  <thead>
  <tr>
    <th>Mark Id</th>
    <th>Student</th>
    <th>Course</th>
    <th>Mark</th>
    <th></th>

  </tr>
  </thead>
  <tbody>

  <c:forEach items="${marks}" var="mark">
    <tr>
      <td>${mark.markId}</td>
      <td>${mark.student.name}</td>
      <td>${mark.course.title}</td>
      <td>${mark.rating}</td>
      <td>
        <a href="<c:url value="/marks/${mark.markId}/delete"/>"
           class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
        </a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>