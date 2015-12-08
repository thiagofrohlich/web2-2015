<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <title>CRUEL - Manter Gerentes</title>

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
                    <h1 class="page-header">Gerentes</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row" id="table">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Gerentes Cadastrados
                            <button id="cadastrar-button" type="button" class="btn btn-outline btn-default">Adicionar</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
				            <div class="row">
				                <div class="col-lg-6">
					                <form role="form">
					                    <div class="input-group custom-search-form">
					                        <input name="q" type="text" class="form-control" placeholder="Pesquise..."/>
					                        <!-- <input type="text" class="form-control" placeholder="Search..."> -->
					                        <span class="input-group-btn">
				                                <button class="btn btn-default" type="button">
				                                    <i class="fa fa-search"></i>
				                                </button>
				                            </span>
					                    </div>
					                </form>
					            </div>
				            </div>
                        
                        
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-examples">
                                    <thead>
                                        <tr>
                                            <th>Email</th>
                                            <th>Nome</th>
                                            <th>CPF</th>
                                            <th>Endereço</th>
                                            <th>Telefone</th>
                                            <th>Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="lstPessoa" items="${listaPessoa}">
   		                                     <tr class="odd gradeX">
	                                            <td>${lstPessoa.email}</td>
	                                            <td>${lstPessoa.nome}</td>
	                                            <td>${lstPessoa.cpf}</td>
	                                            <td>${lstPessoa.endereco}</td>
	                                            <td>${lstPessoa.telefone}</td>
	                                            <td class="center">
	                                            	<button type="button" class="btn btn-info btn-circle edit-pessoa"><i class="fa fa-edit"></i></button>
	                                            	<button type="button" class="btn btn-danger btn-circle delete-pessoa"><i class="fa fa-times"></i></button>
	                                            </td>
	                                        </tr>
                                       	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
                        
            <div class="row hide" id="form-pessoa">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastrar Novo Atendente
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="Gerente?action=salva" method="post">
                                        <div class="form-group">
                                            <label class="control-label" for="nome">Nome</label>
                                            <input id="nome" name="nome" class="form-control no-blank" />
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="cpf">CPF</label>
                                            <input id="cpf" name="cpf" class="form-control cpf no-blank only-numeric">
                                            <p class="help-block">Apenas números. Ex.: 12345678910</p>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="endereco">Endere&ccedilo</label>
                                            <input id="endereco" name="endereco" class="form-control no-blank">
                                            <p class="help-block">Endereço completo.</p>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="telefone">Telefone</label>
                                            <input id="telefone" name="telefone" class="form-control no-blank only-numeric">
                                            <p class="help-block">Apenas números. Ex.: 33123456</p>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="email">Email</label>
                                            <input id="email" name="email" class="form-control no-blank email">
                                        </div>
		                                <div class="form-group">
		                                	<label class="control-label" for="senha">Senha</label>
		                                    <input id="senha" name="senha" class="form-control no-blank" name="password" type="password" value="">
		                                </div>
                                        <button type="submit" class="btn btn-default">Salvar</button>
                                        <button id="reset-button" type="reset" class="btn btn-default">Cancelar</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

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
    <script>
    $(document).ready(function() {
    });
    </script>

    <script src="../js/validations.js"></script>
    <script src="../js/form-pessoa.js"></script>
</body>

</html>