<%-- 
    Document   : UpdateLugar
    Created on : 20/06/2020, 16:00:19
    Author     : juann
--%>

<%@page import="model.Lugar"%>
<%@page import="model.Categoria"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page import="model.Estado"%>
<%@page import="java.util.List"%>
<%@page import="DAO.EstadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Lugar - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/EstiloBtns.css">
        <link rel="stylesheet" href="css/EstiloUpdateLugar.css">
    </head>
    <body>

        <%
            HttpSession sessao = request.getSession();
            if (sessao.getAttribute("idUsuarioLogado") == null) {%>
        <jsp:forward page="Home.jsp" />
        <%
            }%>
        <%!
            //Pegar estado para select
            EstadoDAO daoEstado = new EstadoDAO();
            List<Estado> estados = daoEstado.getEstado();

            //Pegar categorias para selecr
            CategoriaDAO daoCategoria = new CategoriaDAO();
            List<Categoria> categorias = daoCategoria.getCategoria();

            Lugar lugar;
        %>
        <%
            lugar = (Lugar) request.getAttribute("lugar");
        %>

        <div class="container-fluid">
            <div class="row tela">
                <div class="col-md-4 area-titulo">
                    <h1>Edi
                        tar 
                        lugar
                    </h1>
                </div>
                <div class="col-md-8 area-form">
                    <form method="POST" action="UpdateLugar?idLugar=<%= lugar.getIdLugar() %>" onsubmit="return validaForm(this)">
                        <div class="form-row my-form">
                            <div class="col">
                                <label class="my-label-form" for="">Nome</label>
                                <input type="text" class="form-control my-input" id="nome" name="nNome" required placeholder="Nome do lugar">
                            </div>
                            <div class="col">
                                <label class="my-label-form" for="">Categoria</label>
                                <select class="form-control my-input custom-select" name="nCategoria" id="categoria" required>
                                    <option class="Selecione" value="" disabled selected hidden>Selecione uma categoria</option>
                                    <%
                                        for (Categoria categoria : categorias) {
                                    %><option name="nCategoria" value="<%= categoria.getIdCategoria() %>"> <%= categoria.getNome()%> <% }%></option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label class="my-label-form" for="">Descrição</label>
                                <input type="text" class="form-control my-input" id="descricao" name="nDescricao" placeholder="Escreva uma frase que descreva o lugar">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label class="my-label-form" for="acesso">Acesso*</label>
                                <select class="form-control my-input custom-select" name="nAcesso" id="acesso" required>
                                    <option name="nAcesso" value="gratuito">Gratuito</option>
                                    <option name="nAcesso" value="pago">Pago</option>
                                    <option name="nAcesso" value="Requer Permissão">Requer Permissão</option>
                                </select>
                            </div>
                            <div class="col">
                                <label class="my-label-form" for="horarioInicial">Abertura</label>
                                <input type="text" class="form-control my-input" name="nHoraInicial" id="horarioInicial" required placeholder="08:00">
                            </div>
                            <div class="col">
                                <label class="my-label-form" for="horarioFinal">Fechamento</label>
                                <input type="text" class="form-control my-input" name="nHoraFinal" id="horarioFinal" required placeholder="17:00">
                            </div>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input my-input" type="checkbox" id="semHorario" value="semHorario">
                            <label class="my-label-form my-label-checkbox" class="form-check-label" for="semHorario">
                                Sem horário
                            </label>
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label class="my-label-form" for="">Estado</label>
                                <select class="form-control my-input custom-select" name="nEstado" id="estado" required>
                                    <option class="Selecione" value="" disabled selected hidden>Selecione um Estado</option>
                                    <%
                                        for (Estado estado : estados) {
                                            int idEst = estado.getIdEstado();
                                            String nome = estado.getNome();
                                    %><option name="nEstado" value="<% out.print(idEst); %>"><% out.print(nome);
                                        }
                                        %></option>
                                </select>
                            </div>

                            <div class="col">
                                <label class="my-label-form" for="">Cidade</label>
                                <select class="form-control my-input custom-select" name="nCidade" id="cidade" required>
                                    <option value="" disabled selected hidden>Selecione um Estado primeiro</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-md-5">
                                <label class="my-label-form" for="">Bairro</label>
                                <input type="text" class="form-control my-input" id="bairro" name="nBairro" placeholder="Bairro">
                            </div>
                            <div class="col-md-5">
                                <label class="my-label-form" for="">Rua</label>
                                <input type="text" class="form-control my-input" id="rua" name="nRua" required placeholder="Rua">
                            </div>
                            <div class="col-md-2">
                                <label class="my-label-form" for="">N</label>
                                <input type="text" class="form-control my-input" id="numero" name="nNumero" placeholder="número">
                            </div>
                        </div>

                        <div class="form-row mt-3">
                            <div class="col div-textarea">
                                <textarea class="my-input" name="nComplemento" id="complemento" rows="2" placeholder="Fale um pouco sobre o lugar"></textarea>
                            </div>
                        </div>

                        <div class="row mt-3 mb-5 justify-content-start"
                             style="margin-bottom: 0px !important; margin-left: 0px;">
                            <div class="mr-2">
                                <button type="submit" class="btn my-button-accept">Salvar</button>
                            </div>
                            <div class="ml-2">
                                <button onclick="window.history.back()" class="btn my-button-cancel">Cancelar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- AJAX -->
        <script type="text/javascript" src="js/GetCidades.js"></script><!-- MEU AJAX pegar cidades-->
        <script src="js/ValidaCadLugar.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/Mascaras.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#nome").val("<%= lugar.getNome() %>");
                $("#avaliacao").val("<%= lugar.getAvaliacao() %>");
                $("#categoria").val("<%= lugar.getCategoria().getIdCategoria() %>");
                $("#acesso").val("<%= lugar.getAcesso() %>");
                
                //Formatar data HH:mm
                let horaInicial = "<%= lugar.getHoraInicial() %>";
                let horaFinal = "<%= lugar.getHoraFinal() %>";
                let horaInicialFormt = horaInicial.split(":",2);
                let horaFinalFormt = horaFinal.split(":",2);
                $("#horarioInicial").val(horaInicialFormt[0]+":"+horaInicialFormt[1]);
                $("#horarioFinal").val(horaFinalFormt[0]+":"+horaFinalFormt[1]);
                
                $("#estado").val("<%= lugar.getLocalizacao().getCidade().getEstado().getIdEstado() %>");
                $("#cidade").val("<%= lugar.getLocalizacao().getCidade().getIdCidade() %>");
                $("#bairro").val("<%= lugar.getLocalizacao().getBairro() %>");
                $("#rua").val("<%= lugar.getLocalizacao().getRua() %>");
                $("#numero").val("<%= lugar.getLocalizacao().getNumero() %>");
                $("#complemento").val("<%= lugar.getLocalizacao().getComplemento() %>");
                $("#descricao").val("<%= lugar.getDescricao() %>");
            });
        </script>
    </body>
</html>
