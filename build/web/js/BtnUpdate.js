$(function(){
    var pesquisa = dadosArquivados;
    $.ajax({
        type: "GET",
        url: "BtnUpdate",
        data: {pesquisa: pesquisa},
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            var UsuarioCadastrou = data.dados;
            console.log(UsuarioCadastrou);
            if (UsuarioCadastrou) {
                $("#editar").css("visibility", "visible");
            } else {
                $("#editar").css("visibility", "hidden");
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $("#resposta").html(jqXHR.responseText + "Desculpe.");
        },
        beforeSend: function (xhr) {
            $("#botao").attr("disabled", true);
            //$("#cidade").html("Aguarde...")
        },
        complete: function (jqXHR, textStatus) {
            $("#botao").attr("disabled", false);
        }
    });
});

