<%@page import="model.Lugar"%>
<%@page import="java.util.List"%>
<%@page import="DAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Colibri - Perfil</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
        <a href="SairPerfil">Sair</a> <br/>
       
        <!-- Botão para acionar modal de deletar conta-->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalDeletaConta">
            Deletar Conta
        </button> <br/>
        
        <a href="CadastraLugar.jsp" class="btn btn-primary">Cadastra Lugar</a>

        

        <%
            }

            for (Lugar lugar : lugares) {
        %>  <div class="col-md-4">
            <div class="card" id="<%= lugar.getIdLugar()%>" onclick="geraPg(this)">
                <div class="card-body">
                    <h3 class="card-title"> <%= lugar.getNome()%> </h3>
                    <p class="card-text"><%= lugar.getCategoria().getNome()%></p>
                    <p class="card-text"><%= lugar.getDescricao()%></p>

                </div>

            </div>
            <button id="deletar" value="<%= lugar.getIdLugar()%>" onclick="btnDeleteLug(this)" >Deletar</button><!-- Colocar dentro do card, Arruma onmouseover do card para poder clicar no link-->


        </div> <%
                }

            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        %>
        
        <!-- MODAL DELETA CONTA  (algum problema em pegar variavel)-->
        <div class="modal fade" id="ModalDeletaConta" tabindex="-1" role="dialog" aria-labelledby="TituloModalDeletaConta" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="TituloModalDeletaConta">Deletar conta</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Deseja excluir sua conta? Você não conseguirá recuperá-la depois e seus lugares cadastrados serão excluídos da plataforma.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <a href="DeletaPerfil" class="btn btn-primary" role="button">Deletar</a>
                    </div>
                </div>
            </div>
        </div>

        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="js/GeraPgLugar.js"></script> <!-- Guarda dados perfil do lugar  -->
        <script src="js/DeleteLugar.js"></script>
    </body>
</html>
