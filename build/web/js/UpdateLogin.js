function editarLogin() {
    
        var id = JSON.parse(sessionStorage.getItem('idLogin'));
        let classe = JSON.parse(sessionStorage.getItem('classeLogin'));

        let usuario = $("#usuario").val();
        let email = $("#email").val();
        let senha = $("#senha").val();
        let nomeClasse = classe;

        let objeto = {
            idUsuario: id,
            usuario: usuario,
            email: email,
            senha: senha,
            classe: null, //Cria objeto Classe no back
        };

        var login = JSON.stringify(objeto);
        if(validaForm($("#formLogin")[0])){
        $.ajax({
            type: "GET",
            url: "UpdateLogin",
            data: {login: login, nomeClasse: nomeClasse},
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                $("#resposta").html("Perfil editado com sucesso!");
                setTimeout(function () {
                    window.location.assign("PerfilUsuario.jsp");
                }, 2000);

            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#resposta").html(jqXHR.responseText + "Desculpe.");
            },
            beforeSend: function (xhr) {
                $("#btnEditaLogin").attr("disabled", true);
            },
            complete: function (jqXHR, textStatus) {
                $("#btnEditaLogin").attr("disabled", false);
            }
        });
    }
}



