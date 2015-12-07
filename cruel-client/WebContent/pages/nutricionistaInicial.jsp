<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CRUEL - Nutricionista</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
	
	<link href="../dist/css/jquery-ui.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	   
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">CRUEL</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                                              
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Nutricionista<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="nutricionistaInicial.html">Início</a>
                                </li>
								<li>
                                    <a href="cadastroCardapio.html">Cadastro de cardápio</a>
                                </li>
                                <li>
                                    <a href="manterIngredientes.html">Ingredientes</a>
                                </li>
								<li>
                                    <a href="manterTipoIngrediente.html">Tipo de ingrediente</a>
                                </li>
								<li>
                                    <a href="nutricionistaMes.html">Cardápio mês a mês</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                   
                                              
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Gerente<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="manterAtendentes.html">Atendentes</a>
                                </li>
                                <li>
                                    <a href="manterNutricionistas.html">Nutricionistas</a>
                                </li>
								<li>
                                    <a href="tipoCliente.html">Tipo de Cliente</a>
                                </li>
								<li>
                                    <a href="manterGerentes.html">Gerentes</a>
                                </li>
								<li>
                                    <a href="relatorios.html">Relatórios</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                  
                                              
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Atendente<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="registrarAtendimento.html">Registrar Cliente</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Cárdapio - Outubro</h1>
                </div>
				<div class="col-lg-12">
                   <table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Dia</th>
								<th>Cardápio</th>
								<th></th>
							</tr>
						</thead>
				 
						<tbody>
                                        <tr>
                                            <td>01/10/2015</td>
                                            <td>Sim</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>02/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>03/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>04/10/2015</td>
                                            <td>Sim</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>05/10/2015</td>
                                            <td>Sim</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>06/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>07/10/2015</td>
                                            <td>Sim</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>08/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>09/10/2015</td>
                                            <td>Sim</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>10/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>11/10/2015</td>
                                            <td>Sim</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>12/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>13/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>14/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>15/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>16/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>17/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>18/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										 <tr>
                                            <td>19/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>20/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>21/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>22/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>23/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>24/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>25/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>26/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>27/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>28/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>29/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>30/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
										<tr>
                                            <td>31/10/2015</td>
                                            <td>não</td>
                                            <td>
												<button type="button" class="btn btn-info btn-circle "><i class="fa fa-info"></i></button>
                                            	<a href="cadastroCardapio.html" class="btn btn-info btn-circle"><i class="fa fa-edit"></i></a>
											</td>
                                        </tr>
                                    </tbody>
					</table>
					<div id="dialog" title="Cardápio" class="col-lg-12">
						<div class="col-lg-6">
						  <table class="table">
								<tr>
									<td><h4>Almoço</h4></td>
								</tr>
								<tr>
									<td>Arroz<br>Feijão<br>Carne<br>Salada<br>Acompanhamento</td>
								</tr>
								
							</table>
						</div>
						<div class="col-lg-6">
							<table class="table">
								
								<tr>
									<td><h4>Janta</h4></td>
								</tr>
								<tr>
									<td>Arroz<br>Feijão<br>Carne<br>Salada<br>Acompanhamento</td>
								</tr>
							</table>
						</div>
					</div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>
	
	 <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	
	<script src="../bower_components/jquery/dist/jquery-ui.js"></script>

   

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script >
     $(function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
	  dialogClass: "col-lg-12",
	  width: 500
	  
      
    });
 
    $( ".btn-info" ).click(function() {
      $( "#dialog" ).dialog( "open" );
    });
  });
	  
  </script>

</body>

</html>
