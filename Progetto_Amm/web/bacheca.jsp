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

                <c:choose>
                   <c:when test="${post.postType == 'TEXT'}">
                       <div id="post1">
                   <div class="fotoProfilo">
                   <img title="fotoProfilo" alt="Foto del Profilo" src="${post.utenteMitt.urlFotoProfilo}">
                   </div>              
                   <h3 class="nameuser">${post.utenteMitt.nome} ${post.utenteMitt.cognome}</h3>            
                   <p>${post.text}</p>
                       </div>
                   </c:when>
                   
                   <c:when test="${post.postType =='IMAGE'}">
                       <div id="post2">
                       <div class="fotoProfilo">
                       <img title="fotoProfilo" alt="Foto del Profilo" src="${post.utenteMitt.urlFotoProfilo}">
                       </div>
                       <h3 class="nameuser">${post.utenteMitt.nome} ${post.utenteMitt.cognome}</h3>            
                       <p>${post.text}</p>   
                       <img src="${post.content}" alt="Foto di gatto" title="Allegato"/>
                       </div>
                       
                   </c:when>
                       
                       <c:when test="${post.postType =='LINK'}">
                         <div id="post3">
                        <div class="fotoProfilo">
                        <img title="fotoProfilo" alt="Foto del Profilo" src="${post.utenteMitt.urlFotoProfilo}">
                        </div>
                        <h3 class="nameuser">${post.utenteMitt.nome} ${post.utenteMitt.cognome}</h3>            
                        <p>${post.text}</p>
                        <a href="${post.content}">${post.content}</a> 
                         </div>
                           
                       </c:when>
                   
                   
            
            </c:choose>   
                
                
            </c:forEach>
            
          
            
        </div>
        
       
    </body>
</html>
