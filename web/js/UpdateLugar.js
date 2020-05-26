$(document).ready(function(){
     
   //Ajax para puxar dados do Lugar 
       var pesquisa = dadosArquivados;
       
       $("#resposta").html(dadosArquivados+"esse é o id");
       
       $.ajax({
          type: "GET",
          url: "UpdateLugar",
          data: {pesquisa: pesquisa},
          dataType: "json",
            success: function (data, textStatus, jqXHR) {
                /*
                $("#resposta").html("");
                console.log(data);
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
                    
                    */
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#resposta").html(jqXHR.responseText+"Desculpe.");
            },
            beforeSend: function (xhr) {
                $("#botao").attr("disabled",true);
                //$("#cidade").html("Aguarde...")
            },
            complete: function (jqXHR, textStatus) {
                $("#botao").attr("disabled",false);
            }
       });
});

