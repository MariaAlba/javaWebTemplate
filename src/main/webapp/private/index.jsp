<%@include file="/includes/header.jsp"%>
<%@include file="/includes/navigation.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<main>
soy indexjsp con atributo 

<p>${atributoServlet }</p>

<div class="row">
<div class="col-md-12">
	<p class="text-center">Usuarios Logeados</p>
</div>
<div class="col-md-12">
				<ul>

					<c:forEach items="${usuariosConectados}" var="u">
						<li><img src="${u.imagen }" alt="avatar de usuario"
							width="48" height="48" /> ${u.nombre }</li>
					</c:forEach>

				</ul>

			</div>
</div>


</main>



<%@include file="/includes/footer.jsp"%>