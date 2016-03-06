<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="CURRENT_URL" value="${requestScope['javax.servlet.forward.servlet_path']}"/>
<nav>
  <div class="nav-wrapper">
    <a href="#" class="brand-logo">Home</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="<c:url value="/"/> ">Sass</a></li>
      <li><a href="<c:url value="/"/> ">Components</a></li>
      <li><a href="<c:url value="/"/> ">JavaScript</a></li>
      <li><a href="<c:url value="${CURRENT_URL}?lang=ru"/>">RU</a></li>
      <li><a href="<c:url value="${CURRENT_URL}?lang=en"/>">EN</a></li>
    </ul>
  </div>
</nav>

<%--<div id="searchLetters">
  <p><spring:message code="messages.letter"/></p>
  <ul></ul>
</div>

<script type="text/javascript">
  $.get( "getLetters", function( data ) {
    console.log(data);
    $.each(data, function (key, value){
      $( "#searchLetters").find("ul").append("<li>"+ value +"</li>")
    })
  });
</script>--%>
