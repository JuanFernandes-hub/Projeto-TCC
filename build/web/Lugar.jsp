<%-- 
    Document   : TesteLugar
    Created on : 19/06/2020, 20:58:59
    Author     : juann
--%>

<%@page import="model.Classe"%>
<%@page import="model.LoginLugar"%>
<%@page import="DAO.LoginLugarDAO"%>
<%@page import="model.Cidade"%>
<%@page import="model.Estado"%>
<%@page import="java.sql.Time"%>
<%@page import="model.Categoria"%>
<%@page import="model.Lugar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lugar - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    </head>
    <body>
        <%
            Lugar lugar = (Lugar) request.getAttribute("lugar");
            String nome = lugar.getNome();
            float avaliacao = lugar.getAvaliacao();
            Categoria categoria = lugar.getCategoria();
            String acesso = lugar.getAcesso();
            Time horaInicial = lugar.getHoraInicial();
            Time horaFinal = lugar.getHoraInicial();
            String descricao = lugar.getDescricao();
            Estado estado = lugar.getLocalizacao().getCidade().getEstado();
            Cidade cidade = lugar.getLocalizacao().getCidade();
            String bairro = lugar.getLocalizacao().getBairro();
            String rua = lugar.getLocalizacao().getRua();
            String numero = lugar.getLocalizacao().getNumero();
        %>
        <label style="color: black;">Nome:</label>
        <label class="dados" id="nome" style="color: black;"><%= nome%></label>
        <br/>
        <label style="color: black;">Avaliacao:</label>
        <label class="dados" id="avaliacao" style="color: black;"><%= avaliacao%></label>
        <br/>
        <label style="color: black;">Categoria:</label>
        <label class="dados" id="categoria" style="color: black;"><%= categoria.getNome()%></label>
        <br/>
        <label style="color: black;">Acesso:</label>
        <label class="dados" id="acesso" style="color: black;"><%= acesso%></label>
        <br/>
        <label style="color: black;">Abre:</label>
        <label class="dados" id="horaInicial" style="color: black;"><%= horaInicial%></label>
        <br/>
        <label style="color: black;">Fecha:</label>
        <label class="dados" id="horaFinal" style="color: black;"><%= horaFinal%></label>
        <br/>
        <label style="color: black;">Descrição:</label>
        <label class="dados" id="descricao" style="color: black;"><%= descricao%></label>
        <br/>
        <label style="color: black;">Estado:</label>
        <label class="dados" id="estado" style="color: black;"><%= estado.getNome()%></label>
        <br/>
        <label style="color: black;">Cidade:</label>
        <label class="dados" id="cidade" style="color: black;"><%= cidade.getNome()%></label>
        <br/>
        <label style="color: black;">Bairro:</label>
        <label class="dados" id="bairro" style="color: black;"><%= bairro%></label>
        <br/>
        <label style="color: black;">Rua:</label>
        <label class="dados" id="rua" style="color: black;"><%= rua%></label>
        <br/>
        <label style="color: black;">N:</label>
        <label class="" id="numero" style="color: black;"><%= numero%></label>
        <div class="divBtn">
            <%!
                HttpSession sessao;
                String classeLog;
                int idLog;
                String nomeLog;

            %>
            <%
                try {
                    sessao = request.getSession();
                    idLog = (Integer) sessao.getAttribute("idUsuarioLogado");
                    classeLog = (String) sessao.getAttribute("classeUsuarioLogado");
                    nomeLog = (String) sessao.getAttribute("nomeUsuarioLogado");
                    LoginLugar loginlugar = LoginLugarDAO.getLugar(idLog, lugar.getIdLugar());
                    if (loginlugar != null || classeLog.equals("administrador")) {
            %>          
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalDeletaUsuario">
                Deletar
            </button>
            <a class="btn btn-primary" href="GetLugar?idLugar=<%= lugar.getIdLugar()%>&act=update">Editar</a>
            <%}
                } catch (Exception e) {
                }
            %>
        </div>

        <!-- MODAL DELETA LUGAR -->
        <div class="modal fade" id="ModalDeletaUsuario" tabindex="-1" role="dialog" aria-labelledby="TituloModalDeletaUsuario" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="TituloModalDeletaUsuario">Deletar <%= nome%></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Deseja excluir <%= nome%>? Você não conseguirá recuperá-lo depois.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <a href="DeleteLugar?idLugar=<%= lugar.getIdLugar()%>">Deletar</a>
                    </div>
                </div>
            </div>
        </div>

        <script>
            //id do Lugar clicado
            var dadosArquivados = JSON.parse(sessionStorage.getItem('chave'));
        </script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/GetLugar.js"></script> <!-- MEU AJAX para pegar lugar-->
    </body>
</html>
