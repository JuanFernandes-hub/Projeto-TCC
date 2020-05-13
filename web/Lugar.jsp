
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
        <label class="" id="resposta" style="color: black;"></label>
        <label class="" id="Nome" style="color: black;"></label>
        <label class="" id="Categoria" style="color: black;"></label>
        <label class="" id="Estado" style="color: black;"></label>
        <label class="" id="Cidade" style="color: black;"></label>

        
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- AJAX -->
        <script type="text/javascript" src="js/GetLugar.js"></script> <!-- MEU AJAX -->
    </body>
</html>
