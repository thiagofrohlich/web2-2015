<%@include file="check-auth.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
    <title>CRUEL - Registrar Cliente</title>

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
                    <h1 class="page-header">Clientes</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row" id="table">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Registros
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
                                            <th>Categoria</th>
                                            <th>Data</th>
                                            <th>Valor</th>
                                            <th>Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="lstAtendimento" items="${listaAtendimento}">
	                                        <tr class="odd gradeX">
	                                            <td class="hide">${lstAtendimento.id}</td>
	                                            <td>${lstAtendimento.categoria}</td>
	                                            <td>${lstAtendimento.data}</td>
	                                            <td>${lstAtendimento.valor}</td>
	                                            <td class="center">
	                                            	
	                                            	<button type="button" class="btn btn-info btn-circle edit-atendimento"><i class="fa fa-edit"></i></button>
	                                            	<button type="button" class="btn btn-danger btn-circle delete-atendimento"><i class="fa fa-times"></i></button>
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
                            Cadastrar Novo Atendimento
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="Atendimento?action=salva" method="post">
                                        <div class="form-group">
                                            <label class="control-label" for="categoria">Categoria</label>
                                            <input id="categoria" name="categoria" class="form-control no-blank" value="${atendimento.categoria}"/>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="data">Data</label>
                                            <jsp:useBean id="today" class="java.util.Date" />
                                            <input id="data" name="data" class="form-control no-blank" disabled="disabled" value="<fmt:formatDate pattern="dd/MM/yyyy " value="${today}" />" />
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="cliente">Cliente</label>
                                            <select class="form-control" id="cliente" name="cliente">
												<c:forEach var="cliente" items="${listaCliente}">
													<option>${cliente.id}-${cliente.descricao}</option>
												</c:forEach>
											</select>
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
    <script src="../js/form-atendimento.js"></script>
</body>

</html>