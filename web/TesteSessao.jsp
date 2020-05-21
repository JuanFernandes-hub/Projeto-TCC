
<%@page import="model.Lugar"%>
<%@page import="java.util.List"%>
<%@page import="DAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession(true);
            int id = (Integer) sessao.getAttribute("idUsuarioLogado");
            LoginDAO logindao = new LoginDAO();
            List<Lugar> lugares = logindao.getLugaresCad(id);
        %>


        <%
            if (sessao.getAttribute("nomeUsuarioLogado") != null) {
        %> <p> <%= sessao.getAttribute("idUsuarioLogado")%> </p> 
        <p> <%= sessao.getAttribute("nomeUsuarioLogado")%> </p>
        <p> <%= sessao.getAttribute("classeUsuarioLogado")%> </p>
        <a href="Sair.jsp">Sair</a>
        <%
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        %>




        <%
            for (Lugar lugar : lugares) {
        %>  <div class="col-md-4">
            <div class="card" name=" jbj" id="<%= lugar.getIdLugar()%>" onclick="geraPg(this)">
                <div class="card-body">
                    <h3 class="card-title"> <%= lugar.getNome()%> </h3>
                    <p class="card-text"><%= lugar.getCategoria().getNome()%></p>
                    <p class="card-text"><%= lugar.getDescricao()%></p>

                </div>

            </div>
            

        </div> <%
            }

        %>




        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- ajax -->
        <script src="js/GeraPgLugar.js"></script> <!-- Guarda dados perfil do lugar  -->
    </body>
</html>
