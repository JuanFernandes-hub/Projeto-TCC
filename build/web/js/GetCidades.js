$(document).ready(function(){
     
   //Ajax para puxar cidades de acordo com estado selecionado  
   $("#estado").change(function(){
       var pesquisa = $("#estado").val(); //idEstado
       
       $("#resposta").html(pesquisa+"esse é o id");
       
       $.ajax({
          type: "GET",
          url: "Controller",
          data: {pesquisa: pesquisa},
          dataType: "json",
            success: function (data, textStatus, jqXHR) {
                $("#resposta").html("");
                $("#cidade").empty();
                for(var i in data.dados){
                    console.log(data.dados);
                    var nome = data.dados[i].nome;
                    //console.log("dataNome"+nome); //atributo nome da classe Cidade
                    var id = data.dados[i].idCidade; //atributo idCidade da classe Cidade
                    //console.log("dataId"+id);
                    
                    var novaOpc = $('<option name="nCidade" value='+id+'>'+nome+' </option>');
                    $("#cidade").append(novaOpc);
                    //console.log("NovaOpcVal: "+novaOpc.val());
                    
                }
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
});
    
   
 
       
       

