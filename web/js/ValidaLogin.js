function validaForm(form) {
    if (!form.usuario.value.trim() || form.usuario.value === null) {
        alert("Digite o usuário");
        form.usuario.focus();
        return false;
    } else if (form.usuario.value.length < 3) {
        alert("O usuário deve ter no minímo 3 caracteres");
        form.usuario.focus();
        return false;
    }

    if (!form.email.value.trim() || form.email.value === null) {
        alert("Digite o email");
        form.email.focus();
        return false;
    } else if (form.email.value.length < 8) {
        alert("Digite um email válido");
        return false;
    }

    if (!form.senha.value.trim() || form.senha.value === null) {
        alert("Digite uma senha");
        form.senha.focus();
        return false;
    } else if (form.senha.value.length < 6) {
        alert("Digite uma senha com no minímo 6 caracteres");
        return false;
    }

    if (!form.senhaConf.value.trim() || form.senhaConf.value === null) {
        alert("Confirme sua senha");
        form.senhaConf.focus();
        return false;
    } else if (form.senhaConf.value != form.senha.value) {
        alert("Sua senha não condiz");
        form.senhaConf.focus();
        return false;
    } else {
        return true;
    }
}

