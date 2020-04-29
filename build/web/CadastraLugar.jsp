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
        

        <!--
        
        -->
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

            <form action="CadastraLugar" method="post" class="col-sm-6" id="formLugar">
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
                        <%
                            for (Categoria categoria : categorias) {
                                %><option name="nCategoria" value="<% out.print(categoria.getIdCategoria()); %>"><% out.print(categoria.getNome());
                            }
                            %></option>
                    </select>
                </div>

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
                </div>

                <div class="form-group">
                    <label for="rua" class="" style="color: black;">Rua (opcional)</label>
                    <input type="text" class="form-control" name="nRua" id="rua" placeholder="R. Rio Branco">
                </div>

                <div class="form-group">
                    <label for="complemento" class="" style="color: black;">Complemento (opcional)</label>
                    <textarea class="form-control" name="nComplemento" id="complemento" placeholder="Digite alguns detalhes." rows="5"></textarea>
                </div>

                
                <button type="submit" id="botao" class="btn btn-warning">Enviar</button>
            </form>
        </div>

        
        <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN, DEVE SER A ULTIMA COISA ANTES DE FECHAR O BODY -->
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- ajax -->
        <script type="text/javascript" src="js/GetCidades.js"></script> <!-- Meu arquivo ajax -->
        <script>
            $(document).ready(function(){
               //console.log($("#estado").name);
               //console.log($("#cidade").name);
               //console.log($("#categoria").name);
               
               $("#cidade").change(function(){
                   console.log("Nome da cidade:"+$("#cidade :selected").text());
                   console.log("Value da cidade:"+$("#cidade").val());
                   
               });
               
               $("#categoria").change(function(){
                   //console.log($("#categoria").val());
                   //console.log(document.getElementsByName("nCategoria")[0].value)
                   
               });
                
            });
        </script>
    </body>
</html>
