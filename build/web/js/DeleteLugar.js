function deleteLugar() {
    let idLugar = dadosArquivados;
    let pesquisa = idLugar;
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
            window.location.assign('Home.jsp')
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $(".divBtn").html(jqXHR.responseText + "Desculpe.");
        }
    });
}
