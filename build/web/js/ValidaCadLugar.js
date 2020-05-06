
function validaForm(form) {
    if (form.nome.value == "" || form.nome.value == null || form.nome.value.length < 3) {
        alert("Digite o nome do Lugar");
        form.nome.focus();
        return false;
    }
}

