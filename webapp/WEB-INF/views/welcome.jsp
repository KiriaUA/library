<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Library online</title>
  <jsp:include page="static_resources.jsp"/>
</head>
<body>
<jsp:include page="blocks/navigation.jsp"/>

<div class="content">

  <jsp:include page="blocks/left-sidebar.jsp"/>

  <p>test interceptor</p>
  <p>${letters}</p>

    <div class="card-panel teal lighten-2">
      <c:forEach items="${books}" var="m">
        <p>${m.name}</p>
      </c:forEach>
    </div>

    <div class="card-panel teal lighten-1">
      <c:forEach items="${author}" var="a">
        <p>${a.name}</p>
      </c:forEach>
    </div>

</div>
</body>
</html>
