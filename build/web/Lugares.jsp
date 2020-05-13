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
        <title>Colibri - Lugares</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%
            LugarDAO lugardao = new LugarDAO();
            List<Lugar> lugares = lugardao.getLugar();
        %>
        <div class="container">
            <%
                for (Lugar lugar : lugares) {
            %>  <div class="col-md-4">
                <div class="card" name=" jbj" id="<% out.print(lugar.getIdLugar()); %>" onclick="geraPg(this);">
                    <div class="card-body">
                        <h3 class="card-title"> <% out.print(lugar.getNome()); %> </h3>
                        <p class="card-text"><% out.print(lugar.getDescricao()); %></p>
                    </div>
                </div>
            </div> <%
                }
            %>


        </div>

        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- ajax -->
        <script type="text/javascript">
                    function geraPg(e) {
                        //redirecionar para uma página
                        
                         //console.log($(e).find(".card-title").text());
                         //id = $(e).attr("id");
                         //console.log(id);
                         

                        var dados = JSON.stringify($(e).attr("id"));
                        sessionStorage.setItem('chave', dados);
                        window.location.assign("Lugar.jsp");


                       
                    }



                    //criar função que recebe id do card e buscar dados para por em campos



        </script>
    </body>
</html>
