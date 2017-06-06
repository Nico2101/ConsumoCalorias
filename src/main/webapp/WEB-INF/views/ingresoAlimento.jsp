<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="incluir/librerias.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="cabecera.jsp" %>
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<%@ include file="barraSuperior.jsp" %>
		</div>
		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>
			<%@ include file="barraLateral.jsp" %>

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>
			<div class="main-content">
				
<div class="main-content-inner">
	<div class="breadcrumbs ace-save-state" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-home home-icon"></i>
				<a href="#">Home</a>
			</li>
			<li class="active">Dashboard</li>
		</ul><!-- /.breadcrumb -->

		<div class="nav-search" id="nav-search">
			<form class="form-search">
				<span class="input-icon">
					<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
					<i class="ace-icon fa fa-search nav-search-icon"></i>
				</span>
			</form>
		</div><!-- /.nav-search -->
	</div>

	<div class="page-content">
		
		<div class="page-header">
			<h1>
				Ingreso Alimento 
			</h1>
		</div><!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
		
				<div class="row">
					</div>
					<form:form method="post" commandName="formularioIngresoAlimento">
					<br>
						<div class="row">
							<div class="col-xs-2"></div>
							<div class="col-xs-2" align=center>
								<label>Alimento:</label>
							</div>
							<div class="col-xs-3">
								<span class="block input-icon input-icon-right">
									<form:input type= "text" class="form-control" path="alimento"/>
								</span>
      							<form:errors path="alimento" cssClass="error"/>
							</div>
						</div>
						<br>
						<br>
						<div class="row">
							<div class="col-xs-1"></div>
							<div class="col-xs-1" align=center>
								<label>Porción:</label>
							</div>
							<div class="col-xs-2">
								<span class="block input-icon input-icon-right">
									<form:input type="number" step="0.1" class="form-control" path="porcion" placeholder="Porción"/>
								</span>
      							<form:errors path="porcion" cssClass="error"/>
							</div>
							
							<div class="col-xs-1" align=center>
								<label>Fecha:</label>
							</div>
							<div class="col-xs-2">
								<span class="block input-icon input-icon-right">
									<form:input type="date" class="form-control" path="fecha" placeholder="frfr"/>
								</span>
      							<form:errors path="fecha" cssClass="error"/>
							</div>
							<div class="col-xs-1" align=center>
								<label>Tipo:</label>
							</div>
							<div class="col-xs-2">
								<form:select path="tipo">
									<form:option value="NONE" label="Seleccione Tipo Alimento"/>
 									<form:options items="${tipoLista}" />
								</form:select>
      							<form:errors path="porcion" cssClass="error"/>
							</div>
						</div>
						<br>
						 <div class="padding" align=center>
                        	<button type="submit" class="btn btn-success" value="Ingresar">Ingresar</button>
                    	</div>
						</form:form>
					<div class="vspace-12-sm"></div>

				</div><!-- /.row -->

				<div class="hr hr32 hr-dotted"></div>

			<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<%@ include file="pieDePagina.jsp" %>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		
		<%@ include file="scripts.jsp" %>
	</body>
</html>