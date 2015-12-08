<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CRUEL - Início</title>

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
                    <h1 class="page-header">Início</h1>
                </div>
				<div class="col-lg-12">
                   <table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Domingo</th>
								<th>Segunda</th>
								<th>Terça</th>
								<th>Quarta</th>
								<th>Quinta</th>
								<th>Sexta</th>
								<th>Sabado</th>
							</tr>
						</thead>
							<tr>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${domingo.almoco.arroz}<br>${domingo.almoco.feijao}<br>${domingo.almoco.carne}<br>${domingo.almoco.salada}<br>${domingo.almoco.acompanhamento}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${domingo.janta.arroz}<br>${domingo.janta.feijao}<br>${domingo.janta.carne}<br>${domingo.janta.salada}<br>${domingo.janta.acompanhamento}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${segunda.almoco.arroz}<br>${segunda.almoco.feijao}<br>${segunda.almoco.carne}<br>${segunda.almoco.salada}<br>${segunda.almoco.acompanhamento}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${segunda.janta.arroz}<br>${segunda.janta.feijao}<br>${segunda.janta.carne}<br>${segunda.janta.salada}<br>${segunda.janta.acompanhamento}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${terca.almoco.arroz}<br>${terca.almoco.feijao}<br>${terca.almoco.carne}<br>${terca.almoco.salada}<br>${terca.almoco.acompanhamento}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${terca.janta.arroz}<br>${terca.janta.feijao}<br>${terca.janta.carne}<br>${terca.janta.salada}<br>${terca.janta.acompanhamento}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${quarta.almoco.arroz}<br>${quarta.almoco.feijao}<br>${quarta.almoco.carne}<br>${quarta.almoco.salada}<br>${quarta.almoco.acompanhamento}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${quarta.janta.arroz}<br>${quarta.janta.feijao}<br>${quarta.janta.carne}<br>${quarta.janta.salada}<br>${quarta.janta.acompanhamento}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${quinta.almoco.arroz}<br>${quinta.almoco.feijao}<br>${quinta.almoco.carne}<br>${quinta.almoco.salada}<br>${quinta.almoco.acompanhamento}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${quinta.janta.arroz}<br>${quinta.janta.feijao}<br>${quinta.janta.carne}<br>${quinta.janta.salada}<br>${quinta.janta.acompanhamento}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${sexta.almoco.arroz}<br>${sexta.almoco.feijao}<br>${sexta.almoco.carne}<br>${sexta.almoco.salada}<br>${sexta.almoco.acompanhamento}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${sexta.janta.arroz}<br>${sexta.janta.feijao}<br>${sexta.janta.carne}<br>${sexta.janta.salada}<br>${sexta.janta.acompanhamento}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${sabado.almoco.arroz}<br>${sabado.almoco.feijao}<br>${sabado.almoco.carne}<br>${sabado.almoco.salada}<br>${sabado.almoco.acompanhamento}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${sabado.janta.arroz}<br>${sabado.janta.feijao}<br>${sabado.janta.carne}<br>${sabado.janta.salada}<br>${sabado.janta.acompanhamento}</td>
										</tr>
									</table>
								</td>
							<tr>
						<tbody>
                                      
						</tbody>
					</table>
					
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
	
	 <script src="../bower_components/jquery/dist/jquery-ui.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
	

</body>

</html>
