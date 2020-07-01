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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="css/PaginaInicialEstilo.css">
        <link rel="stylesheet" href="css/PgInicialCardEstilos.css">
        <link rel="stylesheet" href="css/EstilosRodape.css">
    </head>
    <body>
        <div class="section-top">
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
                                <a class="nav-link" href="Home.jsp" style="color: #ffffff;"><b>Home</b></a>
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

                            <li class="nav-item">
                                <a class="nav-link" href="Login.jsp" style="color: #ffffff;"><b>Entrar</b></a>
                                <!-- como um """botao""" , mas e um link-->
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="content">
                <h1>Descubra sua Cidade</h1>
                <input class="input-imagem" type="search" name="" id="" placeholder="Pesquise Lugares">

            </div>
            <!-- Setinha -->
            <div class="content2">
                <i class="fas fa-chevron-down" style=""></i>
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
                %>  <div class="col-md-3 my-card-col" style="padding-left: 10px; padding-right: 10px;">
                    <div class="card-container mycard" id="<%= lugares.get(i).getIdLugar()%>">
                        <div class="card-img"></div>
                        <div class="card-container-texto">
                            <a class="card-titulo" href="#"><%= lugares.get(i).getNome()%></a>
                            <p class="card-texto"><%= lugares.get(i).getCategoria().getNome()%></p>
                            <p class="card-texto"><%= lugares.get(i).getDescricao()%></p>
                        </div>
                        <div class="my-card-footer">
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



        <footer class="myfooter footer mt-auto py-3">
            <div class="container">
                <div class="row justify-content-center area-footer-opcao">
                    <h2><b>Colibri</b></h2>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm-4 mt-3 area-footer-opcao">
                        <h2><b>Sobre</b></h2>
                    </div>
                    <div class="col-sm-4 mt-3 area-footer-opcao">
                        <h2><b>Lugares</b></h2>
                    </div>
                    <div class="col-sm-4 mt-3 area-footer-opcao">
                        <h2><b>Redes Sociais</b></h2>
                    </div>
                </div>
            </div>
        </footer>
        <footer class="myfooter-copyright footer mt-auto">
            <div class="container">
                <div class="row justify-content-center">
                    <p>Fabricado por Juan - 2020</p>
                </div>
            </div>
        </footer><!-- FIM FOOTERS -->

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
</html>
