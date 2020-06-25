<%@page import="model.Cidade"%>
<%@page import="DAO.CidadeDAO"%>
<%@page import="DAO.LugarDAO"%>
<%@page import="model.Lugar"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial - Colibri</title>
        <link rel="stylesheet" href="css/EstiloHome.css">
        <link rel="stylesheet" href="css/EstilosRodape.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <div class="fundo-imagem">
            <nav class="navbar navbar-expand-md navbar-dark edit-nav">
                <!-- navbar expansiva -->
                <div class="container">
                    <!-- Logo -->

                    <a class="navbar-brand" href="Home.jsp" style="color: #ffffff;">
                        <span class="mx-1" style="font-size: 25px; color: #ffffff;">
                            <i class="far fa-compass"></i>
                        </span>
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
                                <a class="nav-link" href="sobre.html" style="color: #ffffff;"><b>Sobre</b></a>
                                <!-- como um """botao""" , mas e um link-->
                            </li>

                            <%
                                //Verifica se está logado, e substitui li
                                HttpSession sessao = request.getSession();
                                if (sessao.getAttribute("nomeUsuarioLogado") != null) {
                            %>
                            <li class="nav-item">
                                <a class="nav-link" href="PerfilUsuario.jsp" style="color: #ffffff;"><b><%= sessao.getAttribute("nomeUsuarioLogado")%></b></a>
                            </li>
                            <%
                            } else {
                            %>    <li class="nav-item">
                                <a class="nav-link" href="Login.jsp" style="color: #ffffff;"><b>Entrar</b></a>
                            </li>
                            <%
                                }
                            %>

                        </ul>
                    </div>
                </div>
            </nav>
            <div class="fundo-texto">
                <h1 style="font-size:50px">Descubra sua cidade</h1>
            </div>

        </div>

        <div class="container pt-5">

            <div class="row">
                <%!
                    LugarDAO lugardao = new LugarDAO();
                    List<Lugar> lugares = lugardao.getLugar();
                %>
                <%
                    //Limitar numero de cards na home
                    for (int i = 0; i < lugares.size(); i++) {
                %>  <div class="col-md-3 cardCol">
                    <div class="card mycard" id="<%= lugares.get(i).getIdLugar()%>" onclick="geraPg(this)">
                        <div class="card-body">
                            <h3 class="card-title"> <%= lugares.get(i).getNome()%> </h3>
                            <p class="card-text"><%= lugares.get(i).getCategoria().getNome()%></p>
                            <p class="card-text"><%= lugares.get(i).getDescricao()%></p>
                        </div>
                        <div class="card-footer">
                            <a href="GetLugar?idLugar=<%= lugares.get(i).getIdLugar()%>&act=get">Ver Mais</a>
                        </div>
                    </div>
                </div>
                <%
                        if (i >= 11) {
                            break;
                        }
                    }
                %>        




            </div>
        </div>

        <!--Footer -->
        <footer class="myfooter footer mt-5 py-3">
            <div class="container">
                <div class="row mx-3">
                    <div class="col-sm-3 mt-3">
                        <i class="far fa-compass" aria-hidden="true" style="font-size: 150px; color: #ffffff;"></i>
                    </div>
                    <div class="col-sm-3 mt-3">
                        <a href="sobre.html">
                            <h2 style="color: #ffffff;">Sobre</h2>
                        </a>
                    </div>
                    <div class="col-sm-3 mt-3">
                        <a href="Lugares.jsp">
                            <h2 style="color: #ffffff;">Lugares</h2>
                        </a>
                    </div>
                    <div class="col-sm-3 mt-3" style="color: #ffffff;">
                        <a href="Login.jsp">
                            <h2 style="color: #ffffff;">Entrar</h2>
                        </a>
                    </div>
                </div>
            </div>
        </footer>
        <footer class="myfooter-copyright footer mt-auto">
            <div class="container">
                <div class="row justify-content-center">
                    <p><small>Fabricado por Juan Fernandes - 2020</small></p>
                </div>
            </div>
        </footer><!-- FIM FOOTERS -->

        <!-- font awesome -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

    </body>
</html>
