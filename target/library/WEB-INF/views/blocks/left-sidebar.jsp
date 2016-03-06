<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<aside id="left-column">

  <p><spring:message code="messages.genres"/></p>
  <ul id="genres-list"></ul>
  <script type="text/javascript">
    $.get( "getGenres", function( data ) {
      console.log(data);
      $.each(data, function (key, value){
        console.log(value);
        $("#genres-list").append("<li>"+ value.name +"</li>")
      })
    });
  </script>
</aside>