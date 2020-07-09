<%-- 
    Document   : CadastraLugar
    Created on : 10/04/2020, 00:59:09
    Author     : juann
--%>

<%@page import="model.Categoria"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page import="model.Estado"%>
<%@page import="DAO.EstadoDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/EstiloCadastraLugar.css">
        <link rel="stylesheet" href="css/EstiloInputLabel.css">
        <link rel="stylesheet" href="css/EstiloBtns.css">
        <link rel="stylesheet" href="css/EstiloFooter.css">
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession();
            if (sessao.getAttribute("idUsuarioLogado") == null) {%>
        <jsp:forward page="Login.jsp" />
        <% }
        %>


        <%!
            //Pegar estado para select
            EstadoDAO daoEstado = new EstadoDAO();
            List<Estado> estados = daoEstado.getEstado();

            //Pegar categorias para selecr
            CategoriaDAO daoCategoria = new CategoriaDAO();
            List<Categoria> categorias = daoCategoria.getCategoria();

        %>
        <style>
            .edit-nav{
                background-color: #4A44F2;
            }
        </style>

        <div class="container-fluid">
            <div class="row tela">
                <div class="col-md-4 area-titulo">
                    <h1>Cadas
                        tre
                        um
                        Lugar
                    </h1>
                </div>
                <div class="col-md-8 area-form">
                    <form action="CadastraLugar" method="post" onsubmit="return validaForm(this)" id="formLugar">
                        <div class="form-row my-form">
                            <div class="col">
                                <label class="my-label-form" for="nome">Nome*</label>
                                <input type="text" name="nNome" id="nome" class="form-control my-input" placeholder="Nome do lugar" autofocus required>
                            </div>
                            <div class="col">
                                <label class="my-label-form" for="categoria">Categoria*</label>
                                <select class="form-control my-input custom-select" name="nCategoria" id="categoria" required>
                                    <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                                    <%
                                        for (Categoria categoria : categorias) {
                                    %><option name="nCategoria" value="<% out.print(categoria.getIdCategoria()); %>"><% out.print(categoria.getNome());
                                        }
                                        %></option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label class="my-label-form" for="descricao">Descrição*</label>
                                <input type="text" name="nDescricao" id="descricao" class="form-control my-input" placeholder="Escreva uma frase que descreva o lugar">
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
                                <label class="my-label-form" for="horarioInicial">Abertura*</label>
                                <input type="text" name="nHorarioInicial" id="horarioInicial" class="form-control my-input" placeholder="08:00" required>
                            </div>
                            <div class="col">
                                <label class="my-label-form" for="horarioFinal">Fechamento*</label>
                                <input type="text" name="nHorarioFinal" id="horarioFinal" class="form-control my-input" placeholder="17:00" required>
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
                                <label class="my-label-form" for="estado">Estado*</label>
                                <select class="form-control my-input custom-select" name="nEstado" id="estado" required>
                                    <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                                    <%
                                        for (Estado estado : estados) {
                                            int id = estado.getIdEstado();
                                            String nome = estado.getNome();
                                    %><option name="nEstado" value="<% out.print(id); %>"><% out.print(nome);
                                        }
                                        %>
                                    </option>
                                </select>
                            </div>

                            <div class="col">
                                <label class="my-label-form" for="cidade">Cidade*</label>
                                <select class="form-control my-input custom-select" name="nCidade" id="cidade" required>
                                    <option value="" disabled selected hidden>Selecione...</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-md-5">
                                <label class="my-label-form" for="bairro">Bairro</label>
                                <input type="text" name="nBairro" id="bairro" class="form-control my-input" placeholder="Bairro">
                            </div>
                            <div class="col-md-5">
                                <label class="my-label-form" for="rua">Rua*</label>
                                <input type="text" name="nRua" id="rua" class="form-control my-input" placeholder="Rua dos bobos" required>
                            </div>
                            <div class="col-md-2">
                                <label class="my-label-form" for="">N</label>
                                <input type="text" name="nNumero" id="numero" class="form-control my-input" placeholder="0">
                            </div>
                        </div>

                        <div class="form-row mt-3">
                            <div class="col div-textarea">
                                <textarea class="my-input" name="nComplemento" id="complemento" placeholder="Digite alguns detalhes." rows="2"></textarea>
                            </div>
                        </div>

                        <div class="row mt-3 mb-5 justify-content-start"
                             style="margin-bottom: 0px !important; margin-left: 0px;">
                            <div class="mr-2">
                                <button type="submit" class="btn my-button-accept">Cadastrar</button>
                            </div>
                            <div class="ml-2">
                                <button class="btn my-button-cancel">Cancelar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                                    
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script> 
        <script type="text/javascript" src="js/jquery.mask.min.js"></script> <!-- MASCARAS -->
        <script type="text/javascript" src="js/Mascaras.js"></script> <!-- FORMATA MASCARAS -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- AJAX -->
        <script type="text/javascript" src="js/GetCidades.js"></script> <!-- MEU AJAX -->
        <script type="text/javascript" src="js/ValidaCadLugar.js"></script> <!-- Validação -->
    </body>
</html>
