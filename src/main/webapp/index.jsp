<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<main>


	<div class="placeholder d-flex align-items-center">


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
							type="password" name="pass" id="pass" required class="form-control" />
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
	<%-- <% --%>

	<!-- // 	out.print("<h1 class=\"text-center h1\">Soy index.jsp</h1>"); -->

	<%-- %> --%>



</main>




<%@include file="includes/footer.jsp"%>