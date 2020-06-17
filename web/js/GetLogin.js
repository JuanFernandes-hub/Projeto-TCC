$(document).ready(function () {

    //Ajax para puxar dados do Lugar 
    var pesquisa = JSON.parse(sessionStorage.getItem('idLogin'));
    console.log("IDLOGADO: "+pesquisa);

    $.ajax({
        type: "GET",
        url: "GetLogin",
        data: {pesquisa: pesquisa},
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            let id = data.dados.idUsuario;
            let usuario = data.dados.usuario;
            let email = data.dados.email;
            let senha = data.dados.senha;
            $("#id").val(id);
            $("#usuario").val(usuario);
            $("#email").val(email);
            $("#senha").val(senha);
            $("#senhaConf").val(senha);
            //console.log(data.dados);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            //$("#resposta").html(jqXHR.responseText + "Desculpe.");
        },
        beforeSend: function (xhr) {
            $("#btnEditaLogin").attr("disabled", true);
        },
        complete: function (jqXHR, textStatus) {
            $("#btnEditaLogin").attr("disabled", false);
        }
    });

});


