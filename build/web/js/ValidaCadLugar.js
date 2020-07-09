//Valida
function validaForm(form) {
    if (!form.nome.value.trim() || form.nome.value === null || form.nome.value.length < 3 ) {
        alert("Digite o nome do Lugar");
        form.nome.focus();
        return false;
    }
    
    if(!form.categoria.value.trim() || form.categoria.value === null){
     alert("Selecione uma categoria");
     form.categoria.focus();
     return false;
     }
    
    if (!form.descricao.value.trim()) {
        alert("Digite a descrição do lugar");
        form.descricao.focus();
        return false;
    }
    
    if(!form.acesso.value.trim() || form.acesso.value === null){
     alert("Selecione um acesso");
     form.acesso.focus();
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
        $("input").css("border", "2px solid #002028");
    });


    $("#nome").on("blur", function () {
        let nome = $("#nome");
        if (nome.val().length === 0 || !nome.val().trim() || nome.val().length < 3) {
            nome.css("border", "2px solid #F20530");
        } else {
            nome.css("border", "2px solid #002028");
        }
    });
    
    $("#descricao").on("blur", function () {
        let descricao = $("#descricao");
        if (descricao.val().length === 0 || !descricao.val().trim()) {
            descricao.css("border", "2px solid #F20530");
        } else {
            descricao.css("border", "2px solid #002028");
        }
    });

    $("#rua").on("blur", function () {
        let rua = $("#rua");
        if (rua.val().length === 0 || !rua.val().trim() || rua.val().length < 3) {
            rua.css("border", "2px solid #F20530");
        } else {
            rua.css("border", "2px solid #002028");
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

