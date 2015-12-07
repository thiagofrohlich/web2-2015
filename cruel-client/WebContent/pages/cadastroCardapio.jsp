<!DOCTYPE html>
<html lang="en">

<head>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>CRUEL - CARDAPIOS</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

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
            
            <!-- /.row -->
            <div class="row">
			<div class="col-lg-12">
                    <h3 class="page-header">Cardapio - 04/11/2015</h3>
                </div>
                <div class="col-lg-6">
				<h3 class="page-header">Almoço</h3>
					
						<div class="form-group">
							<label>Arroz</label>
							<select class="form-control">
								<c:forEach var="arroz" items="${listaArroz}">
									<option>${arroz}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Feijão</label>
							<select class="form-control">
								<c:forEach var="feijao" items="${listaFeijao}">
									<option>${feijao}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Salada</label>
							<select class="form-control">
								<c:forEach var="salada" items="${listaSalada}">
									<option>${salada}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Carne</label>
							<select class="form-control">
								<c:forEach var="carne" items="${listaCarne}">
									<option>${carne}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Acompanhamento</label>
							<select class="form-control">
								<c:forEach var="acompanhamento" items="${listaAcomp}">
									<option>${acompanhamento}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Sobremesa</label>
							<select class="form-control">
								<c:forEach var="sobremesa" items="${listaSobremesa}">
									<option>${sobremesa}</option>
								</c:forEach>
							</select>
						</div>
					
				</div>
				<div class="col-lg-6">
				<h3 class="page-header">Janta</h3>
					
						<div class="form-group">
							<label>Arroz</label>
							<select class="form-control">
								<option>Branco</option>
								<option>Risoto</option>
							</select>
						</div>
						<div class="form-group">
							<label>Feijão</label>
							<select class="form-control">
								<option>Branco</option>
								<option>Preto</option>
							</select>
						</div>
						<div class="form-group">
							<label>Salada</label>
							<select class="form-control">
								<option>Alface</option>
								<option>Tomate</option>
							</select>
						</div>
						<div class="form-group">
							<label>Carne</label>
							<select class="form-control">
								<option>Carne moída</option>
								<option>Bife</option>
							</select>
						</div>
						<div class="form-group">
							<label>Acompanhamento</label>
							<select class="form-control">
								<option>Macarrão</option>
								<option>Ovo frito</option>
							</select>
						</div>
						<div class="form-group">
							<label>Sobremesa</label>
							<select class="form-control">
								<option>Bolo</option>
								<option>Gelatina</option>
							</select>
						</div>
					
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-default">Salvar</button>
				</div>
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

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
