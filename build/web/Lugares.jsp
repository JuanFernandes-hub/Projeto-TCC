<%@page import="model.Cidade"%>
<%@page import="DAO.CidadeDAO"%>
<%@page import="model.Estado"%>
<%@page import="DAO.EstadoDAO"%>
<%@page import="model.Categoria"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Lugar"%>
<%@page import="DAO.LugarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lugares - Colibri</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%!
            LugarDAO lugardao = new LugarDAO();
            //resetar List
            List<Lugar> lugares = null;
            
            CategoriaDAO categoriadao = new CategoriaDAO();
            List<Categoria> categorias = categoriadao.getCategoria();
            
            EstadoDAO estado = new EstadoDAO();
            List<Estado> estados = estado.getEstado();
            
            List<Cidade> cidades = CidadeDAO.getCidade();
        %>
        <div class="container">
            <select class="filtroCatg" id="filtroCatg">
                 <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                <%
                    for(Categoria categoria : categorias){
                %><option value="<%= categoria.getIdCategoria() %>"> <%= categoria.getNome() %> </option>
                        <%
                    }
                %>
            </select>
            
            <select class="filtroCatg">
                 <option class="Selecione" value="" disabled selected hidden>Selecione...</option>
                <%
                    for(Estado estado : estados){
                %><option value="<%= estado.getSigla() %>"> <%= estado.getNome() %> </option>
                        <%
                    }
                %>
            </select>
            
            <button class="filtroCatg" value="semFiltro" onclick="limpaFiltro()">Sem filtro</button>
            
            <%
                lugares = LugarDAO.getLugar();
                for (Lugar lugar : lugares) {
                    //variaveis para colocar classe para filtar
                    int idCategoria = lugar.getCategoria().getIdCategoria();
                    int idCidade = lugar.getLocalizacao().getCidade().getIdCidade();
                    String siglaEst = lugar.getLocalizacao().getCidade().getEstado().getSigla();
                    
            %>  <div class="col-md-4">
                <div class="card <%= lugar.getCategoria().getIdCategoria() %>">
                    <div class="card-body">
                        <h3 class="card-title"> <%= lugar.getNome() %> </h3>
                        <p class="card-text"><%= lugar.getCategoria().getNome() %></p>
                        <p class="card-text"><%= lugar.getDescricao() %></p>
                        <a href="GetLugar?idLugar=<%= lugar.getIdLugar()%>&act=get">Ver Mais</a>
                    </div>
                </div>
            </div> <%
                }
            %>

            
            

        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript">
            $(".filtroCatg").on("change",function(){
                let ctg = $(this).val();
                let cards = $(".card")
                console.log(ctg);
                //$(cards).fadeOut();
                $(cards).each(function(){
                    if(!$(this).hasClass(ctg)){
                        $(this).fadeOut();
                    }
                })
            });
            
            function limpaFiltro(){
                let cards = $(".card");
                $(cards).fadeIn();
            }

        </script>
    </body>
</html>
