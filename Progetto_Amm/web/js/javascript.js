/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(utente){
    var img=$("<img>")
            .attr("title","fotoProfilo")
            .attr("alt","Foto del Profilo")
            .attr("src",utente.urlFotoProfilo);
    
    var link=$("<a>")
            .attr("href","bacheca.html?idAmico=" + utente.id)
            .html(utente.nome + utente.cognome);
    
    var paragrafoLink=$("<p>").append(link);
    
    var div=$("<div>").append(img)
            .append(paragrafoLink)
            .attr("class","fotoProfilo2");
    
    return div;
    
}

function addTitle(){
    return $("<h2>")
            .attr("class","lateraltitle")
            .html("Persone");
    
}

function stateSuccess(data){
    var peopleSection=$("#peoplesection");
    
    $(peopleSection).empty();
    
    $(peopleSection).append(addTitle);
    
    for(var utente in data){
        $(peopleSection).append(createElement(data[utente]));
    }
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#search").input(function(){
        var userSearched= $("#search")[0].value();
        
        $.ajax({
            url: "filter.json",
            data:{
                cmd:"search",
                q:userSearched
            },
            dataType:"json",
            success:function(data,state){
                stateSuccess(data);
            },
            error:function(data,state){
                stateFailure(data,state);
            }
            
            
        });
        
    });
    
});


