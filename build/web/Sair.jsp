<%-- 
    Document   : Sair
    Created on : 19/05/2020, 09:56:18
    Author     : juann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession(false);
            sessao.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        %>
    </body>
</html>
