<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>PerrosApp</title>

<!-- la base para construir todas las rutas de esta pagina -->
<base href="${pageContext.request.contextPath}/" />

<!-- favicon -->
<link rel="icon" href="images/favicon.png" sizes="16x16"
	type="image/png">

<!--  fontawesome  -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!-- datatables responsive -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.20/b-1.6.1/r-2.2.3/datatables.min.css" />

<!-- fuentes google -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans&display=swap"
	rel="stylesheet">

<!-- estilos principal-->
<link rel="stylesheet"
	href="css/custom.css?time=<%=System.currentTimeMillis()%>">

</head>

<body id="#top">