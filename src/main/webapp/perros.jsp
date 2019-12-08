
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
		<article class="col-md-6">
			<table class="table table-responsive table-striped">
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
							int id = (int)p.getId();
					%>
	
					<tr>
						<td><%=p.getId() %></td>
						<td><%=p.getNombre() %></td>
						<td> <img src="<%=p.getFoto()%>"></td>
						<td> <span><a href="perros?modificar=<%=p.getId()%>">Modificar</a></span></td>
						<td> <span><a href="perros?eliminar=<%=p.getId()%>">Eliminar</a></span></td>
	
					<%
						}
					%>
				</tbody>
			</table>
		</article>
	
		<article class="col-md-6">
			<form action="perros" method="post">
		
				<div class="form-goup row mb-3">
					<div class="col col-md-6 offset-md-3">
						<label for="nombre" class="control-label">Nombre</label> <input
							type="text" name="nombre" id="nombre" required class="form-control" />
					</div>
				</div>
				<div class="form-group row mb-3">
					<div class="col col-md-6 offset-md-3">
						<label for="foto" class="control-label">Foto </label> <input
							type="text" name="foto" id="foto"
							class="form-control" />
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
			
		
		</article>
	</section>



	

</main>
		
	





<%@include file="includes/footer.jsp"%>