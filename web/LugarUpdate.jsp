<%-- 
    Document   : LugarUpdate
    Created on : 27/05/2020, 18:47:23
    Author     : juann
--%>

<%@page import="DAO.CategoriaDAO"%>
<%@page import="model.Estado"%>
<%@page import="java.util.List"%>
<%@page import="DAO.EstadoDAO"%>
<%@page import="model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"> <!-- Bootstrap -->
        <!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> <!-- pasta Bootstrap -->
    </head>
    <body>
        <script>
            var dadosArquivados = JSON.parse(sessionStorage.getItem('chave'));
            console.log(dadosArquivados);
        </script>

        <%!
            //Pegar estado para select
            EstadoDAO daoEstado = new EstadoDAO();
            List<Estado> estados = daoEstado.getEstado();

            //Pegar categorias para selecr
            CategoriaDAO daoCategoria = new CategoriaDAO();
            List<Categoria> categorias = daoCategoria.getCategoria();

        %>

        <%
            try {
                HttpSession sessao = request.getSession();
                int id = (Integer) sessao.getAttribute("idUsuarioLogado");
        %>
        <form id="formLugar" name="nFormLugar" method="post" action="UpdateLugar" onsubmit="return validaForm(this)">
            <label style="color: black;">ID:</label>
            <input class="dados form-control" id="id" name="nId" readonly style="color: black;"/>
            <br/>
            <label style="color: black;">Nome:</label>
            <input class="dados form-control" id="nome" name="nNome" required style="color: black;"/>
            <br/>
            <label style="color: black;">Avaliacao:</label>
            <input class="dados form-control" id="avaliacao" name="nAvaliacao" style="color: black;"/>
            <br/>
            <label style="color: black;">Categoria:</label>
            <select class="dados form-control" name="nCategoria" id="categoria" required>
                <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                <%
                    for (Categoria categoria : categorias) {
                %><option name="nCategoria" value="<% out.print(categoria.getIdCategoria()); %>"><% out.print(categoria.getNome());
                    }
                    %></option>
            </select>
            <br/>
            <label style="color: black;">Acesso:</label>
            <select class="dados form-control" name="nAcesso" id="acesso" required>
                <option name="nAcesso" value="gratuito">Gratuito</option>
                <option name="nAcesso" value="pago">Pago</option>
                <option name="nAcesso" value="Requer Permissão">Requer Permissão</option>
            </select>
            <br/>
            <br/>
            <label style="color: black;">Abre:</label>
            <input class="dados form-control" id="horarioInicial" name="nHoraInicial" style="color: black;"/>
            <br/>
            <label style="color: black;">Fecha:</label>
            <input class="dados form-control" id="horarioFinal" name="nHoraFinal" style="color: black;"/>
            <br/>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="semHorario" value="semHorario">
                <label class="form-check-label" for="semHorario">Sem horário</label>
            </div>
            <br/>
            <label style="color: black;">Estado:</label>
            <select class="form-control" name="nEstado" id="estado" required>
                <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                <%
                    for (Estado estado : estados) {
                        int idEst = estado.getIdEstado();
                        String nome = estado.getNome();
                %><option name="nEstado" value="<% out.print(idEst); %>"><% out.print(nome);
                    }
                    %></option>
            </select>
            <br/>
            <label style="color: black;">Cidade:</label>
            <select class="form-control" name="nCidade" id="cidade" required>
                <option value="" disabled selected hidden>Selecione...</option>
            </select>
            <br/>
            <label style="color: black;">Bairro:</label>
            <input class="dados form-control" id="bairro" name="nBairro" required style="color: black;"/>
            <br/>
            <label style="color: black;">Rua:</label>
            <input class="dados form-control" id="rua" name="nRua" required style="color: black;"/>
            <br/>
            <label style="color: black;">N:</label>
            <input class="dados form-control" id="numero" name="nNumero" style="color: black;"/>
            <br/>
            <label for="complemento" class="" style="color: black;">Complemento (opcional)</label>
            <textarea class="form-control" name="nComplemento" id="complemento" placeholder="Digite alguns detalhes." rows="5"></textarea>
            <br/>
            <label style="color: black;">Descrição:</label>
            <input class="dados form-control" id="descricao" name="nDescricao" style="color: black;"/>
            <br/>
            <button id="botao" type="submit">Salvar</button>
        </form>
        <button  onclick="window.location.assign('newjsp.jsp');">Cancelar</button>

        <h1>Hello World!</h1>
        <%
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        %>

        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- AJAX -->
        <script type="text/javascript" src="js/GetCidades.js"></script><!-- MEU AJAX pegar dados-->
        <script type="text/javascript" src="js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="js/Mascaras.js"></script>
        <script type="text/javascript" src="js/ValidaCadLugar.js"></script>
        <script type="text/javascript" src="js/UpdateLugar.js"></script> <!-- MEU AJAX  para atualizar dados-->
        <!--<script type="text/javascript" src="js/GetCidades.js"></script> -->

    </body>
</html>
