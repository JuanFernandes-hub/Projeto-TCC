
<%@page import="java.util.List"%>
<%@page import="DAO.LugarDAO"%>
<%@page import="model.Lugar"%>
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
        </script>
        <label style="color: black;">Nome:</label>
        <label class="" id="nome" style="color: black;"></label>
        <br/>
        <label style="color: black;">Avaliacao:</label>
        <label class="" id="avaliacao" style="color: black;"></label>
        <br/>
        <label style="color: black;">Categoria:</label>
        <label class="" id="categoria" style="color: black;"></label>
        <br/>
        <label style="color: black;">Acesso:</label>
        <label class="" id="acesso" style="color: black;"></label>
        <br/>
        <label style="color: black;">Abre:</label>
        <label class="" id="horaInicial" style="color: black;"></label>
        <br/>
        <label style="color: black;">Fecha:</label>
        <label class="" id="horaFinal" style="color: black;"></label>
        <br/>
        <label style="color: black;">Descrição:</label>
        <label class="" id="descricao" style="color: black;"></label>
        <br/>
        <label style="color: black;">Estado:</label>
        <label class="" id="estado" style="color: black;"></label>
        <br/>
        <label style="color: black;">Cidade:</label>
        <label class="" id="cidade" style="color: black;"></label>
        <br/>
        <label style="color: black;">Bairro:</label>
        <label class="" id="bairro" style="color: black;"></label>
        <br/>
        <label style="color: black;">Rua:</label>
        <label class="" id="rua" style="color: black;"></label>
        <br/>
        <label style="color: black;">N:</label>
        <label class="" id="numero" style="color: black;"></label>

        
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- AJAX -->
        <script type="text/javascript" src="js/GetLugar.js"></script> <!-- MEU AJAX -->
    </body>
</html>
