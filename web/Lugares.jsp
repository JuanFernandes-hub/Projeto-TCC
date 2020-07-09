<%@page import="model.Cidade"%>
<%@page import="DAO.CidadeDAO"%>
<%@page import="model.Estado"%>
<%@page import="DAO.EstadoDAO"%>
<%@page import="model.Categoria"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Lugar"%>
<%@page import="DAO.LugarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lugares - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/EstiloLugares.css">
        <link rel="stylesheet" href="css/EstiloBtns.css">
        <link rel="stylesheet" href="css/EstiloCards.css">
        <link rel="stylesheet" href="css/EstiloFooter.css">
    </head>
    <body>
        <%!
            LugarDAO lugardao = new LugarDAO();
            //resetar List
            List<Lugar> lugares = null;

            CategoriaDAO categoriadao = new CategoriaDAO();
            List<Categoria> categorias = categoriadao.getCategoria();

            EstadoDAO estado = new EstadoDAO();
            List<Estado> estados = estado.getEstado();

            List<Cidade> cidades = CidadeDAO.getCidade();
        %>

        <style>
            .area-titulo h1{
                font-family: 'Roboto slab', serif !important;
            }
        </style>
        <nav class="navbar navbar-expand-md navbar-dark edit-nav" style="background-color: #4A44F2">
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
            <div class="row area-titulo">
                <h1>Lugares</h1>
            </div>
            <div class="row area-filtro">
                <div class="col-md-3">
                    <select class="filtroCatg form-control my-input custom-select" id="filtroCatg">
                        <option class="Selecione" value="selectCatg" disabled selected hidden>Categoria</option>
                        <%
                            for (Categoria categoria : categorias) {
                        %><option value="<%= categoria.getIdCategoria()%>"> <%= categoria.getNome()%> </option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="col-md-3">
                    <select class="filtroCatg form-control my-input custom-select"  id="filtroEst">
                        <option class="Selecione" value="selectEst" disabled selected hidden>Estado</option>
                        <%
                            for (Estado estado : estados) {
                        %><option value="<%= estado.getSigla()%>"> <%= estado.getNome()%> </option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="col-md-3">
                    <button class="filtroCatg btn my-button-accept" value="semFiltro" onclick="limpaFiltro()">Sem filtro</button>
                </div>
            </div>

            <div class="row area-card">
                <%
                    lugares = LugarDAO.getLugar();
                    for (Lugar lugar : lugares) {
                        //variaveis para colocar classe para filtar
                        int idCategoria = lugar.getCategoria().getIdCategoria();
                        int idCidade = lugar.getLocalizacao().getCidade().getIdCidade();
                        String siglaEst = lugar.getLocalizacao().getCidade().getEstado().getSigla();

                %>  <div class="col-md-3 my-card-col <%= idCategoria%> <%= siglaEst%>" style="">
                    <div class="card-container mycard" id="<%= lugar.getIdLugar()%>">
                        <div class="card-img" style="width: 100%">
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
                </div> <%
                    }
                %>
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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript">
                        var cards = $(".my-card-col");
                        var array = [];
                        $(".filtroCatg").on("change", function () {
                            let ctg = $(this).val();
                            console.log($(this).val());
                            console.log(cards);
                            $(cards).each(function () {
                                if (!$(this).hasClass(ctg)) {
                                    $(this).fadeOut();
                                } else {
                                    $(this).fadeIn();
                                }

                            }
                            );
                        });

                        var elementoCerto; //Variavel que vai armazenar o dados do usuário selecionado
                        //acho q deve ser um array na verdade

                        function limpaFiltro() {
                            let cards = $(".my-card-col");
                            $(cards).fadeIn();
                            $("#filtroCatg").val("selectCatg");
                            $("#filtroEst").val("selectEst");
                        }

        </script>
    </body>
</html>
