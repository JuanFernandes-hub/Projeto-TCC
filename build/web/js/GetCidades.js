$(document).ready(function(){
     
   $("#estado").change(function(){
       var pesquisa = $("#estado").val(); //idEstado
       
       $("#resposta").html(pesquisa+"esse é o id");
       
       $.ajax({
          type: "GET",
          url: "Controller",
          data: {pesquisa: pesquisa},
          dataType: "json",
            success: function (data, textStatus, jqXHR) {
                $("#resposta").html("")
                console.log(data);
                $("#cidade").empty();
                for(var i in data.dados){
                    var value = data.dados[i].value;
                    var nome = data.dados[i].nome;
                    var novaOpc = $('<option value='+value+'>'+nome+' </option>');
                    $("#cidade").append(novaOpc);
                    
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#resposta").html(jqXHR.responseText);
            },
            beforeSend: function (xhr) {
                $("#botao").attr("disabled",true);
            },
            complete: function (jqXHR, textStatus) {
                $("#botao").attr("disabled",false);
            }
       });
   });
});
    
   
 
       
       

