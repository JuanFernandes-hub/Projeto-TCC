//Cria botão de editar e deletar, se o usuario logado for quem cadastrou
$(function () {
    var pesquisa = dadosArquivados;
    $.ajax({
        type: "GET",
        url: "BtnUpdate",
        data: {pesquisa: pesquisa},
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            var UsuarioCadastrou = data.dados;
            var admLogado = data.dados2;
            if (UsuarioCadastrou || admLogado) {
                $('<button>', {
                    text: "Editar",
                    id: "editar",
                    onclick: "window.location.assign('LugarUpdate.jsp')"
                }).appendTo('.divBtn');
                
                $('<button>', {
                    text: "Deletar",
                    id: "deletar",
                    onclick: "deleteLugar()"
                }).appendTo('.divBtn');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $(".divBtn").html(jqXHR.responseText + "Desculpe.");
        },
    });
});

