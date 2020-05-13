$(document).ready(function(){
     
   //Ajax para puxar cidades de acordo com estado selecionado  
       var pesquisa = dadosArquivados;
       
       $("#resposta").html(dadosArquivados+"esse é o id");
       
       $.ajax({
          type: "GET",
          url: "GetLugar",
          data: {pesquisa: pesquisa},
          dataType: "json",
            success: function (data, textStatus, jqXHR) {
                $("#resposta").html("");
                console.log(data);
                var nome = data.dados.nome;
                var categoria = data.dados.categoria.nome;
                var estado = data.dados.localizacao.cidade.estado.nome;
                var cidade = data.dados.localizacao.cidade.nome;
                    $("#Nome").append(nome);
                    $("#Categoria").append(categoria);
                    $("#Estado").append(estado);
                    $("#Cidade").append(cidade);
                    console.log(data.dados);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#resposta").html(jqXHR.responseText+"Desculpe.");
            },
            beforeSend: function (xhr) {
                $("#botao").attr("disabled",true);
                $("#cidade").html("Aguarde...")
            },
            complete: function (jqXHR, textStatus) {
                $("#botao").attr("disabled",false);
            }
       });
});


