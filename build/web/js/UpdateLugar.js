$(document).ready(function () {
    var pesquisa = dadosArquivados; //id do lugar

    try {
        //Esse ajax coloca dados em inputs
        $.ajax({
            type: "GET",
            url: "GetLugar",
            data: {pesquisa: pesquisa},
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                let nome = data.dados.nome;
                let avaliacao = data.dados.avaliacao;
                let categoria = data.dados.categoria.idCategoria;
                let acesso = data.dados.acesso;
                let horaInicial = data.dados.horaInicial;
                let horaFinal = data.dados.horaFinal;
                let descricao = data.dados.descricao;
                let estado = data.dados.localizacao.cidade.estado.idEstado;
                let cidade = data.dados.localizacao.cidade.idCidade;
                let bairro = data.dados.localizacao.bairro;
                let rua = data.dados.localizacao.rua;
                let numero = data.dados.localizacao.numero;
                let complemento = data.dados.localizacao.complemento;
                let idLugar = data.dados.idLugar;
                $("#id").val(idLugar);
                $("#nome").val(nome);
                $("#avaliacao").val(avaliacao);
                $("#acesso").val(acesso);
                $("#horaInicial").val(horaInicial);
                $("#horaFinal").val(horaFinal);
                $("#complemento").val(complemento);
                $("#descricao").val(descricao);
                $("#categoria").val(categoria);
                $("#estado").val(estado);
                $("#cidade").val(cidade);
                $("#bairro").val(bairro);
                $("#rua").val(rua);
                $("#numero").val(numero);
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
    } catch (e) {
        logMyErrors(e);
        alert("Ocorreu algum erro. Desculpe.");
    }
});

