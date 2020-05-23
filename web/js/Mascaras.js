$(function(){
    
    var options = {
        translation:{
           'H': {pattern: /[0-23]/},
           'm': {pattern: /[0-59]/},
        }
    }
    
    $("#horarioInicial").mask('HH:mm',options);
    $("#horarioFinal").mask('HH:mm', options);
    
    
});