<%-- 
    Document   : newjsp
    Created on : 26/05/2020, 19:23:16
    Author     : juann
--%>

<%@page import="model.LoginLugar"%>
<%@page import="DAO.LoginLugarDAO"%>
<%@page import="javax.jms.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            var dadosArquivados = JSON.parse(sessionStorage.getItem('chave'));
            console.log(dadosArquivados);
            /* var update = JSON.parse(sessionStorage.getItem('update'));
            console.log(update);
            var coluna = JSON.parse(sessionStorage.getItem('coluna'));
            console.log(coluna); */
        </script>

        <%
            try {
                HttpSession sessao = request.getSession();
                int id = (Integer) sessao.getAttribute("idUsuarioLogado");
        %>
        <!-- Achar um jeito de alterar mandando coluna, novoValor, e id do Lugar -->
        
        <label style="color: black;">Nome:</label>
        <label class="dados" id="nome" style="color: black;"></label>
        <br/>
        <label style="color: black;">Avaliacao:</label>
        <label class="dados" id="avaliacao" style="color: black;"></label>
        <br/>
        <label style="color: black;">Categoria:</label>
        <label class="dados" id="categoria" style="color: black;"></label>
        <br/>
        <label style="color: black;">Acesso:</label>
        <label class="dados" id="acesso" style="color: black;"></label>
        <br/>
        <label style="color: black;">Abre:</label>
        <label class="dados" id="horaInicial" style="color: black;"></label>
        <br/>
        <label style="color: black;">Fecha:</label>
        <label class="dados" id="horaFinal" style="color: black;"></label>
        <br/>
        <label style="color: black;">Descrição:</label>
        <label class="dados" id="descricao" style="color: black;"></label>
        <br/>
        <label style="color: black;">Estado:</label>
        <label class="dados" id="estado" style="color: black;"></label>
        <br/>
        <label style="color: black;">Cidade:</label>
        <label class="dados" id="cidade" style="color: black;"></label>
        <br/>
        <label style="color: black;">Bairro:</label>
        <label class="dados" id="bairro" style="color: black;"></label>
        <br/>
        <label style="color: black;">Rua:</label>
        <label class="dados" id="rua" style="color: black;"></label>
        <br/>
        <label style="color: black;">N:</label>
        <label class="" id="numero" style="color: black;"></label>
        
        <button id="editar" onclick="window.location.assign('LugarUpdate.jsp')">Editar</button>

        <h1>Hello World!</h1>
        <%
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        %>


        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- AJAX -->
        <script type="text/javascript" src="js/GetLugar.js"></script> <!-- MEU AJAX para pegar lugar-->
    </body>
</html>
