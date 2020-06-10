<%-- 
    Document   : Input
    Created on : 08/06/2020, 16:23:26
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
        <div class="ui-widget">
            <label for="birds">Birds: </label>
            <input id="birds">
        </div>

        <div class="ui-widget" style="margin-top:2em; font-family:Arial">
            Result:
            <div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
        </div>
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script type="text/javascript">
            $(function () {
                function log(message) {
                    $("<div>").text(message).prependTo("#log");
                    $("#log").scrollTop(0);
                }

                $("#birds").autocomplete({
                    source: ajax(),
                    minLength: 2,
                    select: function (event, ui) {
                        log("Selected: " + ui.item.value + " aka " + ui.item.id);
                    }
                });

                function ajax(pesquisa){
                    $.ajax({
                    type: "GET",
                    url: "GetLugar",
                    data: {pesquisa: pesquisa},
                    dataType: "json",
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        var nome = data.dados.nome;
                        $("#nome").append(nome);
                        console.log(data.dados);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $("#resposta").html(jqXHR.responseText + "Desculpe.");
                    },
                    beforeSend: function (xhr) {
                        $("#botao").attr("disabled", true);
                    },
                    complete: function (jqXHR, textStatus) {
                        $("#botao").attr("disabled", false);
                    }
                });
                }
                
            });
        </script>
    </body>
</html>
