<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="incluir/librerias.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="incluir/cabecera.jsp" %>
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<%@ include file="incluir/barraSuperior.jsp" %>
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

			<%@ include file="incluir/barraLateral.jsp" %>

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				Dashboard
				<small>
					<i class="ace-icon fa fa-angle-double-right"></i>
					overview &amp; stats
				</small>
			</h1>
		</div><!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
			

				<div class="row">
					<div class="space-6"></div>
                             	<div class="col-sm-7 infobox-container">
					<div class="infobox infobox-blue2">
							<div class="infobox-progress">
								<div class="easy-pie-chart percentage" data-percent="88" data-size="40">
									<span class="percent">42</span>%
								</div>
							</div>

							<div class="infobox-data">
								<span class="infobox-text">	Calorias 43242</span>

								<div class="infobox-content">
									<span class="bigger-200"></span>
								
								</div>
							</div>
						</div>

						<div class="space-8"></div>
<form:form method="post" commandName="catDesayuno">
									
<input class="btn btn-app btn-primary" type="submit" value="Desayuno"><i class="ace-icon fa fa-pencil-square-o bigger-230"></i>
				
</form:form>
					</div>

					<div class="vspace-12-sm"></div>

				</div><!-- /.row -->

				<div class="hr hr32 hr-dotted"></div>

				<div class="hr hr32 hr-dotted"></div>

			<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<%@ include file="incluir/pieDePagina.jsp" %>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		
		<%@ include file="incluir/scripts.jsp" %>
	</body>
</html>