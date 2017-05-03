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
        <c:if test="${NonAutorizzato==false}">


            <c:set var="page" value="0" scope="request"/>
            <jsp:include page="header.jsp"/>


            <jsp:include page="nav.jsp"/>
            <!-- Lista di post-->
            <div id="posts">
                <c:if test="${propriaBacheca==true}">
                    <div class="nameprofile">
                        <div class="fotoProfilo">
                            <img title="fotoProfilo" alt="Foto del Profilo" src="${utente.urlFotoProfilo}" >
                        </div>
                        <h2 class="nameuser">${utente.nome} ${utente.cognome}: ${utente.frasePres}</h2>
                    </div>
                </c:if>

                
                    <c:if test="${propriaBacheca==false}">
                        <div class="nameprofile">
                            <div class="fotoProfilo">
                                <img title="fotoProfilo" alt="Foto del Profilo" src="${amico.urlFotoProfilo}" >
                            </div>
                            <h2 class="nameuser">${amico.nome} ${amico.cognome}: ${amico.frasePres}</h2>
                        </div>
                    </c:if>


                <c:choose>
                    <c:when test="${inserimentoPost==0}">
                        <form action="bacheca.html?idUtente=${utente.id}&idAmico=${amico.id}" method="post" id="creaPost">            
                            <div class="formitem" id="PostText">
                                <textarea rows="2" cols="20" name="frase" id="fraseBach">Testo nuovo Post</textarea>
                            </div>


                            <div class="formitem" id="PostUrl">
                                <input type="url" name="urlAllegato" id="urlAllegato" value="URL allegato (opzionale)">
                            </div>

                            <div id="options">
                                <div id="optionimage">
                                    <input type="radio" name="allegato" id="Immagineradio" value="Immagine">
                                    <label for="Immagineradio">Immagine</label>
                                </div>
                                <div id="optionurl">
                                    <input type="radio" name="allegato" id="urlradio" value="URL">    
                                    <label for="urlradio">URL</label>
                                </div>


                            </div>

                            <button type="submit" name="nuovoPost" id="pubblica2">Pubblica post</button>

                        </form>
                    </c:when>

                    
                    <c:when test="${inserimentoPost==1}">

                        <c:choose>
                            <c:when test="${nuovoPost.postType == 'TEXT'}">
                                <div class="posts">
                                    <div class="fotoProfilo">
                                        <img title="fotoProfilo" alt="Foto del Profilo" src="${nuovoPost.utenteMitt.urlFotoProfilo}">
                                    </div>              
                                    <h3 class="nameuser">${nuovoPost.utenteMitt.nome} ${nuovoPost.utenteMitt.cognome}</h3>            
                                    <p id='textNewPost'>${nuovoPost.text}</p>
                                    <div id="utenteDest">
                                        <p>Pubblicare sulla bacheca di ${nuovoPost.utenteDest.nome} ${nuovoPost.utenteDest.cognome}?</p>
                                        <form action="bacheca.html?idUtente=${utente.id}&idAmico=${amico.id}&idDestPost=${nuovoPost.getUtenteDest().getId()}" method="post">
                                            <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                        </form>
                                    </div>
                                </div>
                            </c:when>

                            <c:when test="${nuovoPost.postType =='IMAGE'}">
                                <div class="posts">
                                    <div class="fotoProfilo">
                                        <img title="fotoProfilo" alt="Foto del Profilo" src="${nuovoPost.utenteMitt.urlFotoProfilo}">
                                    </div>
                                    <h3 class="nameuser">${nuovoPost.utenteMitt.nome} ${nuovoPost.utenteMitt.cognome}</h3>            
                                    <p id='textNewPost'>${nuovoPost.text}</p>   
                                    <img src="${nuovoPost.content}" alt="Foto" title="Allegato"/>
                                    <div id="utenteDest">
                                        <p>Pubblicare sulla bacheca di ${nuovoPost.utenteDest.nome} ${nuovoPost.utenteDest.cognome}?</p>
                                        <form action="bacheca.html?idUtente=${utente.id}&idAmico=${amico.id}&idDestPost=${nuovoPost.getUtenteDest().getId()}" method="post">
                                            <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                        </form>
                                    </div>
                                </div>

                            </c:when>

                            <c:when test="${nuovoPost.postType =='LINK'}">
                                <div class="posts">
                                    <div class="fotoProfilo">
                                        <img title="fotoProfilo" alt="Foto del Profilo" src="${nuovoPost.utenteMitt.urlFotoProfilo}">
                                    </div>
                                    <h3 class="nameuser">${nuovoPost.utenteMitt.nome} ${nuovoPost.utenteMitt.cognome}</h3>            
                                    <p id='textNewPost'>${nuovoPost.text}</p>
                                    <a href="${nuovoPost.content}">${nuovoPost.content}</a> 
                                    <div id="utenteDest">
                                        <p>Pubblicare sulla bacheca di ${nuovoPost.utenteDest.nome} ${nuovoPost.utenteDest.cognome}?</p>
                                        <form action="bacheca.html?idUtente=${utente.id}&idAmico=${amico.id}&idDestPost=${nuovoPost.getUtenteDest().getId()}" method="post">
                                            <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                        </form>
                                    </div>
                                </div>

                            </c:when>



                        </c:choose>   


                    </c:when>
                

                
                <c:when test="${inserimentoPost== 2}">
                    <div class="posts">
                        <p>Hai scritto sulla bacheca di ${utenteDest.nome} ${utenteDest.cognome}</p>
                    </div>


                </c:when>
                </c:choose>

                <c:forEach var="post" items="${posts}">

                    <c:choose>
                        <c:when test="${post.postType == 'TEXT'}">
                            <div class="posts">
                                <div class="fotoProfilo">
                                    <img title="fotoProfilo" alt="Foto del Profilo" src="${post.utenteMitt.urlFotoProfilo}">
                                </div>              
                                <h3 class="nameuser">${post.utenteMitt.nome} ${post.utenteMitt.cognome}</h3>            
                                <p>${post.text}</p>
                            </div>
                        </c:when>

                        <c:when test="${post.postType =='IMAGE'}">
                            <div class="posts">
                                <div class="fotoProfilo">
                                    <img title="fotoProfilo" alt="Foto del Profilo" src="${post.utenteMitt.urlFotoProfilo}">
                                </div>
                                <h3 class="nameuser">${post.utenteMitt.nome} ${post.utenteMitt.cognome}</h3>            
                                <p>${post.text}</p>   
                                <img src="${post.content}" alt="Foto di gatto" title="Allegato"/>
                            </div>

                        </c:when>

                        <c:when test="${post.postType =='LINK'}">
                            <div class="posts">
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

        </c:if>
        <c:if test="${NonAutorizzato==true}">
            <h1 id='warning'><strong>Non Autorizzato a visitare questa pagina</strong></h1>

        </c:if>
    </body>
</html>
