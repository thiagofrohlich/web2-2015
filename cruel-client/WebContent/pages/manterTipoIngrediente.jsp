<%@include file="check-auth.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>CRUEL - Tipo Ingrediente</title>

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
		
			<%@include file="menu.jsp" %>
		
	        <div id="page-wrapper">
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">Atendentes</h1>
	                </div>
	                <!-- /.col-lg-12 -->
	            </div>
	            
	            <div class="row" id="table">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            Tipo de ingrediente Cadastrados
	                            <button id="cadastrar-button" type="button" class="btn btn-outline btn-default">Adicionar</button>
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                            <div class="dataTable_wrapper">
	                                <table class="table table-striped table-bordered table-hover" id="dataTables-examples">
	                                    <thead>
	                                        <tr>
	                                            <th>Nome</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <c:forEach var="lstTipo" items="${listaTipoIngrediente}">
		                                        <tr class="odd gradeX">
		                                        	<td class="hide">${lstTipo.id}</td>
		                                            <td>${lstTipo.nome}</td>
		                                            <td class="center">
		                                            	<button type="button" class="btn btn-info btn-circle edit-tip"><i class="fa fa-edit"></i></button>
		                                            	<button type="button" class="btn btn-danger btn-circle  delete-tip"><i class="fa fa-times"></i></button>
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
	            <div class="row hide" id="form-tip">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            Cadastrar Novo Tipo de Ingrediente
	                        </div>
	                        <div class="panel-body">
	                            <div class="row">
	                                <div class="col-lg-6">
	                                    <form role="form" action="TipoIngrediente?action=salva" method="post">
	                                    <input type="hidden" value="${ing.id}">
	                                        <div class="form-group">
	                                            <label class="control-label" for="nome">Nome</label>
	                                            <input id="nome" name="nome" class="form-control no-blank" value="${ing.nome}"/>
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
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

    <script src="../js/validations.js"></script>
    <script src="../js/form-tip.js"></script>
</body>

</html>