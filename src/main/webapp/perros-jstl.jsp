<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1 class="text-center">Perros JSTL</h1>
<h2 class="text-center">Tenemos ${fn:length(perros)} perros en
	adopcion</h2>
<p>Mismo ejemplo para hacer CRUD usando taglibs y EL</p>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Foto</th>
			<th>Modificar</th>
			<th>Eliminar</th>
		</tr>
	</thead>
	<c:forEach items="${perros}" var="p">
		<li>${p.id}${p.nombre } <img src="${p.foto}"
			style="width: 100px; height: 100px;" alt="foto perro"> <span><a
				href="perros2?id=${p.id}&modificar=s">Modificar</a></span> <span><a
				href="perros2?id=${p.id}&eliminar=s">Eliminar</a></span>
		</li>
	</c:forEach>
</table>

<c:if test="${empty perroEditar}">

</c:if>

<c:if test="${not empty mensaje}">

	<p class="alert alert-success">${mensaje}</p>

</c:if>


<c:if test="${empty mensaje}">

	<p class="alert alert-success">No hay mensaje</p>

</c:if>

<%@include file="includes/footer.jsp"%>