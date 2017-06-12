<%@ include file="/WEB-INF/views/incluir/librerias.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Ingresar Nuevo Alimento</title>

    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="assets/css/bootstrap-duallistbox.min.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-multiselect.min.css" />
    <link rel="stylesheet" href="assets/css/select2.min.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
    <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="no-skin">


    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
            try {
                ace.settings.loadState('main-container')
            } catch (e) {}

        </script>

        <div class="main-content">
            <div class="main-content-inner">


                <div class="page-content">


                    <div class="page-header">
                        <h1 align="center">Ingresar Nuevo Alimento </h1>
                    </div>
                    <!-- /.page-header -->

                    <div class="row">
                        <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <form method="post" commandName="FormularioIngresoNuevoAlimento">

                                <div class="form-group">
                                     <div>Categoría</div>
                                    <select id="food" class="">
											    <option value="Lacteos">Seleccione una Opción</option>
												<option value="Lacteos">Lacteos</option>
												<option value="Frutas">Frutas</option>
												<option value="Verduras">Verduras</option>
												<option value="Carnes">Carnes</option>
												<option value="Golosinas">Golosinas</option>
											</select>
                                </div>


                                <div class="form-group">
                                     <div>Nombre</div> <input class="typeahead scrollable" type="text" placeholder="" required />


                                </div>

                                <div class="form-group">

                                   <div>Cantidad</div>

                                    <input class="typeahead scrollable" type="text" placeholder="" required/>

                                </div>
                                
                                 <div class="form-group">
                                     <div>Medida</div>
                                    <select id="food" class="">
											    <option value="Lacteos">Seleccione una Opción</option>
												<option value="Lacteos">Gramos</option>
												<option value="Frutas">Mililitros</option>
												
											</select>
                                </div>

                                <div class="form-group">
                                    
                                    <div>Calorías</div>


                                    <input class="typeahead scrollable" type="text" placeholder="" required />

                                </div>

                            </form>
                            <div align="center" class="center">
                                <button type="button" class="width-10 pull-center btn btn-sm btn-success">
															<span class="big">Ingresar</span>

															
														</button>
                                
                            </div>
                            
                            <div class="center">
                                <img src="http://img08.deviantart.net/daf5/i/2011/010/8/d/alimentos_by_peerro-d36vgk3.jpg" width="200px" height="170px" />

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

       
    </div>

</body>

</html>
