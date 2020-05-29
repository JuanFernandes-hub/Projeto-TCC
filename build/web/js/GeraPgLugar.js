$(function(){
    $(".card").css("cursor","pointer");
    
});

function geraPg(e) {
    var id = $(e).attr("id");
    var dados = JSON.stringify(id);
    sessionStorage.setItem('chave', dados);
    window.location.assign("newjsp.jsp");
}



