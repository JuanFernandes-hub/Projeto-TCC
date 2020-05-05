<%-- 
    Document   : Lugares
    Created on : 30/04/2020, 09:01:00
    Author     : juann
--%>

<%@page import="java.util.List"%>
<%@page import="model.Lugar"%>
<%@page import="DAO.LugarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            LugarDAO lugardao = new LugarDAO();
            List<Lugar> lista = lugardao.getLugar();
            for(Lugar lugar : lista){
                
            }
        %>
        <div class="container">
            
            
        </div>
        
        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- ajax -->
        
        <script>
            function teste(){
            div = $("div");
            div.text("Teste");
            }
        </script>
    </body>
</html>
