//botao deleta do PerfilUsuario
function btnDeleteLug(elem) {
    dadosArquivados = $(elem).val();
    console.log(dadosArquivados);
    deleteLugar();
}

function deleteLugar() {
    let idLugar = dadosArquivados;
    let pesquisa = idLugar;
    console.log(dadosArquivados);
    $.ajax({
        type: "GET",
        url: "DeletaLugar",
        data: {pesquisa: pesquisa},
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            console.log(data.mensagem);
            $('<p>', {
                text: data.mensagem
            }).appendTo('.divBtn');
            let janela = window.history.back();
            janela.reload(true);
            window.history.back();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $(".divBtn").html(jqXHR.responseText + "Desculpe.");
        }
    });
}
