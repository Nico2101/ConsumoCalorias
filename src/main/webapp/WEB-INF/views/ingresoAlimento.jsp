<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="incluir/librerias.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cabecera.jsp"%>
<meta name="description"
	content="Restyling jQuery UI Widgets and Elements" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
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
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">





					<div class="nav-search" id="nav-search">


						<a class="btn btn-app btn-purple btn-xs "
							href="IngresoNuevoAlimento.htm"><i
							class="ace-icon glyphicon glyphicon-plus bigger-120"></i></a>

					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">

					<div class="page-header">
						<h1>Ingreso de Alimentos</h1>


					</div>
					<!-- /.page-header -->
					<div class="space-12"></div>



					<div class="row">
						<div class="col-xs-20" aling=center>
							<!-- PAGE CONTENT BEGINS -->


							<form:form method="post" commandName="formularioIngresoAlimento">
								<br>
								<div class="row">
									<div class="col-sm-4" align=center>
										<label>Alimento:</label>
									</div>
									<div class="col-xs-3">
										<form:select path="alimento">
											<form:option value="-1"  >--Seleccione Alimento---</form:option>
											<c:forEach items="${usuario.alimentos}" var="alimento">
												<form:option value="${alimento.id}">${alimento.nombre}</form:option>
											</c:forEach>
										</form:select>
									<form:errors path="alimento" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Porción:</label>
									</div>
									<div class="col-xs-3">
										<span class="block input-icon input-icon-right"> <form:input
												type="number" step="0.1" min="0" class="form-control" path="porcion"
												placeholder="Porción" />
										</span>
									<form:errors path="porcion" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Fecha:</label>
									</div>
									<div class="col-xs-3">
										<span class="block input-icon input-icon-right"> <form:input
												type="date" class="form-control" path="fecha"
												placeholder="AAAA-MM-DD" />
										</span>
										<form:errors path="fecha" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Tipo:</label>
									</div>
									<div class="col-xs-3">
										<form:select path="tipo">
											<form:option value="-1"  >--Seleccione Tipo---</form:option>
											<c:forEach items="${listaTipos}" var="tipo">
												<form:option value="${tipo.id}">${tipo.nombre}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="tipo" cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								
								<div class="row">
									<div class="col-s-12" align=center>
										<button type="submit" class="btn btn-success" value="Ingresar">Ingresar</button>
									</div>
								</div>
							</form:form>
						</div>
						<div class="vspace-12-sm"></div>

					</div>
					<!-- /.row -->

					<div class="hr hr32 hr-dotted"></div>

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


	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="assets/js/jquery-ui.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {

			//autocomplete
			var availableTags = [ "Leche", "Arroz con carne",
					"Tallarines con salsa Blanca", "Bebida", "Jugo", "Porotos",
					"Galleta", "Tomate", "Tallarines con salsa napolitana",
					"Sopa de pollo", "Sopa de Vacuno", "Lentejas",
					"Hamburguesa", "Papas Fritas (Bolsa)",
					"Papas Fritas caseras", "Ramitas", "Doritos",
					"Cereal integral", "Cereal Chocapic", "Lechuga", "Palta",
					"Mayo" ];
			$("#tags").autocomplete({
				source : availableTags
			});

			//custom autocomplete (category selection)
			$.widget("custom.catcomplete", $.ui.autocomplete, {
				_create : function() {
					this._super();
					this.widget().menu("option", "items",
							"> :not(.ui-autocomplete-category)");
				},
				_renderMenu : function(ul, items) {
					var that = this, currentCategory = "";
					$.each(items, function(index, item) {
						var li;
						if (item.category != currentCategory) {
							ul.append("<li class='ui-autocomplete-category'>"
									+ item.category + "</li>");
							currentCategory = item.category;
						}
						li = that._renderItemData(ul, item);
						if (item.category) {
							li.attr("aria-label", item.category + " : "
									+ item.label);
						}
					});
				}
			});

			var data = [ {
				label : "anders",
				category : ""
			}, {
				label : "andreas",
				category : ""
			}, {
				label : "antal",
				category : ""
			}, {
				label : "annhhx10",
				category : "Products"
			}, {
				label : "annk K12",
				category : "Products"
			}, {
				label : "annttop C13",
				category : "Products"
			}, {
				label : "anders andersson",
				category : "People"
			}, {
				label : "andreas andersson",
				category : "People"
			}, {
				label : "andreas johnson",
				category : "People"
			} ];
			$("#search").catcomplete({
				delay : 0,
				source : data
			});

		});
	</script>
</body>
</html>