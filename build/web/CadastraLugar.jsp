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
<%@page import="DAO.CidadeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nome - Cadastre-se</title>
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
                CidadeDAO dao = new CidadeDAO();
                List<Cidade> cidades = dao.getCidade();
                
                EstadoDAO daoEstado = new EstadoDAO();
                List<Estado> estados = daoEstado.getEstado();
                
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

                <div class="form-group">
                    <label for="categoria" class="" style="color: black;">Categoria</label>
                    <select class="form-control" name="nCategoria" id="categoria" onchange="pegaCategoria(this.value)">
                        <%
                            for (Categoria categoria : categorias) {
                                %><option name="nCategoria" value="<% out.print(categoria.getIdCategoria()); %>"><% out.print(categoria.getNome());
                            }
                            %></option>
                        
                        <script type="text/javascript">
                            function pegaCategoria(valor){
                                console.log(valor);
                                return valor;
                            }
                        </script>
                        <!-- teste-->
                        <script type="text/javascript"> 
                            console.log();
                        </script>
                    </select>
                </div>

                <div class="form-group">
                    <label for="estado" class="" style="color: black;">Estado</label>
                    <select class="form-control" name="nEstado" id="estado" onchange="pegaCategoria(this.value)">
                        <%
                            for (Estado estado : estados) {
                        %><option value="<% out.print(estado.getIdEstado()); %>"><% out.print(estado.getNome());
                            }
                            %></option>
                    </select>
                    
                    <!--teste de ajax-->
                    <div id="resposta">
                        ???
                    </div>
                </div>
                    
                    

                <div class="form-group" >
                    <label for="cidade" class="" style="color: black;">Cidade</label>
                    <select class="form-control" name="nCidade" id="cidade" placeholder="Escolha uma cidade" onchange="pegaCategoria(this.value)">
                        <%
                            for (Cidade cidade : cidades) {
                        %><option value="<% out.print(cidade.getIdCidade()); %>"><% out.print(cidade.getNome());
                            }
                            %></option>

                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                        
                        <script type="text/javascript">
                            console.log(document.getElementsByName("nCidade"));
                            console.log(document.getElementsByName("nCategoria"));
                        </script>
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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script><!-- font awesome -->
        <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN, DEVE SER A ULTIMA COISA ANTES DE FECHAR O BODY -->
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- ajax -->
        <script type="text/javascript" src="js/GetCidades.js"></script> <!-- Meu arquivo ajax -->
    </body>
</html>
