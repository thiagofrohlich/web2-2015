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

		<%@include file="menu.jsp" %>
		
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Cardápio da Semana</h1>
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
											<td>${domingo.refeicao1.ingrediente1.nome}<br>${domingo.refeicao1.ingrediente2.nome}<br>${domingo.refeicao1.ingrediente3.nome}<br>${domingo.refeicao1.ingrediente4.nome}<br>${domingo.refeicao1.ingrediente5.nome}<br>${domingo.refeicao1.ingrediente6.nome}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${domingo.refeicao2.ingrediente1.nome}<br>${domingo.refeicao2.ingrediente2.nome}<br>${domingo.refeicao2.ingrediente3.nome}<br>${domingo.refeicao2.ingrediente4.nome}<br>${domingo.refeicao2.ingrediente5.nome}<br>${domingo.refeicao2.ingrediente6.nome}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${segunda.refeicao1.ingrediente1.nome}<br>${segunda.refeicao1.ingrediente2.nome}<br>${segunda.refeicao1.ingrediente3.nome}<br>${segunda.refeicao1.ingrediente4.nome}<br>${segunda.refeicao1.ingrediente5.nome}<br>${segunda.refeicao1.ingrediente6.nome}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${segunda.refeicao1.ingrediente1.nome}<br>${segunda.refeicao1.ingrediente2.nome}<br>${segunda.refeicao1.ingrediente3.nome}<br>${segunda.refeicao1.ingrediente4.nome}<br>${segunda.refeicao1.ingrediente5.nome}<br>${segunda.refeicao1.ingrediente6.nome}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${terca.refeicao1.ingrediente1.nome}<br>${terca.refeicao1.ingrediente2.nome}<br>${terca.refeicao1.ingrediente3.nome}<br>${terca.refeicao1.ingrediente4.nome}<br>${terca.refeicao1.ingrediente5.nome}<br>${terca.refeicao1.ingrediente6.nome}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${terca.refeicao1.ingrediente1.nome}<br>${terca.refeicao1.ingrediente2.nome}<br>${terca.refeicao1.ingrediente3.nome}<br>${terca.refeicao1.ingrediente4.nome}<br>${terca.refeicao1.ingrediente5.nome}<br>${terca.refeicao1.ingrediente6.nome}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${quarta.refeicao1.ingrediente1.nome}<br>${quarta.refeicao1.ingrediente2.nome}<br>${quarta.refeicao1.ingrediente3.nome}<br>${quarta.refeicao1.ingrediente4.nome}<br>${quarta.refeicao1.ingrediente5.nome}<br>${quarta.refeicao1.ingrediente6.nome}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${quarta.refeicao1.ingrediente1.nome}<br>${quarta.refeicao1.ingrediente2.nome}<br>${quarta.refeicao1.ingrediente3.nome}<br>${quarta.refeicao1.ingrediente4.nome}<br>${quarta.refeicao1.ingrediente5.nome}<br>${quarta.refeicao1.ingrediente6.nome}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${quinta.refeicao1.ingrediente1.nome}<br>${quinta.refeicao1.ingrediente2.nome}<br>${quinta.refeicao1.ingrediente3.nome}<br>${quinta.refeicao1.ingrediente4.nome}<br>${quinta.refeicao1.ingrediente5.nome}<br>${quinta.refeicao1.ingrediente6.nome}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${quinta.refeicao1.ingrediente1.nome}<br>${quinta.refeicao1.ingrediente2.nome}<br>${quinta.refeicao1.ingrediente3.nome}<br>${quinta.refeicao1.ingrediente4.nome}<br>${quinta.refeicao1.ingrediente5.nome}<br>${quinta.refeicao1.ingrediente6.nome}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${sexta.refeicao1.ingrediente1.nome}<br>${sexta.refeicao1.ingrediente2.nome}<br>${sexta.refeicao1.ingrediente3.nome}<br>${sexta.refeicao1.ingrediente4.nome}<br>${sexta.refeicao1.ingrediente5.nome}<br>${sexta.refeicao1.ingrediente6.nome}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${sexta.refeicao1.ingrediente1.nome}<br>${sexta.refeicao1.ingrediente2.nome}<br>${sexta.refeicao1.ingrediente3.nome}<br>${sexta.refeicao1.ingrediente4.nome}<br>${sexta.refeicao1.ingrediente5.nome}<br>${sexta.refeicao1.ingrediente6.nome}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="table">
										<tr>
											<td><h4>Almoço</h4></td>
										</tr>
										<tr>
											<td>${sabado.refeicao1.ingrediente1.nome}<br>${sabado.refeicao1.ingrediente2.nome}<br>${sabado.refeicao1.ingrediente3.nome}<br>${sabado.refeicao1.ingrediente4.nome}<br>${sabado.refeicao1.ingrediente5.nome}<br>${sabado.refeicao1.ingrediente6.nome}</td>
										</tr>
										<tr>
											<td><h4>Janta</h4></td>
										</tr>
										<tr>
											<td>${sabado.refeicao1.ingrediente1.nome}<br>${sabado.refeicao1.ingrediente2.nome}<br>${sabado.refeicao1.ingrediente3.nome}<br>${sabado.refeicao1.ingrediente4.nome}<br>${sabado.refeicao1.ingrediente5.nome}<br>${sabado.refeicao1.ingrediente6.nome}</td>
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
