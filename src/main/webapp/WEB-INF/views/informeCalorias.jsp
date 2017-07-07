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

			<%@ include file="barraLateral.jsp"%>

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
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->


							<div class="row">
								<div class="space-6"></div>
								<div class="col-sm-10 infobox-container" id="informe">
										<h1 align="center">Informe acerca del consumo de calorias</h1>
										
										<p align="center" class="lead">${cabecera}</p>
										<hr>
										<table id="simple-table" class="table  table-bordered table-hover" border="1">
											<thead>
												<tr>
													<th class="lead">Categoría</th>
													<th class="lead">Promedio calorías</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${promedioConsumoPorCategoria}" var="valores">
													<tr>
														<td class="lead">${valores[0]}</td>
														<td class="lead">${valores[1]}</td>
													</tr>
												</c:forEach>
												
											</tbody>
											<thead>
												<tr>
													<th class="lead">Promedio total:</th>
													<th class="lead">${promedioTotal}</th>
												</tr>
											</thead>
										</table>
								</div>
									<form:form method="post" commandName="htmlInforme" action="generarPDF.htm">
										<form:textarea path="contenido" id="contenido" cssClass="hidden"></form:textarea>
										<button type="submit" class="btn btn-danger" id="enviar" onclick="ejecutar();">Generar PDF</button>
									</form:form>
								
							</div>
							<!-- /.row -->
							<!-- PAGE CONTENT ENDS -->
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
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