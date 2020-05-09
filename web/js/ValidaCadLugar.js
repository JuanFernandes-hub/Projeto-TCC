
function validaForm(form) {
    if (form.nome.value == "" || form.nome.value == null || form.nome.value.length < 3) {
        alert("Digite o nome do Lugar");
        form.nome.focus();
        return false;
    }


}

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

    $("#numero").on("blur", function () {
        numero = $("#numero");
        if (numero.val().length === 0 || !numero.val().trim()) {
            numero.css("border", "1px solid red");
        } else {
            numero.css("border", "1px solid #CCCCCC");
        }
    });

    //Desativar-Ativar campos de horario
    function setDisabled(state) {
        $("#horarioInicial").prop("disabled", state);
        $("#horarioFinal").prop("disabled", state);

        if (state) {
            $("#horarioInicial").attr("value", "00:00");
            $("#horarioFinal").attr("value", "00:00");
        }
        else{
            $("#horarioInicial").attr("value", null);
            $("#horarioFinal").attr("value", null);
        }
    }

    $("#semHorario").on("click", function () {
        setDisabled($("#semHorario").is(":checked"));
    });



});

