//Valida
function validaForm(form) {
    if (!form.nome.value.trim() || form.nome.value === null || form.nome.value.length < 3 ) {
        alert("Digite o nome do Lugar");
        form.nome.focus();
        return false;
    }
    
     if(!form.bairro.value.trim() || form.bairro.value === null || form.bairro.value.length < 3){
     alert("Digite o Bairro");
     form.bairro.focus();
     return false;
     }
     
     if(!form.rua.value.trim() || form.rua.value === null || form.rua.value.length < 3){
     alert("Digite a Rua");
     form.rua.focus();
     return false;
     }
     
     if(!form.estado.value.trim() || form.estado.value === null){
     alert("Selecione um estado");
     form.estado.focus();
     return false;
     }
     
     if(!form.cidade.value.trim() || form.cidade.value === null){
     alert("Selecione uma cidade");
     form.cidade.focus();
     return false;
     }
}

//Verifica na hora e avisa
$(function () {
    $("input").on("click", function () {
        $("input").css("border", "1px solid #CCCCCC");
    });


    $("#nome").on("blur", function () {
        nome = $("#nome");
        if (nome.val().length === 0 || !nome.val().trim() || nome.val().length < 3) {
            nome.css("border", "1px solid red");
        } else {
            nome.css("border", "1px solid #CCCCCC");
        }
    });

    $("#bairro").on("blur", function () {
        bairro = $("#bairro");
        if (bairro.val().length === 0 || !bairro.val().trim() || bairro.val().length < 3) {
            bairro.css("border", "1px solid red");
        } else {
            bairro.css("border", "1px solid #CCCCCC");
        }
    });

    $("#rua").on("blur", function () {
        rua = $("#rua");
        if (rua.val().length === 0 || !rua.val().trim() || rua.val().length < 3) {
            rua.css("border", "1px solid red");
        } else {
            rua.css("border", "1px solid #CCCCCC");
        }
    });

    $("#semHorario").trigger("change");

    $("#semHorario").change(function () {
        desabilita($(this).prop("checked"));
    });

    //Desativar-Ativar campos de horario
    function desabilita(state) {
        $("#horarioInicial").prop("readonly", state);
        $("#horarioFinal").prop("readonly", state);


        if (state) {
            $("#horarioInicial").val("00:00");
            $("#horarioFinal").val("00:00");

        } else {
            $("#horarioInicial").val(null);
            $("#horarioFinal").val(null);
        }
    }



});

