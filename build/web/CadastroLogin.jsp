<%-- 
    Document   : CadastroLogin
    Created on : 02/04/2020, 22:10:58
    Author     : juann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/EstiloBtns.css">
        <link rel="stylesheet" href="css/EstiloInputLabel.css">
        <link rel="stylesheet" href="css/EstiloLogin.css">
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession();
            if (sessao.getAttribute("idUsuarioLogado") != null) {%>
        <jsp:forward page="PerfilUsuario.jsp" />
        <%
            }%>

        <%
            String mensagem = (String) request.getAttribute("mensagem");
        %>

        <div class="container-fluid">
            <div class="row tela">
                <div class="col-md-6 offset-sm-1 area-col">
                    <h1 class="">Cadastrar</h1>
                    <form method="POST" action="CadastraLogin" onsubmit="return validaForm(this)"> 
                        <div class="form-group row">
                            <label for="usuario" class="col-md-2">Usuário</label>
                            <div class="col-md-10">
                                <input class="my-input" type="text" name="nNome" id="usuario" placeholder="Crie um usuário" autofocus required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="" class="col-md-2">Email</label>
                            <div class="col-md-10">
                                <input class="my-input" type="email" name="nEmail" id="email" placeholder="Seu Email" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="senha" class="col-md-2">Senha</label>
                            <div class="col-md-10 input-group mb-3">
                                <div class="input-group-prepend">
                                    <div class="input-group-text" onclick="mostraSenha('#senha', '#olho1')"
                                         style="cursor: pointer;">
                                        <i id="olho1" class="far fa-eye-slash"></i>
                                    </div>
                                    <input type="password" class="my-input-icon" name="nSenha" id="senha" placeholder="Sua senha" required/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="senhaConf" class="col-md-2">Senha</label>
                            <div class="col-md-10 input-group mb-3" style="">
                                <div class="input-group-prepend">
                                    <div class="input-group-text" onclick="mostraSenha('#senhaConf', '#olho2')"
                                         style="cursor: pointer;">
                                        <i id="olho2" class="far fa-eye-slash"></i>
                                    </div>
                                    <input type="password" class="my-input-icon" id="senhaConf" name="nSenha"
                                           placeholder="Confirme sua senha" />
                                </div>
                            </div>
                        </div>



                        <div class="form-group row">
                            <div class="offset-sm-2 col-sm-10">
                                <button type="submit" class="btn my-button-accept">Salvar</button>
                                <a class="btn my-button-cancel" href="Login.jsp">Cancelar</a>
                            </div>
                        </div>
                        <%
                            if (mensagem != null) {%>
                        <p> <%= mensagem%> </p>
                        <%
                                mensagem = null;
                            }
                        %>
                    </form>
                </div>
                <div class="col-md-5 area-cap">

                </div>
            </div>
        </div>



        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/ValidaLogin.js"></script>
    </body>
</html>
