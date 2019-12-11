<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Indicamos una una directiva, que en caso de error tiene que ir a la pagian de error indicada  -->
<%@ page errorPage="error.jsp"%>

<main>

	<%
		// descomentar estas lineas para que lance un error
		// Object o = null;
		// o.toString();
	%>


	<div class="placeholder d-flex align-items-center">

		<%
			//atributo
			String mensaje = (String) request.getAttribute("mensaje");

			//si no viene como atributo, intentamos de la request
			if (mensaje == null) {
				mensaje = request.getParameter("mensaje");
			}

			if (mensaje != null) {
		%>
		<p style="color: red"><%=mensaje%></p>
		<%
			}
		%>


		<div class="container card py-3 ">

			<h1 class="text-center h1 m-3">Bienvenido</h1>

			<hr class="hr" />

			<form action="login" method="post" class="my-5">

				<div class="form-goup row mb-3">
					<div class="col col-md-6 offset-md-3">
						<label for="" class="control-label">Nombre</label> <input
							type="text" name="user" id="user" required class="form-control" />
					</div>
				</div>
				<div class="form-group row mb-3">
					<div class="col col-md-6 offset-md-3">
						<label for="" class="control-label">Contraseña </label> <input
							type="password" name="pass" id="pass" required
							class="form-control" />
					</div>
				</div>
				<br />
				<div class="form-group row mb-3">
					<div class="col col-md-6 offset-md-3">
						<input type="submit" value="Entrar"
							class="form-control btn btn-outline-info" />

					</div>
				</div>
			</form>


		</div>








	</div>
</main>







<%@include file="includes/footer.jsp"%>