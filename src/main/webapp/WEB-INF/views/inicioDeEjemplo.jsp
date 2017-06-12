<%@ include file="/WEB-INF/views/incluir/librerias.jsp" %>
<html>
<body>
<h1>Si estas viendo esto, es porque ingresaste correctamente al loggin</h1>




<h2>Datos del usuario</h2>
<p>
	Id: ${usuario.id} </br>
	Nombre: ${usuario.nombre} ${usuario.apellido}</br>
	Correo: ${usuario.correo}</br>
</p>	
</body>
</html>