<%-- 
    Document   : CadastroLugar
    Created on : 05/04/2020, 19:34:15
    Author     : juann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nome - Cadastre-se</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"> <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> <!-- pasta Bootstrap -->
        <link rel="stylesheet" href="css/EstilosCadastro.css"> <!-- css entrar -->
        <link rel="stylesheet" href="css/EstilosRodape.css"> <!-- css do rodape -->
    </head>
    <body>
        <div class="container">


            <form action="" method="post" class="col-sm-6">
                <div class="row justify-content-md-center">
                    <h1 style="color: black">Crie sua conta</h1>
                </div>

                <div class="form-group">
                    <label for="nome" class="" style="color: black;">Nome do lugar</label>
                    <input type="text" class="form-control" name="nNome" id="nome" placeholder="Nome" autofocus required>
                </div>

                <div class="form-group">
                    <label for="categoria" class="" style="color: black;">Categoria</label>
                    <select class="form-control" name="nCategoria" id="categoria">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="estado" class="" style="color: black;">Estado</label>
                    <select class="form-control" name="nEstado" id="estado">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="cidade" class="" style="color: black;">Cidade</label>
                    <select class="form-control" name="nCidade" id="cidade">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="rua" class="" style="color: black;">Rua (opcional)</label>
                    <input type="text" class="form-control" name="nRua" id="rua" placeholder="R. Rio Branco">
                </div>
                
                <div class="form-group">
                    <label for="complemento" class="" style="color: black;">Complemento (opcional)</label>
                    <textarea class="form-control" name="nRua" id="rua" placeholder="Digite alguns detalhes." rows="5"></textarea>
                </div>


                <button type="submit" class="btn btn-warning">Enviar</button>
            </form>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js"></script><!-- font awesome -->
        <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN, DEVE SER A ULTIMA COISA ANTES DE FECHAR O BODY -->
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> <!-- ajax -->
    </body>
</html>
