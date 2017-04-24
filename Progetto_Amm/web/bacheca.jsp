<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook - Bacheca</title>
        <meta charset="UTF-8">
        <meta name="author" content="Edoardo Demuru">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Nerdbook Social Network sogni bacheca personale">
        <meta name="description" content="Bacheca personale utente">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body id="bodyBach">
        
        <c:set var="page" value="0" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <jsp:include page="nav.jsp"/>
        
        
        
        
        <!-- Lista di post-->
        <div id="posts">
            <div class="nameprofile">
                <div class="fotoProfilo">
                 <img title="fotoProfilo" alt="Foto del Profilo" src="${utente.urlFotoProfilo}" >
                </div>
            <h2 class="nameuser">${utente.nome} ${utente.cognome}: ${utente.frasePres}</h2>
            </div>
            
             <div id="creaPost">            
                 <div class="formitem" id="PostText">
                     <textarea rows="2" cols="20" name="frase" id="fraseBach">Testo nuovo Post</textarea>
                 </div>
                 
                 <div class="formitem" id="PostUrl">
                     <input type="url" name="url allegato" id="urlAllegato" value="URL allegato (opzionale)">
                 </div>
                 
                 <div id="options">
                     <div id="optionimage">
                     <input type="radio" name="Tipo di post" id="Immagineradio" value="Immagine">
                     <label for="Immagineradio">Immagine</label>
                     </div>
                     <div id="optionurl">
                     <input type="radio" name="Tipo di post" id="urlradio" value="URL">    
                     <label for="urlradio">URL</label>
                     </div>
                     
                     
                 </div>
                 
                 <button type="submit" name="modifica" id="pubblica">Pubblica post</button>
           
          </div>
            
            <c:forEach var="post" items="${posts}">
                <div id="post1">
                    <div class="fotoProfilo">
                      <img title="fotoProfilo" alt="Foto del Profilo" src="${post.utenteMitt.urlFotoProfilo}">  
                    </div>
                    <h3 class="nameuser">${post.utenteMitt.nome} ${post.utenteMitt.cognome} </h3>
                    <c:choose>
                        <c:when test="${post.TypePost== 'TEXT'}">
                            <p>${post.text}</p>
                        </c:when>
                            
                        <c:when test="${post.TypePost== 'IMAGE'}">
                            <p>${post.text}</p> 
                            <img src="${post.content}" alt="Foto" title="Allegato"/>   
                        </c:when>
                        
                        <c:when test="${post.TypePost== 'LINK'}">
                            <p>${post.text}</p>
                            <a href="${post.content}">${post.content}</a>                              
                        </c:when>   
                    </c:choose>
                    
                </div> 
                
            </c:forEach>
            
          <!--<div id="post1">            
            <div class="fotoProfilo">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png">
            </div>              
            <h3 class="nameuser">Gianluca Massi</h3>
            
            <p>Ehi ciao! Da quanto non ci sentiamo! Vediamoci appena puoi! :)</p>                    
          </div>
        
          <div id="post2">
             <div class="fotoProfilo">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png">
            </div>
            <h3 class="nameuser">Giovanni Puddu</h3>            
            <p>Ehi guarda la foto di questo bellissimo gatto!</p>   
            <img src="../img/djanni1.jpg" alt="Foto di gatto" title="Allegato"/>
          </div>
        
          <div id="post3">
            <div class="fotoProfilo">
            <img title="fotoProfilo" alt="Foto del Profilo" src="../img/user-icon.png">
            </div>
            <h3 class="nameuser">Mauro Poddighe</h3>            
            <p>Ehi guarda questo video di youtube!</p>
            <a href="https://www.youtube.com/watch?v=-OnRxfhbHB4">Video di youtube</a>                    
          </div>-->
            
        </div> 
        
       
    </body>
</html>
