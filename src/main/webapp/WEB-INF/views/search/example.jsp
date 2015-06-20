<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script language="JavaScript" type="text/javascript" src="code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="code.jquery.com/jquery-1.10.2.js"></script>

<%--<script src="${pageContext.request.contextPath}/resources/core/jquery.1.10.2.min.js" type="text/javascript"></script>--%>

<%--<script src="${pageContext.request.contextPath}/resources/core/jquery.autocomplete.min.js" type="text/javascript"></script>--%>

<h2>Spring MVC + jQuery + Autocomplete example</h2>

<div>
    <input type="text" id="w-input-search" value="">
		<span>
			<button id="w-button-search" type="button">Search</button>
		</span>
</div>

<script>
    $(document).ready(function () {

        $('#w-input-search').autocomplete({
            serviceUrl: '${pageContext.request.contextPath}/getTags',
            paramName: "tagName",
            delimiter: ",",
            transformResult: function (response) {
                return {
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return {value: item.tagName, data: item.id};
                    })
                };
            }
        });
    });
</script>
