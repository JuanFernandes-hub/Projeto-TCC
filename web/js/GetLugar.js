$(document).ready(function () {

    //Ajax para puxar dados do Lugar 
    var pesquisa = dadosArquivados;

    $.ajax({
        type: "GET",
        url: "GetLugar",
        data: {pesquisa: pesquisa},
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            let nome = data.dados.nome;
            let avaliacao = data.dados.avaliacao;
            let categoria = data.dados.categoria.nome;
            let acesso = data.dados.acesso;
            let horaInicial = data.dados.horaInicial;
            let horaFinal = data.dados.horaFinal;
            let descricao = data.dados.descricao;
            let estado = data.dados.localizacao.cidade.estado.nome;
            let cidade = data.dados.localizacao.cidade.nome;
            let bairro = data.dados.localizacao.bairro;
            let rua = data.dados.localizacao.rua;
            let numero = data.dados.localizacao.numero;
            $("#nome").append(nome);
            $("#avaliacao").append(avaliacao);
            $("#acesso").append(acesso);
            $("#horaInicial").append(horaInicial);
            $("#horaFinal").append(horaFinal);
            $("#descricao").append(descricao);
            $("#categoria").append(categoria);
            $("#estado").append(estado);
            $("#cidade").append(cidade);
            $("#bairro").append(bairro);
            $("#rua").append(rua);
            $("#numero").append(numero);
            console.log(data.dados);
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
