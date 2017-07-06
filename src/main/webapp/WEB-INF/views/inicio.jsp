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
								<div class="col-sm-10 infobox-container">
									<div class="infobox infobox-blue2">
										<div class="infobox-progress">
											<div class="easy-pie-chart percentage" data-percent="65"
												data-size="${porcentajeCalorias}">
												<span class="percent">${porcentajeCalorias}</span>%
											</div>
										</div>

										<div class="infobox-data">
											<span class="infobox-text"> Calorias ${sumaCalorias}</span>

											<div class="infobox-content">
												<span class="bigger-200"></span>

											</div>
										</div>
									</div>

									<div class="space-8"></div>

									<a href="ingresoAlimento.htm" class="btn btn-app btn-primary">
										<i class="ace-icon glyphicon glyphicon-apple bigger-230"></i>
										Desayuno

									</a> <a href="ingresoAlimento.htm" class="btn btn-app btn-success">
										<i class="ace-icon glyphicon glyphicon-leaf bigger-230"></i>
										Almuerzo
									</a> <a href="ingresoAlimento.htm" class="btn btn-app btn-warning">
										<i class="ace-icon glyphicon glyphicon-piggy-bank bigger-230"></i>
										Cena
									</a> <a href="ingresoAlimento.htm" class="btn btn-app btn-danger">
										<i class="ace-icon glyphicon glyphicon-ice-lolly bigger-230"></i>
										Colaci�n
									</a>
								</div>
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