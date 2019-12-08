
<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<main class="container">
	
	<h1>Perros</h1>


	<%
		ArrayList<Perro> perros = (ArrayList<Perro>) request.getAttribute("perros");
	%>

	<section>

		<table class="table table-responsive table-bordered">
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

	</section>


	<hr>

	formulario

	<form action="perros" method="post">

		<input name="nombre" placeholder="nombre del bicho" required>

		<input type="submit" value="que vaaaaaaaaa">
	</form>

</main>
		
	





<%@include file="includes/footer.jsp"%>