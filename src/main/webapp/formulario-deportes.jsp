<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


<h1>Formulario Deportes</h1>


<c:if test="${not empty mensaje}">
	<h4 style="color:red">${mensaje}</h4>
</c:if>

<form action="deportes" method="post">

	<input type="text" name="nombre" value="${nombre}" placeholder="Dime tu nombre">
	<br>
	
	<c:forEach items="${applicationScope.deportes}" var="dep">	
		<input type="checkbox" ${( fn:contains(deportesMarcados, dep.key) )?"checked":""} name="deportes" value="${dep.key}"> ${dep.value}<br>
	</c:forEach>
	
	<input type="submit" value="Registrar">

</form>



<%@include file="includes/footer.jsp" %>