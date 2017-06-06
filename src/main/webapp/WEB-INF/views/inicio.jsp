<%@ include file="/WEB-INF/views/incluir/librerias.jsp" %>
<html>
<body>
<h1>Si estas viendo esto, es porque ingresaste correctamente al loggin</h1>

<ul>
	<li>Cambios generales version 1</li>
	<li>Cambios generales version 2</li>
	<li>Regreso a version 1</li>
	<li>Agregar metodo redireccionarLoggin</li>
	<li>Extension de htm a htm</li>
	<li>Cambiar el nombre a la clase</li>
	<li>Redireccion automatica</li>
	<li>${variable}</li>
	<li>${arreglo[0]}</li>
	<li>${arreglo[1]}</li>
	<li>${arreglo[2]}</li>
	<c:forEach items="${lista}" var="item">
		<li>${item}</li>
	</c:forEach>
	<li>Simplificando redireccionamiento editando app-config</li>
	<li><fmt:message key="prueba"/></li>
	<li>Agregando formulario</li>
	<li><a href="loggin.htm">Ir al loggin</a></li>
	
</ul>


<h2>Datos del usuario</h2>

	Id: ${usuario.id} </br>
	Nombre: ${usuario.nombre} ${usuario.apellido}</br>
	Correo: ${usuario.correo}</br>
	Lista de alimentos: <c:out value="${usuario.alimentos.size()}"/> alimentos en la lista </br>
	<ul>
		<c:forEach items="${usuario.alimentos}" var="alimento">
			Id: ${alimento.id} </br>
			Nombre: ${alimento.nombre}</br>
		</c:forEach>
	</ul>
</body>
</html>