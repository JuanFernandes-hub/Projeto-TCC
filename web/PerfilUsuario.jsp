<%@page import="model.Login"%>
<%@page import="model.Lugar"%>
<%@page import="java.util.List"%>
<%@page import="DAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%!
            HttpSession sessao;
            String classeLog;
            int idLog;
            String nomeLog;
            Login login;
        %>
        <%
            sessao = request.getSession();
            if (sessao.getAttribute("idUsuarioLogado") == null) {%>
        <jsp:forward page="Login.jsp" />
        <%
            }%>
        <title><%= sessao.getAttribute("nomeUsuarioLogado")%> - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/EstiloCards.css">
        <link rel="stylesheet" href="css/EstiloFooter.css">
        <link rel="stylesheet" href="css/EstiloPerfilUsuario.css">
    </head>
    <body>

        <%
            idLog = (Integer) sessao.getAttribute("idUsuarioLogado");
            login = LoginDAO.getLogin(idLog);
        %>

        <nav class="navbar navbar-expand-md navbar-dark edit-nav">
            <!-- navbar expansiva -->
            <div class="container">
                <!-- Logo -->
                <a class="navbar-brand" href="Home.jsp" style="color: white;">
                    <b>
                        Colibri
                    </b>
                </a>

                <!-- Botão que carrega as opcoes da barra de navegadores (collapse) (3 riscos) -->
                <button class="navbar-toggler" title="button" data-toggle="collapse" data-target="#conteudoDaBarra">
                    <span class="navbar-toggler-icon"></span> <!-- carrega o icone dos 3 riscos -->
                </button>

                <!-- Opcoes da barra de navegacao -->
                <div class="collapse navbar-collapse" id="conteudoDaBarra">
                    <!-- id que liga ao collapse(3 riscos) -->
                    <ul class="navbar-nav ml-auto">
                        <!-- a lista aumenta automaticamente -->
                        <li class="nav-item active">
                            <!-- opcao ativa -->
                            <a class="nav-link" href="Home.jsp" style="color: #ffffff;"><b>Página Inicial</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="Lugares.jsp" style="color: #ffffff;"><b>Lugares</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>


                        <li class="nav-item ">
                            <a class="nav-link" href="Sobre.jsp" style="color: #ffffff;"><b>Sobre</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>

                        <%
                            HttpSession sessao = request.getSession();
                            String usuario = (String) sessao.getAttribute("nomeUsuarioLogado");
                            if (usuario != null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp" style="color: #ffffff;"><b><%= usuario%></b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>
                        <%
                        } else {
                        %>
                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp" style="color: #ffffff;"><b>Entrar</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid tela-altura" style="">
            <div class="row tela-altura" style="">
                <div class="col-md-3 col-perfil">
                    <nav class="navbar navbar-expand-md nav-perfil">
                        <button class="navbar-toggler" title="button" data-toggle="collapse" data-target="#conteudoDaBarraPerfil"
                                style="color: #000;">
                            <span class="navbar-toggler-icon">
                                <i class="fas fa-bars" style="color:#000; font-size:28px;"></i>
                            </span>
                        </button>
                        <div class="collapse navbar-collapse" id="conteudoDaBarraPerfil">
                            <ul class="fa-ul" style="width: 100%; padding-right: 20px">
                                <li class="text-icon">
                                    <span class="fa-li">
                                        <i class="fas fa-user"></i>
                                    </span>
                                    <label class="text-truncate" style="width: 100%"><%= login.getUsuario()%></label>
                                </li>
                                <li class="text-icon">
                                    <span class="fa-li">
                                        <i class="fas fa-envelope"></i>
                                    </span>
                                    <label class="text-truncate" style="width: 100%"><%= login.getEmail()%></label>
                                </li>
                                <li class="text-icon">
                                    <a href="CadastraLugar.jsp">
                                        <span class="fa-li">
                                            <i class="fas fa-map-marker-alt"></i>
                                        </span>
                                        Novo Lugar
                                    </a>
                                </li>
                                <li class="text-icon">
                                    <a href="UpdateLogin.jsp">
                                        <span class="fa-li">
                                            <i class="fas fa-cog"></i>
                                        </span>
                                        Editar Conta
                                    </a>
                                </li>
                                <li class="text-icon">
                                    <a type="button" data-toggle="modal" data-target="#ModalDeletaConta">
                                        <span class="fa-li">
                                            <i class="fas fa-trash-alt"></i>
                                        </span>
                                        Deletar Conta
                                    </a>
                                </li>
                                <li class="text-icon">
                                    <a href="SairPerfil">
                                        <span class="fa-li">
                                            <i class="fas fa-sign-out-alt"></i>
                                        </span>
                                        Sair
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>

                <div class="col-md-9 col-card-perfil ">
                    <div class="area-titulo">
                        <h1>
                            Seus Lugares cadastrados
                        </h1>
                    </div>

                    <div class="row" style="margin-left: 0px; width: 100%">
                        <%
                            List<Lugar> lugares = LoginDAO.getLugaresCad(idLog);
                            for (Lugar lugar : lugares) {
                        %>  
                        <div class="col-md-4 my-card-col" style="width: 100%">
                            <div class="card-container mycard" id="<%= lugar.getIdLugar()%>">
                                <div class="card-img">
                                    <div class="card-container-texto" style="">
                                        <h3 class="card-titulo text-truncate text-capitalize"><%= lugar.getNome()%></h3>
                                        <p class="card-texto text-truncate text-capitalize"><%= lugar.getCategoria().getNome()%></p>
                                        <p class="card-texto text-truncate text-capitalize"><%= lugar.getDescricao()%></p>
                                    </div>
                                    <div class="my-card-footer">
                                        <a href="GetLugar?idLugar=<%= lugar.getIdLugar()%>&act=get">Ver Mais</a>
                                    </div>
                                </div>
                            </div>
                        </div><%
                            }%>
                    </div>



                </div>

            </div>

        </div>

        <footer class="my-footer mt-auto py-3">
            <div class="container">
                <div class="row justify-content-center area-footer-opcao">
                    <h2><a href="Home.jsp"><b>Colibri</b></a></h2>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm-4 mt-3 area-footer-opcao">
                        <h2><a href="Sobre.jsp">Sobre</a></h2>
                    </div>
                    <div class="col-sm-4 mt-3 area-footer-opcao">
                        <h2><a href="Lugares.jsp">Lugares</a></h2>
                    </div>
                    <div class="col-sm-4 mt-3 area-footer-opcao">
                        <h2><a href="Login.jsp">Entrar</a></h2>
                    </div>
                </div>
            </div>
            <div class="my-footer-copyright">
                <p>&COPY; Colibri | Fabricado por Juan Fernandes</p>
            </div>
        </footer>





        <!-- MODAL DELETA CONTA  (algum problema em pegar variavel)-->
        <div class="modal fade" id="ModalDeletaConta" tabindex="-1" role="dialog" aria-labelledby="TituloModalDeletaConta" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="TituloModalDeletaConta">Deletar conta</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir sua conta? Você não conseguirá recuperá-la depois e seus lugares cadastrados serão excluídos da plataforma.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <a href="DeletaPerfil" class="btn btn-primary" role="button">Deletar</a>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
