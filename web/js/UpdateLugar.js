var idloc; //id da localizacao
$(document).ready(function () {

    //Ajax colocar os dados em inputs
    var pesquisa = dadosArquivados; //id do lugar

    try {
        $.ajax({
            type: "GET",
            url: "GetLugar",
            data: {pesquisa: pesquisa},
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                var nome = data.dados.nome;
                var avaliacao = data.dados.avaliacao;
                var categoria = data.dados.categoria.idCategoria;
                var acesso = data.dados.acesso;
                var horaInicial = data.dados.horaInicial;
                var horaFinal = data.dados.horaFinal;
                var descricao = data.dados.descricao;
                var estado = data.dados.localizacao.cidade.estado.idEstado;
                var cidade = data.dados.localizacao.cidade.idCidade;
                var bairro = data.dados.localizacao.bairro;
                var rua = data.dados.localizacao.rua;
                var numero = data.dados.localizacao.numero;
                idloc = data.dados.localizacao.idLocalizacao;
                $("#nome").val(nome);
                $("#avaliacao").val(avaliacao);
                $("#acesso").val(acesso);
                $("#horaInicial").val(horaInicial);
                $("#horaFinal").val(horaFinal);
                $("#descricao").val(descricao);
                $("#categoria").val(categoria);
                $("#estado").val(estado);
                $("#cidade").val(cidade);
                $("#bairro").val(bairro);
                $("#rua").val(rua);
                $("#numero").val(numero);
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
    } catch (e) {
        logMyErrors(e);
    }


});

function atualizaLugar() {
    
    validaForm()

    let nome = $("#nome").val();
    let avaliacao = $("#avaliacao").val();
    let categoriaId = $("#categoria option:selected").val();
    let categoriaNome = $("#categoria option:selected").text();
    let acesso = $("#acesso").val();
    let horarioInicial = $("#horarioInicial").val();
    let horarioFinal = $("#horarioFinal").val();
    let descricao = $("#descricao").val();
    let estadoId = $("#estado").val();
    let cidadeId = $("#cidade option:selected").val();
    let cidadeNome = $("#cidade option:selected").text();
    let bairro = $("#bairro").val();
    let rua = $("#rua").val();
    let numero = $("#numero").val();
    let idLocalizacao = idloc;

    var pesquisa = dadosArquivados; //id do lugar clicado


    var categoria = {
        idCategoria: categoriaId,
        nome: categoriaNome
    };

    var lugar = {
        idLugar: pesquisa,
        nome: nome,
        avaliacao: avaliacao,
        Categoria: categoria,
        Localizacao: idloc,
        acesso: acesso,
        horaInicial: horarioInicial,
        horaFinal: horarioFinal,
        descricao: descricao
    };

    var cidade = {
        nome: cidadeNome,
        idCidade: cidadeId,
        Estado: estadoId
    };

    var localizacao = {
        idLocalizacao: idLocalizacao,
        Cidade: cidade,
        bairro: bairro,
        rua: rua,
        numero: numero
    };

    console.log(lugar);

    try {
        $.ajax({
            type: "GET",
            url: "UpdateLugar",
            data: {lugar: JSON.stringify(lugar), localizacao: JSON.stringify(localizacao),
                cidade: JSON.stringify(cidade), categoria: JSON.stringify(categoria)
            },
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                //console.log(data);
                var nome = data.dados.nome;
                var avaliacao = data.dados.avaliacao;
                var categoria = data.dados.categoria.nome;
                var acesso = data.dados.acesso;
                var horaInicial = data.dados.horaInicial;
                var horaFinal = data.dados.horaFinal;
                var descricao = data.dados.descricao;
                var estado = data.dados.localizacao.cidade.estado.nome;
                var cidade = data.dados.localizacao.cidade.nome;
                var bairro = data.dados.localizacao.bairro;
                var rua = data.dados.localizacao.rua;
                var numero = data.dados.localizacao.numero;
                $("#nome").val(nome);
                $("#avaliacao").val(avaliacao);
                $("#acesso").val(acesso);
                $("#horaInicial").val(horaInicial);
                $("#horaFinal").val(horaFinal);
                $("#descricao").val(descricao);
                $("#categoria").val(categoria);
                $("#estado").val(estado);
                $("#cidade").val(cidade);
                $("#bairro").val(bairro);
                $("#rua").val(rua);
                $("#numero").val(numero);
                //console.log(data.dados);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                //$("#resposta").html(jqXHR.responseText + "Desculpe.");
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
        console.log(e);
    }

}
;

$("#semHorario").trigger("change");

$("#semHorario").change(function () {
    desabilita($(this).prop("checked"));
});

//Desativar-Ativar campos de horario
function desabilita(state) {
    $("#horaInicial").prop("readonly", state);
    $("#horaFinal").prop("readonly", state);
    let horaInicialCad = $("#horaInicial").val();
    let horaFinalCad = $("#horaIFinal").val();

    if (state) {
        $("#horaInicial").val("00:00");
        $("#horaFinal").val("00:00");

    } else {
        $("#horaInicial").val(horaInicialCad);
        $("#horaFinal").val(horaFinalCad);
    }
}
;


