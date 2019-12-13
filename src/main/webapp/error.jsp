<%@ page isErrorPage="true" %>  

<h1>Aprende a programar</h1>

<p>Causa <%=exception.getCause() %></p>
<p>Mensaje <%=exception.getMessage() %></p>

<pre>
	<!-- Stack trace -->
	<jsp:scriptlet>
	  exception.printStackTrace(new java.io.PrintWriter(out));
	</jsp:scriptlet>
</pre>