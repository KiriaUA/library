<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC TEST</title>
    <jsp:include page="static_resources.jsp"/>
</head>
<body>
<div class="card-panel teal lighten-2">
    <c:forEach items="${books}" var="m">
        <p>${m.name}</p>
    </c:forEach>
</div>
</body>
</html>
