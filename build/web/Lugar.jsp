<%-- 
    Document   : TesteLugar
    Created on : 19/06/2020, 20:58:59
    Author     : juann
--%>

<%@page import="model.Classe"%>
<%@page import="model.LoginLugar"%>
<%@page import="DAO.LoginLugarDAO"%>
<%@page import="model.Cidade"%>
<%@page import="model.Estado"%>
<%@page import="java.sql.Time"%>
<%@page import="model.Categoria"%>
<%@page import="model.Lugar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lugar - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/EstiloBtns.css">
        <link rel="stylesheet" href="css/EstiloFooter.css">
        <link rel="stylesheet" href="css/EstiloLugar.css">
    </head>

    <body>
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
        <%
            Lugar lugar = (Lugar) request.getAttribute("lugar");
            String nome = lugar.getNome();
            float avaliacao = lugar.getAvaliacao();
            Categoria categoria = lugar.getCategoria();
            String acesso = lugar.getAcesso();
            Time horaInicial = lugar.getHoraInicial();
            Time horaFinal = lugar.getHoraFinal();
            String descricao = lugar.getDescricao();
            Estado estado = lugar.getLocalizacao().getCidade().getEstado();
            Cidade cidade = lugar.getLocalizacao().getCidade();
            String bairro = lugar.getLocalizacao().getBairro();
            String rua = lugar.getLocalizacao().getRua();
            String numero = lugar.getLocalizacao().getNumero();
        %>
        <div class="container-fluid">
            <div class="row tela">
                <div class="col-md-5 area-info">
                    <ul>
                        <li>
                            <h1 class="text-capitalize"><%= nome%></h1>
                        </li>
                        <li>
                            <h2 class="text-capitalize"><%= descricao%></h2>
                        </li>
                        <li>
                            <label for=""><%= categoria.getNome()%></label>
                        </li>
                        <li>
                            <label for=""><%= horaInicial%></label> 
                            <label for=""> - </label>
                            <label for=""><%= horaFinal%></label>
                        </li>
                        <li>
                            <label for=""><%= estado.getNome()%>, <%= cidade.getNome()%></label>
                        <li>
                            <label for=""><%= bairro%>, <%= rua%>, <%= numero%></label>
                        </li>
                        <div class="row area-btn">
                            <%!
                                HttpSession sessao;
                                String classeLog;
                                int idLog;
                                String nomeLog;

                            %>
                            <%
                                try {
                                    sessao = request.getSession();
                                    idLog = (Integer) sessao.getAttribute("idUsuarioLogado");
                                    classeLog = (String) sessao.getAttribute("classeUsuarioLogado");
                                    nomeLog = (String) sessao.getAttribute("nomeUsuarioLogado");
                                    Lugar lugarCadastrado = LoginLugarDAO.getLugar(idLog, lugar.getIdLugar());
                                    if (lugarCadastrado != null || classeLog.equals("administrador")) {
                            %>
                            <a class="btn my-button-accept" href="GetLugar?idLugar=<%= lugar.getIdLugar()%>&act=update">Editar</a>
                            <a type="button" class="btn my-button-accept" data-toggle="modal" data-target="#ModalDeletaLugar">
                                Deletar
                            </a>
                            <a type="button" class="btn my-button-cancel" onclick="window.history.back()">Cancelar</a>
                            <%}
                                } catch (Exception e) {
                                }
                            %>

                        </div>
                    </ul>

                </div>

                <div class="col-md-7 area-img">
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

        <!-- MODAL DELETA LUGAR -->
        <div class="modal fade" id="ModalDeletaLugar" tabindex="-1" role="dialog" aria-labelledby="TituloModalDeletaUsuario" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="TituloModalDeletaUsuario">Deletar <%= nome%></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Deseja excluir <%= nome%>? Você não conseguirá recuperá-lo depois.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <a href="DeleteLugar?idLugar=<%= lugar.getIdLugar()%>" onclick="window.history.back()" >Deletar</a>
                    </div>
                </div>
            </div>
        </div>

        <script>
            //id do Lugar clicado
            var dadosArquivados = JSON.parse(sessionStorage.getItem('chave'));
        </script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/GetLugar.js"></script> <!-- MEU AJAX para pegar lugar-->
    </body>
</html>
