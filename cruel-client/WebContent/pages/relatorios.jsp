<%@include file="check-auth.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CRUEL - Relatórios</title>

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

        <%@include file="menu.jsp" %>

        <div id="page-wrapper">
            
            <!-- /.row -->
            <div class="row">
			<div class="col-lg-12">
                    <h3 class="page-header">Relatórios</h3>
                </div>
                <form action="Relatorio?action=mensal" method="post">
                <div class="col-lg-6">
				<h3 class="page-header">Mensal</h3>
						 <div class="col-lg-4">
						<div class="form-group" >
								<label>Mês</label>
								<select class="form-control" name="mes">
									<option label="Janeiro" value="1"/>
									<option label="Fevereiro" value="2"/>
									<option label="Março" value="3"/>
									<option label="Abril" value="4"/>
									<option label="Maio" value="5"/>
									<option label="Junho" value="6"/>
									<option label="Julho" value="7"/>
									<option label="Agosto" value="8"/>
									<option label="Setembro" value="9"/>
									<option label="Outubro" value="10"/>
									<option label="Novembro" value="11"/>
									<option label="Dezembro" value="12"/>
									
								</select>
							</div>
							<div class="form-group" >
								<label>Ano</label>
								<select class="form-control" name="ano">
									<option>2012</option>
									<option>2013</option>
									<option>2014</option>
									<option >2015</option>
									<option>2016</option>
									<option>2017</option>
								</select>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-default">Gerar</button>
							</div>
						</div>
				</div>
				</form>
				<div class="col-lg-6">
				<h3 class="page-header">Anual</h3>
						<form action="Relatorio?action=anual" method="post">
						<div class="col-lg-4">
						<div class="form-group" >
								<label>Ano</label>
								<select class="form-control" name="ano">
									<option>2012</option>
									<option>2013</option>
									<option>2014</option>
									<option >2015</option>
									<option>2016</option>
									<option>2017</option>
								</select>
							</div>
							<div class="form-group">
								<button type=submit class="btn btn-default">Gerar</button>
							</div>
						</div>
						</form>
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
