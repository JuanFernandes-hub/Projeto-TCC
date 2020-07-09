<%@page import="model.Login"%>
<%@page import="DAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar informações - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/EstiloCadastraLugar.css">
        <link rel="stylesheet" href="css/EstiloBtns.css">
        <link rel="stylesheet" href="css/EstiloInputLabel.css">
        <link rel="stylesheet" href="css/EstiloUpdateLogin.css">
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

        <div class="container-fluid">
            <div class="row tela">
                <div class="col-md-6 offset-sm-1 area-col">
                    <h1 class="">Perfil</h1>
                    <form method="POST" action="UpdateLogin">
                        <div class="form-group row">
                            <label for="usuario" class="col-md-2">Usuário</label>
                            <div class="col-md-10">
                                <input type="text" class="my-input" id="usuario" name="nUsuario">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="email" class="col-md-2" >Email</label>
                            <div class="col-md-10">
                                <input type="email" class="my-input" id="email" name="nEmail">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="" class="col-md-2">Senha</label>
                            <div class="col-md-10 input-group mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text" onclick="mostraSenha('#senha', '#olho1')"
                                         style="cursor: pointer;">
                                        <i id="olho1" class="far fa-eye-slash"></i>
                                    </div>
                                    <input type="password" class="my-input-icon" id="senha" name="nSenha" placeholder="Confirme sua senha" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="offset-sm-2 col-sm-10">
                                <button type="submit" class="btn my-button-accept" id="btnEditaLogin">Salvar</button>
                                <a class="btn my-button-cancel" href="PerfilUsuario.jsp" >Cancelar</a/9++j>
                            </div>
                        </div>
                    </form>
                    <div id="resposta">

                        <%
                            if (request.getAttribute("mensagem") != null) {
                                out.print(request.getAttribute("mensagem"));
                            }
                        %>
                    </div>
                </div>
                <div class="col-md-5 area-cap">

                </div>
            </div>
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
