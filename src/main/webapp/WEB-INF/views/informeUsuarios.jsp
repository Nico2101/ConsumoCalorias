<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="incluir/librerias.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cabecera.jsp"%>
<!-- HTML meta refresh URL redirection -->
<script>
	function ejecutar(){
		var valor = $("#informe").html();
		$("#contenido").val(valor);
	}
</script>
</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default          ace-save-state">
		<%@ include file="barraSuperior.jsp"%>
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<div id="sidebar"
			class="sidebar                  responsive                    ace-save-state">
			<script type="javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

			<%@ include file="barraLateralAdministrador.jsp"%>

			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon"
					class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		<div class="main-content">
			<!--inicio contenido-->
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">


					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Buscar ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">

					<div class="page-header"></div>
					<!-- /.page-header -->

					<div class="row">
								<div class="space-6"></div>
								<div class="col-sm-10 infobox-container" id="informe">
										<h1 align="center"><u>Informe de uso de plataforma</u></h1>
										<br></br>
										<table id="informeUsuario" class="table  table-bordered table-hover" border="1">
											<thead>
												<tr>
													<th align="center" class="lead" style="width:30%"><b>Total Usuarios</b></th>
													<th align="center" class="lead" style="width:30%"><b>${ totalUsuarios}</b></th>
												</tr>
												
												<tr>
													<th  class="lead" style="width:30%"><b>Nombre</b></th>
													<th  class="lead" style="width:30%"><b>Apellido</b></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${datosUsuario}" var="valores">
													<tr>
														<td class="lead">${valores[0]}</td>
														<td  class="lead">${valores[1]}</td>
														
													</tr>
												</c:forEach>
												
											</tbody>
											
										</table>
								</div>
								
								<form:form method="post" commandName="htmlInformeTotalUsuarios" action="generarPDFTotalUsuarios.htm">
										<form:textarea path="contenido" id="contenido" cssClass="hidden"></form:textarea>
										<button type="submit" class="btn btn-danger" id="enviar" onclick="ejecutar();">Generar PDF</button>
									</form:form>
								
							</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<div class="footer">
			<%@ include file="pieDePagina.jsp"%>
		</div>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->



	<%@ include file="scripts.jsp"%>
</body>

</html>