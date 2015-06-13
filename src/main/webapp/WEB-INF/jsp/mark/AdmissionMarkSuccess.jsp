<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mark was added</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h1>Done!! Next mark was adding successfully.</h1>

    <h2>${msg}</h2>

    <p>
        <a href="<c:url value="/"/>" class="btn btn-primary">Back to main menu</a>
        <a href="<c:url value="/marks/newMark"/>" class="btn btn-primary">Add new mark</a>
        <a href="<c:url value="/marks/marksList"/>" class="btn btn-primary">Show all marks</a>
    </p>

</div>

</body>
</html>