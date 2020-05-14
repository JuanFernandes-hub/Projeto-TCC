<%-- 
    Document   : newjsp
    Created on : 20/03/2020, 16:13:11
    Author     : juann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensagem = (String) request.getAttribute("mensagem");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nome - Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"> <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> <!-- pasta Bootstrap -->
        <link rel="stylesheet" href="css/EstilosEntrar.css"> <!-- css entrar -->
        <link rel="stylesheet" href="css/EstilosRodape.css"> <!-- css do rodape -->
    </head>
    <body>
        <!-- NAVBAR -->
        <nav class="navbar navbar-expand-md navbar-dark " style="background-color:#4A44F2; margin-bottom: 0px; border-radius: 0px">
            <!-- navbar expansiva -->

            <div class="container">


                <!-- Logo -->
                <span class="mx-3" style="font-size: 25px; color: #ffffff;">
                    <i class="far fa-compass"></i>
                </span>
                <a class="navbar-brand" href="index.html" style="color: #ffffff;">
                    <b>
                        NomeLegal
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
                            <a class="nav-link" href="index.html" style="color: #ffffff;"><b>Home</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #ffffff;"><b>Lugares</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>


                        <li class="nav-item ">
                            <a class="nav-link" href="sobre.html" style="color: #ffffff;"><b>Sobre</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp" style="color: #ffffff;"><b>Entrar</b></a>
                            <!-- como um """botao""" , mas e um link-->
                        </li>
                    </ul>
                </div>
            </div>
        </nav> <!-- FIM-NAVBAR -->

        <div class="container-fluid"
             style="background-image:url(imagens/morretes.jpg);padding-top: 100px ;background-position: bottom; background-repeat: no-repeat; background-size: cover; height: 543px;">


            <div class="row justify-content-center">
                <div class="col-5 janelaLogin">

                    <!-- Formulario que envia pro banco -->
                    <form action="validaLogin" method="post">
                        <div class="row justify-content-md-center">
                            <h1 style="color: #ffffff">Faça Login</h1>
                        </div>
                        <div class="row justify-content-center">
                            <div class="group-form">
                                <label for="idUsuario" style="color: #ffffff;">Usuário ou Email</label>
                                <input type="text" class="form-control" name="nUsuario" id="idUsuario" required autofocus>
                            </div>
                        </div>

                        <div class="row justify-content-center">
                            <div class="group-form mt-3">
                                <label for="idSenha">Senha</label>
                                <input type="password" class="form-control" name="nSenha" id="idSenha" required autofocus>
                                <a href="CadastroLogin.jsp" style="color: floralwhite;"><small>Não tenho uma conta</small></a>
                            </div>
                        </div>

                        <% if (mensagem != null) {%>
                            <p> <%= mensagem%> </p>
                        <% }%>
                        <button type="submit" class="btn btn-botaozinho mt-2">Enviar</button>
                    </form>

                </div>
            </div>
        </div>


        <!-- FOOTERS -->
        <footer class="myfooter footer mt-auto py-3">
            <div class="container"></div>
            <div class="row mx-3">
                <div class="col-sm-3 mt-3">
                    <i class="far fa-compass" aria-hidden="true" style="font-size: 150px; color: #ffffff;"></i>
                </div>
                <div class="col-sm-3 mt-3">
                    <h2 style="color: #ffffff;"><b>Sobre</b></h2>
                    <div class="col">
                        <a href="#" style="color: #ffffff;">
                            <p>Opção 1</p>
                        </a>
                    </div>
                </div>
                <div class="col-sm-3 mt-3" style="color: #ffffff;">
                    <h2><b>Lugares</b></h2>
                    <a href="#" style="color: #ffffff;">
                        <p>Opção 1</p>
                    </a>
                </div>
                <div class="col-sm-3 mt-3" style="color: #ffffff;">
                    <h2><b>Redes Sociais</b></h2>
                    <a href="#" style="color: #ffffff;">
                        <p>Opção 1</p>
                    </a>
                </div>
            </div>
        </div>
    </footer>
    <footer class="myfooter-copyright footer mt-auto">
        <div class="container">
            <div class="row justify-content-center">
                <p><small>Fabricado por Juan - 2020</small></p>
            </div>
        </div>
    </footer><!-- FIM FOOTERS -->

    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script><!-- font awesome -->
    <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN, DEVE SER A ULTIMA COISA ANTES DE FECHAR O BODY -->
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- ajax -->
</body>
</html>
