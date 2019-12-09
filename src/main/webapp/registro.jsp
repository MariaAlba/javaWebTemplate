<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>
<main>
	<div class="row justify-content-center">
		<div class="col-md-6">
			<form action="usuarios" method="POST" class="card">
				
				<input type="text" name="nombre" id="nombre" />
				<input type="password" name="password" id="password" />
				<input type="text" name="github" id="github" />
				<input type="text" name="imagen" id="imagen" />
				
			
			</form>
		</div>
	</div>
</main>
<%@include file="includes/footer.jsp"%>