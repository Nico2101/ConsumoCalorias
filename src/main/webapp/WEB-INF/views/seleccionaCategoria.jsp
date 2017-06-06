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
		<!--inicio-->		
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
								<span class="infobox-text">	Calorias XDDDDDDDDd</span>

								<div class="infobox-content">
									<span class="bigger-200"></span>
								
								</div>
							</div>
						</div>

						<div class="space-8"></div>

						 <p>
                                       
										<a href="#" class="btn btn-app btn-primary">
											<i class="ace-icon glyphicon glyphicon-tint bigger-230"></i>
											Lacteo
                                            
											
										</a>

										<a href="#" class="btn btn-app btn-success">
											<i class="ace-icon  glyphicon glyphicon-leaf bigger-230"></i>
											Verdura
										</a>
                                           

										<button class="btn btn-app btn-warning">
											<i class="ace-icon glyphicon glyphicon-grain bigger-230"></i>
											Cereal
										</button>
                                        <button class="btn btn-app btn-danger">
											<i class="ace-icon glyphicon glyphicon-apple bigger-230"></i>
											Fruta
										</button>
                                        
                                        </p>
                                        <p>
                                              <button class="btn btn-app btn-pink ">
											<i class="ace-icon glyphicon glyphicon-ice-lolly bigger-230"></i>
											Golosina
										</button>
                                            
                                        <button class="btn btn-app btn-danger">
											<i class="ace-icon glyphicon glyphicon-piggy-bank bigger-230"></i>
											Carne
										</button>
                                            
                                        <a href="#" class="btn btn-app btn-primary">
											<i class="ace-icon glyphicon glyphicon-tint bigger-230"></i>
											Bebida
                                        </a>
                                        
                                          
                                        <button class="btn btn-app btn-purple">
											<i class="ace-icon fa fa-undo bigger-230"></i>
											Pastas
										</button>
									
                                       
                                            </p>

					</div>

					<div class="vspace-12-sm"></div>

				</div><!-- /.row -->

				<div class="hr hr32 hr-dotted"></div>

				<div class="hr hr32 hr-dotted"></div>

			<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	
			</div><!-- /.main-content -->

			<div class="footer">
				<%@ include file="pieDePagina.jsp" %>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

	
	</body>
</html>
