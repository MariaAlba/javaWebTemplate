<header class="bg-info">

	<nav class="container navbar navbar-expand-xl navbar-dark">

		<a class="navbar-brand" href="index.jsp">PerrosApp</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample06" aria-controls="navbarsExample06"
			aria-expanded="true" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="navbar-collapse collapse show" id="navbarsExample06">

			<ul class="navbar-nav xl-text-right ml-auto">
				
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">Inicio <span class="sr-only">(current)</span></a>					
				</li>
				
				<li class="nav-item active"><a class="nav-link" href="perros">Perros</a></li>

				<li class="nav-item active dropdown">
				
					<!-- si no login  -->
<!-- 					<a class="nav-link dropdown-toggle" href="http://example.com" -->
<!-- 						id="dropdown06" data-toggle="dropdown" aria-haspopup="true" -->
<!-- 						aria-expanded="false">Log in</a> -->
					<!-- si login -->
					<a class="nav-link dropdown-toggle" href="http://example.com"
						id="dropdown06" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
						<span class="mr-2">Usuario</span>
						<img src="images/avatar.png" alt="avatar" id="avatar" class="rounded-circle"/>
						</a>
					<div class="dropdown-menu" aria-labelledby="dropdown06">
						<a class="dropdown-item" href="#">Perfil</a> <a
							class="dropdown-item" href="#">Configuración</a> <a
							class="dropdown-item" href="#">Log out</a>
					</div>
				</li>

			</ul>



		</div>


	</nav>


</header>

