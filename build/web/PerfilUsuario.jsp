<%-- 
    Document   : PerfilUsuario
    Created on : 21/05/2020, 19:16:32
    Author     : juann
--%>

<%@page import="model.Lugar"%>
<%@page import="java.util.List"%>
<%@page import="DAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try {
                HttpSession sessao = request.getSession();
                int id = (Integer) sessao.getAttribute("idUsuarioLogado");
                LoginDAO logindao = new LoginDAO();
                List<Lugar> lugares = logindao.getLugaresCad(id);

                if (sessao.getAttribute("nomeUsuarioLogado") != null
                   && !sessao.getAttribute("nomeUsuarioLogado").equals("")) {
        %>          <p> <%= sessao.getAttribute("idUsuarioLogado")%> </p>
                    <p> <%= sessao.getAttribute("nomeUsuarioLogado")%> </p>
                    <p> <%= sessao.getAttribute("classeUsuarioLogado")%> </p>
                    <a href="Sair.jsp">Sair</a> <%
                    }
                        
                for (Lugar lugar : lugares) {
        %>  <div class="col-md-4">
            <div class="card" name=" jbj" id="<%= lugar.getIdLugar()%>" onclick="geraPg(this)">
                <div class="card-body">
                    <h3 class="card-title"> <%= lugar.getNome()%> </h3>
                    <p class="card-text"><%= lugar.getCategoria().getNome()%></p>
                    <p class="card-text"><%= lugar.getDescricao()%></p>

                </div>
                    <a href="DeletaLugar?id=<%= lugar.getIdLugar() %>">Deletar</a>
            </div>
            

        </div> <%
            }
                
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        %>


    </body>
</html>
