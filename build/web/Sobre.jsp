<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sobre - Colibri</title>
        <link rel="stylesheet" href="css/EstilosNavbar.css">
        <link rel="stylesheet" href="css/EstiloFooter.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/EstiloSobre.css">
    </head>
    <style>
        html, body{
            font-family: 'Roboto', serif;
        }

    </style>

    <body>
        <!-- NAVBAR -->
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


        <div class="container">
            <div class="row pt-5 row justify-content-center">
                <h1 class="text-center">Por que me usar?</h1>
            </div>
            <div class="row justify-content-center pt-2 area-icon">
                <div class="col" style="text-align: center;">
                    <span class="" style="font-size: 120px; color: #4A44F2;">
                        <i class="fas fa-route"></i>
                    </span>
                    <h3 class="" style="color: #002028;"><b>Explore novos lugares</b></h3>
                    <p class="">Aproveite seu final de semana para conhecer novos lugares</p>
                </div>
                <div class="col" style="text-align: center;">
                    <span class="" style="font-size: 120px; color: #4A44F2;">
                        <i class="fas fa-share-alt"></i>                  
                    </span>
                    <h3 class="" style="color: #002028;"><b>Compartilhe um lugar</b></h3>
                    <p class="">Cadastre um lugar para que mais pessoas possam visitá-lo</p>
                </div>
                <div class="col" style="text-align: center;">
                    <span class="" style="font-size: 120px; color: #4A44F2;">
                        <i class="far fa-laugh"></i>
                    </span>
                    <h3 class="" style="color: #002028;"><b>Veja outras experiências</b></h3>
                    <p class="">Compartilhe e veja experiências</p>
                </div>
            </div>
        </div>

        <!--Footer -->
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
