$(function(){
    $(".card").css("cursor","pointer");
    
});

function geraPg(e) {
    var id = $(e).attr("id");
    var dados = JSON.stringify(id);
    sessionStorage.setItem('chave', dados);
    window.location.assign("Lugar.jsp");
}

//pegar Id do Login
function updateLogin(e){
    var nameId = $(e).attr("name"); //id do login esta no name
    var dados = JSON.stringify(nameId);
    sessionStorage.setItem('idLogin', dados);
    window.location.assign("UsuarioUpdate.jsp");
}



