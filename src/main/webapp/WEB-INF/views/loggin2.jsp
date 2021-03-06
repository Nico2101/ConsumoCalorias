<%@ include file="/WEB-INF/views/incluir/librerias.jsp"%>

<!DOCTYPE html>
<html lang="en">
<style>
.error {
	color: red;
}
</style>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Bienvenido a Nutrición y Vida Saludable.</title>

<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon glyphicon glyphicon-apple red"></i> <span
									class="white" id="id-text2">Nutrición y vida saludable</span>
							</h1>

						</div>

						<div class="space-6"></div>


						<div id="login-box" class="login-box visible widget-box no-border">
							<div class="widget-body">
								<div class="widget-main">
									<h4 class="header blue lighter bigger">
										<i class="ace-icon fa fa-coffee green"></i> Ingrese su
										información
									</h4>

									<div class="space-6"></div>

									<form:form method="post" commandName="formularioLoggin">
										<fieldset>
											<label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <form:input
														type="text" class="form-control" path="correo" placeholder="Ingrese su correo"/> 
														<i class="ace-icon fa fa-user" ></i>

											</span>
											</label>
											<form:errors path="correo" cssClass="btn btn-danger btn-sm popover-error" />

											<label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <form:password
														class="form-control" path="clave"  placeholder="Ingrese su contraseña"/> 
														<i class="ace-icon fa fa-lock"></i>

											</span>
												<form:errors path="clave"
														cssClass="btn btn-danger btn-sm popover-error" />
											</label>

											<div class="space"></div>

											<div class="clearfix">
												<label class="inline"> <input type="checkbox"
													class="ace" />

												</label> 
												<c:if test="${usuarioNoEncontrado}">
													<span class="btn btn-danger btn-sm popover-error">El usuario no fue encontrado. </span>
												</c:if>
												<button type="submit"
													class="width-35 pull-right btn btn-sm btn-primary"
													value="Ingresar">
													<i class="ace-icon fa fa-key"></i> <span class="bigger-110">Ingresar</span>
												</button>
											</div>

											<div class="space-2"></div>
										</fieldset>
									</form:form>

									<div class="social-or-login center"></div>

									<div class="space-2"></div>

									<div class="social-login center"></div>
								</div>
								<!-- /.widget-main -->

								<div class="toolbar clearfix">
									<div></div>

									<div>
										<a href="registro.htm"   class="user-signup-link">
											Registrarse <i class="ace-icon fa fa-arrow-right"></i>
										</a>
									
									</div>
								</div>
							</div>
							<!-- /.widget-body -->
						</div>
						<!-- /.login-box -->

						<div id="forgot-box" class="forgot-box widget-box no-border">
							<div class="widget-body">
								<div class="widget-main">
									<h4 class="header red lighter bigger">
										<i class="ace-icon fa fa-key"></i> Retrieve Password
									</h4>

									<div class="space-6"></div>
									<p>Enter your email and to receive instructions</p>

									<form>
										<fieldset>
											<label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <input
													type="email" class="form-control" placeholder="Email" /> <i
													class="ace-icon fa fa-envelope"></i>
											</span>
											</label>

											<div class="clearfix">
												<button type="button"
													class="width-35 pull-right btn btn-sm btn-danger">
													<i class="ace-icon fa fa-lightbulb-o"></i> <span
														class="bigger-110">Send Me!</span>
												</button>
											</div>
										</fieldset>
									</form>
								</div>
								<!-- /.widget-main -->

								<div class="toolbar center">
									<a href="#" data-target="#login-box" class="back-to-login-link">
										Back to login <i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</div>
							</div>
							<!-- /.widget-body -->
						</div>
						<!-- /.forgot-box -->

						
					</div>
					<!-- /.position-relative -->

					<div class="navbar-fixed-top align-right">
						<br />

					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.main-content -->
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			
			
			//you don't need this, just used for changing background
			jQuery(function($) {
			 $('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');
				
				e.preventDefault();
			 });
			 
			});
		</script>
</body>
</html>
