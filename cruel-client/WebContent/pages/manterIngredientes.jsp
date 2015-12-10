<%@include file="check-auth.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CRUEL - Manter Ingredientes</title>

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
                    <h1 class="page-header">Ingredientes</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row" id="table">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Ingredientes Cadastrados
                            <button id="cadastrar-button" type="button" class="btn btn-outline btn-default">Adicionar</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-examples">
                                    <thead>
                                        <tr>
                                            <th>Tipo</th>
                                            <th>Nome</th>
                                            <th>Descrição</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="lstIngred" items="${listaIngrediente}">
	                                        <tr class="odd gradeX">
	                                            <td class="hide">${lstIngred.id}</td>
	                                            <td>${lstIngred.tipoIngrediente.nome}</td>
	                                            <td>${lstIngred.nome}</td>
	                                            <td>${lstIngred.descricao}</td>
	                                            <td class="center">
	                                            	<button type="button" class="btn btn-info btn-circle edit-ing"><i class="fa fa-edit"></i></button>
	                                            	<button type="button" class="btn btn-danger btn-circle delete-ing"><i class="fa fa-times"></i></button>
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
                        
            <div class="row hide" id="form-ing">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastrar Novo Ingrediente
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="Ingrediente?action=salva" method="post">
                                    <input type="hidden" value="${ingrediente.id}">
                                        <div class="form-group">
                                            <label class="control-label" for="tipo">Tipo</label>
                                            <select class="form-control" id="tipo" name="tipo" >
												<c:forEach var="lstTipo" items="${tipo}">
													<option>${lstTipo.id}-${lstTipo.nome}</option>
												</c:forEach>
											</select>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="nome">Nome</label>
                                            <input id="nome" class="form-control no-blank" name="nome" value="${ingrediente.nome}">
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="descricao">Descrição</label>
                                            <textarea class="form-control no-blank" rows="3" id="descricao" name="descricao" >${ingrediente.descricao}</textarea>
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
    <script src="../js/form-ing.js"></script>
</body>

</html>