<%@include file="check-auth.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

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

        <%@include file="menu.jsp" %>
		
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
								<option>MacarrÃ£o</option>
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
