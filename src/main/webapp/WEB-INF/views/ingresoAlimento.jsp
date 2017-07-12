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
					<div class="nav-search " id="nav-search">
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
					<div class="page-header">
						<c:if test="${alimentoAgregado}">
							<div class="alert alert-success" role="alert">Alimento
								ingresado correctamente a su consumo diario</div>

						</c:if>


					</div>

					<!-- /.page-header -->
					<div class="space-12"></div>
					<div class="row">
						<div class="col-xs-20" aling=center>
							<!-- PAGE CONTENT BEGINS -->



							<form:form method="post" commandName="formularioIngresoAlimento">



								<div class="space-12"></div>
								<br>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Tipo:</label>
									</div>
									<div class="col-xs-3">
										<form:select path="tipo" multiple=""
											class="chosen-select form-control" id="form-field-select-4">
											<form:option value="-1">--Seleccione Tipo---</form:option>
											<c:forEach items="${listaTipos}" var="tipo">
												<form:option value="${tipo.id}">${tipo.nombre}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="tipo"
											cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-sm-4" align=center>
										<label>Alimento:</label>
									</div>

									<div class="col-xs-3">
										<form:select path="alimento" multiple=""
											class="chosen-select form-control" id="form-field-select-4">
											<form:option value="-1">--Seleccione Alimento---</form:option>
											<c:forEach items="${listaAlimentos}" var="alimento">
												<form:option value="${alimento.id}">${alimento.nombre} (${alimento.cantidad}-${alimento.medida})</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="alimento"
											cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-xs-4" align=center>
										<label>Porción:</label>
									</div>
									<div class="col-xs-3">
										<span class="block input-icon input-icon-right"> <form:input
												type="number" step="0.1" min="0" class="form-control"
												path="porcion" placeholder="Porción" />
										</span>
										<form:errors path="porcion"
											cssClass="btn btn-danger btn-sm popover-error" />
									</div>
								</div>
								<div class="space-4"></div>
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
					<div class="row">
					<div class="col-xs-12" aling=right>
						<div class="alert alert-info" align=center role="alert">Usted
							a consumido ${sumaCalorias} calorias el dia de hoy</div>
					</div>
					</div>
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
	<script src="assets/js/select2.min.js"></script>


	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/chosen.jquery.min.js"></script>
	<script src="assets/js/spinbox.min.js"></script>
	<script src="assets/js/bootstrap-datepicker.min.js"></script>
	<script src="assets/js/bootstrap-timepicker.min.js"></script>
	<script src="assets/js/moment.min.js"></script>
	<script src="assets/js/daterangepicker.min.js"></script>
	<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
	<script src="assets/js/bootstrap-colorpicker.min.js"></script>
	<script src="assets/js/jquery.knob.min.js"></script>
	<script src="assets/js/autosize.min.js"></script>
	<script src="assets/js/jquery.inputlimiter.min.js"></script>
	<script src="assets/js/jquery.maskedinput.min.js"></script>
	<script src="assets/js/bootstrap-tag.min.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>




	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			if (!ace.vars['touch']) {
				$('.chosen-select').chosen({
					allow_single_deselect : true
				});
				//resize the chosen on window resize

				$(window).off('resize.chosen').on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						var $this = $(this);
						$this.next().css({
							'width' : $this.parent().width()
						});
					})
				}).trigger('resize.chosen');
				//resize chosen on sidebar collapse/expand
				$(document).on('settings.ace.chosen',
						function(e, event_name, event_val) {
							if (event_name != 'sidebar_collapsed')
								return;
							$('.chosen-select').each(function() {
								var $this = $(this);
								$this.next().css({
									'width' : $this.parent().width()
								});
							})
						});

				$('#chosen-multiple-style .btn').on(
						'click',
						function(e) {
							var target = $(this).find('input[type=radio]');
							var which = parseInt(target.val());
							if (which == 2)
								$('#form-field-select-4').addClass(
										'tag-input-style');
							else
								$('#form-field-select-4').removeClass(
										'tag-input-style');
						});
			}

			//select2
			$('.select2').css('width', '200px').select2({
				allowClear : true
			})
			$('#select2-multiple-style .btn').on('click', function(e) {
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				if (which == 2)
					$('.select2').addClass('tag-input-style');
				else
					$('.select2').removeClass('tag-input-style');
			});

			//////////////////
			$('.multiselect')
					.multiselect(
							{
								enableFiltering : true,
								enableHTML : true,
								buttonClass : 'btn btn-white btn-primary',
								templates : {
									button : '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"><span class="multiselect-selected-text"></span> &nbsp;<b class="fa fa-caret-down"></b></button>',
									ul : '<ul class="multiselect-container dropdown-menu"></ul>',
									filter : '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
									filterClearBtn : '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
									li : '<li><a tabindex="0"><label></label></a></li>',
									divider : '<li class="multiselect-item divider"></li>',
									liGroup : '<li class="multiselect-item multiselect-group"><label></label></li>'
								}
							});

			///////////////////

			//typeahead.js
			//example taken from plugin's page at: https://twitter.github.io/typeahead.js/examples/
			var substringMatcher = function(strs) {
				return function findMatches(q, cb) {
					var matches, substringRegex;

					// an array that will be populated with substring matches
					matches = [];

					// regex used to determine if a string contains the substring `q`
					substrRegex = new RegExp(q, 'i');

					// iterate through the pool of strings and for any string that
					// contains the substring `q`, add it to the `matches` array
					$.each(strs, function(i, str) {
						if (substrRegex.test(str)) {
							// the typeahead jQuery plugin expects suggestions to a
							// JavaScript object, refer to typeahead docs for more info
							matches.push({
								value : str
							});
						}
					});

					cb(matches);
				}
			}

			$('input.typeahead').typeahead({
				hint : true,
				highlight : true,
				minLength : 1
			}, {
				name : 'states',
				displayKey : 'value',
				source : substringMatcher(ace.vars['US_STATES']),
				limit : 10
			});

			///////////////

			//in ajax mode, remove remaining elements before leaving page
			$(document).one(
					'ajaxloadstart.page',
					function(e) {
						$('[class*=select2]').remove();
						$('select[name="duallistbox_demo1[]"]')
								.bootstrapDualListbox('destroy');
						$('.rating').raty('destroy');
						$('.multiselect').multiselect('destroy');
					});

		});
	</script>
</body>
</html>