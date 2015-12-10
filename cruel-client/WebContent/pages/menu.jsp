<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		 <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/cruel-client/index.jsp">CRUEL</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
            	<c:if test="${cookie.usuario == null}">
                	<li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Login</a></li>
                </c:if>
            	<c:if test="${cookie.usuario != null}">
                	<li><a href="Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                </c:if>
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                    <c:if test="${cookie.tipoUsuario.value == 'NUTRICIONISTA'}">
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Nutricionista<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="nutricionistaInicial.jsp">Início</a>
                                </li>
								<li>
                                    <a href="cadastroCardapio.jsp">Cadastro de cardápio</a>
                                </li>
                                <li>
                                    <a href="Ingrediente?action=inicio">Ingredientes</a>
                                </li>
								<li>
                                    <a href="TipoIngrediente?action=inicio">Tipo de ingrediente</a>
                                </li>
								<li>
                                    <a href="nutricionistaMes.jsp">Cardápio mês a mês</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </c:if>
                   
                    <c:if test="${cookie.tipoUsuario.value == 'GERENTE'}">                   
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Gerente<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="Atendente?action=inicio">Atendentes</a>
                                </li>
                                <li>
                                    <a href="Nutricionista?action=inicio">Nutricionistas</a>
                                </li>
								<li>
                                    <a href="TipoCliente?action=inicio">Tipo de Cliente</a>
                                </li>
								<li>
                                    <a href="Gerente?action=inicio">Gerentes</a>
                                </li>
								<li>
                                    <a href="relatorios.jsp">Relatórios</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </c:if>
                  
                  	<c:if test="${cookie.tipoUsuario.value == 'ATENDENTE'}">
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Atendente<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="Atendimento?action=inicio">Registrar Cliente</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
					</c:if>		                            
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

		