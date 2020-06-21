$(function(){
    
    var options = {
        translation:{
           'H': {pattern: /[0-2]/},
           'm': {pattern: /[0-6]/}
        }
    };
    
    $("#horarioInicial").mask('H9:m9',options);
    $("#horarioFinal").mask('H9:m9',options);
    
    
});