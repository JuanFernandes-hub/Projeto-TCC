<%@page import="model.Login"%>
<%@page import="DAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar informações</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

        <%
            HttpSession sessao = request.getSession();
            if (sessao.getAttribute("idUsuarioLogado") == null) {%>
        <jsp:forward page="Login.jsp" />
        <%
            }%>

        <%!
            HttpSession sessao;
            String classeLog;
            int idLogin;
            String nomeLog;
            Login login;
        %>

        <%
            sessao = request.getSession();
            idLogin = (Integer) sessao.getAttribute("idUsuarioLogado");
            login = LoginDAO.getLogin(idLogin);
        %>

        <form id="formLogin" method="POST" action="UpdateLogin" onsubmit="">
            <label style="color: black;">Usuario:</label>
            <input type="text" class="dados form-control" id="usuario" name="nUsuario" style="color: black;"/>
            <br/>
            <label style="color: black;">Email:</label>
            <input type="email" class="dados form-control" id="email" name="nEmail" style="color: black;"/>
            <br/>

            <label style="color: black;">Confirme sua senha</label>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <div class="input-group-text" onclick="mostraSenha('#senha', '#olho1')" style="cursor: pointer">
                        <i id="olho1" class="far fa-eye-slash"></i>
                    </div>
                </div>
                <input type="password" class="dados form-control" id="senha" name="nSenha" style="color: black;"/>
            </div>

            <br/>

            <button type="submit" class="btn btn-primary" id="btnEditaLogin">Editar</button>
        </form>
        <a class="btn btn-primary" href="PerfilUsuario.jsp">Cancelar</a>
        <div id="resposta">

            <%
                if (request.getAttribute("mensagem") != null) {
                    out.print(request.getAttribute("mensagem"));
                }
            %>
        </div>


        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="js/ValidaLogin.js"></script>

        <script type="text/javascript">
            $(function () {
                $("#usuario").val("<%= login.getUsuario()%>");
                $("#email").val("<%= login.getEmail()%>");
            });
            //Mostrar senha
            function mostraSenha(input, icon) {
                if ($(input).attr("type") === "text") {
                    $(input).attr("type", "password");
                    $(icon).removeClass().addClass("far fa-eye-slash");
                } else if ($(input).attr("type") === "password") {
                    $(input).attr("type", "text");
                    $(icon).removeClass().addClass("far fa-eye");
                }
            }
        </script>
    </body>
</html>
