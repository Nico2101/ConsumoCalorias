<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="incluir/librerias.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cabecera.jsp"%>
<!-- HTML meta refresh URL redirection -->

</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default ace-save-state">
		<%@ include file="barraSuperior.jsp"%>
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
try{ace.settings.loadState('main-container')}catch(e){}
</script>

		<div id="sidebar" class="sidebar responsive ace-save-state">
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
			<div class="main-content-inner">


				<div class="page-content">


					<div class="page-header">
						<h1>Ingresar Nuevo Alimento</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-20">
							<!-- PAGE CONTENT BEGINS -->

							<form:form method="post" commandName="formularioIngresoNuevoAlimento">
								<div class="row">

									<div class="col-xs-4" align=center>
										<label>Categoria:</label>
									</div>
									<div class="col-xs-3">
										<form:select path="categoria">
											<form:option value="-1"  >--Seleccione Categoria---</form:option>
											<c:forEach items="${listaCategorias}" var="categoria">
												<form:option value="${categoria.id}">${categoria.nombre}</form:option>
											</c:forEach>
										</form:select>
										<br>
										<form:errors path="categoria" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Nombre:</label>
									</div>
									<div class="col-xs-3">
										<span class="block input-icon input-icon-right"> <form:input
												type="text" cssClass="form-control" path="nombre"
												placeholder="Nombre" />
										</span>
										<br>
										<form:errors path="nombre" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Cantidad:</label>
									</div>
									<div class="col-xs-3">
										<span class="block input-icon input-icon-right"> <form:input
												type="number" step="0.1" min="0" cssClass="form-control" path="cantidad"
												placeholder="Cantidad" />
										</span>
										<br>
										<form:errors path="cantidad" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Medida:</label>
									</div>
									<div class="col-xs-3">
										<form:select path="medida">
											<form:option value="">Seleccione</form:option>
											<form:option value="ml">Mil�gramos</form:option>
											<form:option value="gr">Gramos</form:option>
										</form:select>
										<br>
										<form:errors path="medida" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Calor�as:</label>
									</div>
									<div class="col-xs-3">
										<span class="block input-icon input-icon-right"> <form:input
												type="number" step="1" min="0" cssClass="form-control" path="calorias"
												placeholder="Calorias" />
										</span>
										<br>
										<form:errors path="calorias" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-s-12" align=center>
										<button type="submit" class="btn btn-success" value="Ingresar">Ingresar</button>
									</div>
								</div>
							</form:form>
							<br> <br>
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