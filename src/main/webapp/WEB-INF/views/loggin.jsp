<%@ include file="/WEB-INF/views/incluir/librerias.jsp" %>
<html>
<style>
   .error { color: red; }
 </style>
<body>
<h2>Hola soy un loggin (models and views)</h2>

<form:form method="post" commandName="formularioLoggin">
  <table >
    <tr>
      <td align="right" width="20%">Correo:</td>
        <td width="20%">
          <form:input path="correo"/>
        </td>
        <td width="60%">
          <form:errors path="correo" cssClass="error"/>
        </td>
    </tr>
    <tr>
    	<td align="right" width="20%">Clave:</td>
        <td width="20%">
          <form:password path="clave"/>
        </td>
        <td width="60%">
          <form:errors path="clave" cssClass="error"/>
        </td>
    </tr>
    
  </table>
  <span class="error">${usuarioNoEncontrado}</span>
  <br>
  <input type="submit" value="Ingresar">
</form:form>


</body>
</html>