
<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>


<%
	ArrayList<Perro> perros = (ArrayList<Perro>) request.getAttribute("perros");
%>

<main class="container">

	<h1 class="text-center my-2">Perros</h1>

	<section class="row">
		<article class="col-md-6 pt-4">
			<table id="listado" class="table table-responsive table-striped my-5">
				<thead>
					<tr>
						<th>#Id</th>
						<th>Nombre</th>
						<th>Foto</th>
						<th>Modificar</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Perro p : perros) {
							int id = (int) p.getId();
					%>

					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getNombre()%></td>
						<td><img src="<%=p.getFoto()%>"></td>
						<td><span><a
								href="perros?id=<%=p.getId()%>&modificar=s">Modificar</a></span></td>
						<td><span><a
								href="perros?id=<%=p.getId()%>&eliminar=s">Eliminar</a></span></td>

						<%
							}
						%>
					
				</tbody>
			</table>
		</article>

		<article class="col-md-6">
		<div class="card my-4 py-4">
		
			<%
				Perro perroEditar = (Perro) request.getAttribute("perroEditar");
				if (perroEditar == null) {
					perroEditar = new Perro();
				}
			%>
			<form action="perros" method="post">

				<input type="hidden" name="id" id="id"
					value="<%=perroEditar.getId()%>" class="form-control" />
				<div class="form-goup row mb-3">
					<div class="col col-md-6 offset-md-3">
						<label for="nombre" class="control-label">Nombre</label> <input
							type="text" name="nombre" id="nombre"
							value="<%=perroEditar.getNombre()%>" required
							class="form-control" />
					</div>
				</div>
				<div class="form-group row mb-3">
					<div class="col col-md-6 offset-md-3">
						<label for="foto" class="control-label">Foto </label> <input
							type="text" name="foto" id="foto"
							value="<%=perroEditar.getFoto()%>" class="form-control" />
					</div>
				</div>
				<br />
				<div class="form-group row mb-3">
					<div class="col col-md-6 offset-md-3">
						<input type="submit" value="Crear"
							class="form-control btn btn-outline-primary" />

					</div>
				</div>
			</form>
		<%
				String mensaje = (String) request.getAttribute("mensaje");
			%>
			<%if (mensaje != ""){ %>
			<p class="alert alert-info"><%=mensaje%></p>
			<%} %>
		
		</div>
			


		</article>
	</section>





</main>







<%@include file="includes/footer.jsp"%>