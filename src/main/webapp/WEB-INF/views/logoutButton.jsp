<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h4>
        Welcome : ${pageContext.request.userPrincipal.name} |
        <a href="javascript:formSubmit()"> Logout</a>
    </h4>
</c:if>

<%--logout!!--%>
<%--${pageContext.request.logout()}--%>
