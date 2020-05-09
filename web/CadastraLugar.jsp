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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Colibri - Cadastro de Lugares</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"> <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> <!-- pasta Bootstrap -->
        <link rel="stylesheet" href="css/EstilosCadastro.css"> <!-- css entrar -->
        <link rel="stylesheet" href="css/EstilosRodape.css"> <!-- css do rodape -->



    </head>
    <body>


        <div class="container">

            <%!
                //Pegar estado para select
                EstadoDAO daoEstado = new EstadoDAO();
                List<Estado> estados = daoEstado.getEstado();

                //Pegar categorias para selecr
                CategoriaDAO daoCategoria = new CategoriaDAO();
                List<Categoria> categorias = daoCategoria.getCategoria();
            %>

            <form action="CadastraLugar" method="post" onsubmit="return validaForm(this)" class="col-sm-6" id="formLugar">
                <div class="row justify-content-md-center">
                    <h1 style="color: black">Crie sua conta</h1>
                </div>

                <div class="form-group">
                    <label for="nome" class="" style="color: black;">Nome do lugar</label>
                    <input type="text" class="form-control" name="nNome" id="nome" placeholder="Nome" autofocus required>
                </div>

                <!-- SELECT CATEGORIAS -->
                <div class="form-group">
                    <label for="categoria" class="" style="color: black;">Categoria</label>
                    <select class="form-control" name="nCategoria" id="categoria">
                        <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                        <%
                            for (Categoria categoria : categorias) {
                        %><option name="nCategoria" value="<% out.print(categoria.getIdCategoria()); %>"><% out.print(categoria.getNome());
                            }
                            %></option>
                    </select>
                </div>




                <div class="form-row ">
                    <div class="col-5">
                        <label for="acesso">Acesso</label>
                        <select class="form-control" name="nAcesso" id="acesso" required>
                            <option name="nAcesso" value="gratuito">Gratuito</option>
                            <option name="nAcesso" value="pago">Pago</option>
                            <option name="nAcesso" value="Requer Permissão">Requer Permissão</option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="horarioInicial" class="" style="color: black;">Das</label>
                        <input type="text" class="form-control" name="nHorarioInicial" id="horarioInicial" placeholder="08:00" required>
                    </div>
                    <div class="col">
                        <label for="horarioFinal" class="" style="color: black;">Às</label>
                        <input type="text" class="form-control" name="nHorarioFinal" id="horarioFinal" placeholder="17:00" required>
                    </div>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="semHorario" value="semHorario">
                    <label class="form-check-label" for="semHorario">Sem horário</label>
                </div>

                <br>
                <br>

                <!-- SELECT ESTADO-->
                <div class="form-group">
                    <label for="estado" class="" style="color: black;">Estado</label>
                    <select class="form-control" name="nEstado" id="estado" required>
                        <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                        <%
                            for (Estado estado : estados) {
                                int id = estado.getIdEstado();
                                String nome = estado.getNome();
                        %><option name="nEstado" value="<% out.print(id); %>"><% out.print(nome);
                            }
                            %></option>
                    </select>
                </div>


                <!-- SELECT CIDADE -->
                <div class="form-group" >
                    <label for="cidade" class="" style="color: black;">Cidade</label>
                    <select class="form-control" name="nCidade" id="cidade" required>
                        <!-- option gerados por ajax, de acordo com o estado selecionado -->
                        <option value="" disabled selected hidden>Selecione...</option>
                    </select>
                    <small><i>Selecione um estado primeiro</i></small>
                </div>

                <div class="form-group">
                    <label for="bairro" class="" style="color: black;">Bairro</label>
                    <input type="text" class="form-control" name="nBairro" id="bairro" placeholder="Bairro" required >
                </div>

                <div class="form-group">
                    <label for="rua" class="" style="color: black;">Rua</label>
                    <input type="text" class="form-control" name="nRua" id="rua" placeholder="R. Rio Branco" required>
                </div>

                <div class="form-group">
                    <label for="numero" class="" style="color: black;">N° (opcional)</label>
                    <input type="text" class="form-control" name="nNumero" id="numero" placeholder="Número">
                </div>

                <div class="form-group">
                    <label for="complemento" class="" style="color: black;">Complemento (opcional)</label>
                    <textarea class="form-control" name="nComplemento" id="complemento" placeholder="Digite alguns detalhes." rows="5"></textarea>
                </div>

                <br>

                <div class="form-group">
                    <label for="descricao" class="" style="color: black;">Descrição</label>
                    <input type="text" class="form-control" name="nDescricao" id="descricao" placeholder="Descreva o lugar em uma frase">
                </div>




                <button type="submit" id="botao" class="btn btn-warning">Enviar</button>
            </form>
        </div>


        <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN -->
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script> <!-- MASCARAS -->
        <script type="text/javascript" src="js/jquery.mask.min.js"></script> <!-- MASCARAS -->
        <script type="text/javascript" src="js/Mascaras.js"></script> <!-- FORMATA MASCARAS -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- AJAX -->
        <script type="text/javascript" src="js/GetCidades.js"></script> <!-- MEU AJAX -->
        <script type="text/javascript" src="js/ValidaCadLugar.js"></script> <!-- Validação -->


    </body>
</html>
