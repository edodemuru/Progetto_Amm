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
                <c:if test="${bachecaGruppo==false}">

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

                </c:if>
                <c:if test="${bachecaGruppo==true}">
                    <div class="nameprofile">
                        <div class="fotoProfilo">
                            <img title="fotoProfilo" alt="Foto del Profilo" src="${gruppo.urlFotoGruppo}" >
                        </div>
                        <h2 class="nameuser">Gruppo di ${gruppo.name} - Amministratore: ${utenteAmministratore.nome} ${utenteAmministratore.cognome}</h2>
                    </div>                    

                </c:if>


                <c:choose>

                    <c:when test="${inserimentoPost==0}">
                        <c:if test="${propriaBacheca==true or amicizia==true or partecipazioneGruppo==true}">
                            <!-- Inserimento di un nuovo Post-->
                            <form action="bacheca.html" method="post" id="creaPost">            
                                <div class="formitem" id="PostText">
                                    <textarea rows="2" cols="20" name="frase" id="fraseBach">Testo nuovo post</textarea>
                                </div>


                                <div class="formitem" id="PostUrl">
                                    <input type="url" name="urlAllegato" id="urlAllegato" value="URL allegato (opzionale)">
                                </div>

                                <div id="options">
                                    <div id="optionimage">
                                        <input type="radio" name="allegato" id="Immagineradio" value="IMAGE">
                                        <label for="Immagineradio">Immagine</label>
                                    </div>
                                    <div id="optionurl">
                                        <input type="radio" name="allegato" id="urlradio" value="LINK">    
                                        <label for="urlradio">URL</label>
                                    </div>

                                    <input type="text" hidden name="idAmico" value="${amico.id}">
                                    <input type="text" hidden name="idGruppo" value="${gruppo.id}">


                                </div>



                                <button type="submit" name="nuovoPost" id="pubblica2">Pubblica post</button>

                            </form>
                        </c:if>

                        <c:if test="${amicizia==false}">
                            <form action="bacheca.html?idAmico=${amico.id}" method="post" id="creaPost">        
                                <button type="submit" name="richiestaAmicizia" id="chiediAmicizia">Chiedi amicizia</button>
                            </form>


                        </c:if>

                        <c:if test="${partecipazioneGruppo==false}">
                            <form action="bacheca.html?idGruppo=${gruppo.id}" method="post" id="creaPost">        
                                <button type="submit" name="richiestaPartecipazione" id="chiediAmicizia">Iscriviti</button>
                            </form>

                        </c:if>


                    </c:when>


                    <c:when test="${inserimentoPost==1}">
                        <!--Riepilogo dati del post-->

                        <c:if test="${bachecaGruppo==false}">
                            <c:choose>
                                <c:when test="${typePost == 'TEXT'}">
                                    <div class="posts">
                                        <div class="fotoProfilo">
                                            <img title="fotoProfilo" alt="Foto del Profilo" src="${utenteMitt.urlFotoProfilo}">
                                        </div>              
                                        <h3 class="nameuser">${utenteMitt.nome} ${utenteMitt.cognome}</h3>            
                                        <p id='textNewPost'>${testoNuovoPost}</p>
                                        <div id="utenteDest">
                                            <p>Pubblicare sulla bacheca di ${utenteDest.nome} ${utenteDest.cognome}?</p>
                                            <form action="bacheca.html" method="post">

                                                <input type="text" hidden name="testoNuovoPost" value="${testoNuovoPost}">
                                                <input type="text" hidden name="content" value="${content}">
                                                <input type="text" hidden name="typePost" value="${typePost}">
                                                <input type="text" hidden name="idAmico" value="${amico.id}">
                                                <input type="text" hidden name="idDestPost" value="${idUtenteDest}">

                                                <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                            </form>
                                        </div>
                                    </div>
                                </c:when>

                                <c:when test="${typePost =='IMAGE'}">
                                    <div class="posts">
                                        <div class="fotoProfilo">
                                            <img title="fotoProfilo" alt="Foto del Profilo" src="${utenteMitt.urlFotoProfilo}">
                                        </div>
                                        <h3 class="nameuser">${utenteMitt.nome} ${utenteMitt.cognome}</h3>            
                                        <p id='textNewPost'>${testoNuovoPost}</p>   
                                        <img src="${content}" alt="Foto" title="Allegato"/>
                                        <div id="utenteDest">
                                            <p>Pubblicare sulla bacheca di ${utenteDest.nome} ${utenteDest.cognome}?</p>
                                            <form action="bacheca.html" method="post">

                                                <input type="text" hidden name="testoNuovoPost" value="${testoNuovoPost}">
                                                <input type="text" hidden name="content" value="${content}">
                                                <input type="text" hidden name="typePost" value="${typePost}">
                                                <input type="text" hidden name="idAmico" value="${amico.id}">
                                                <input type="text" hidden name="idDestPost" value="${idUtenteDest}">

                                                <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                            </form>
                                        </div>
                                    </div>

                                </c:when>

                                <c:when test="${typePost =='LINK'}">
                                    <div class="posts">
                                        <div class="fotoProfilo">
                                            <img title="fotoProfilo" alt="Foto del Profilo" src="${utenteMitt.urlFotoProfilo}">
                                        </div>
                                        <h3 class="nameuser">${utenteMitt.nome} ${utenteMitt.cognome}</h3>            
                                        <p id='textNewPost'>${testoNuovoPost}</p>
                                        <a href="${content}">${content}</a> 
                                        <div id="utenteDest">
                                            <p>Pubblicare sulla bacheca di ${utenteDest.nome} ${utenteDest.cognome}?</p>
                                            <form action="bacheca.html?" method="post">

                                                <input type="text" hidden name="testoNuovoPost" value="${testoNuovoPost}">
                                                <input type="text" hidden name="content" value="${content}">
                                                <input type="text" hidden name="typePost" value="${typePost}">
                                                <input type="text" hidden name="idAmico" value="${amico.id}">
                                                <input type="text" hidden name="idDestPost" value="${idUtenteDest}">

                                                <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                            </form>
                                        </div>
                                    </div>

                                </c:when>

                            </c:choose> 
                        </c:if>

                        <c:if test="${bachecaGruppo==true}">

                            <c:choose>
                                <c:when test="${typePost == 'TEXT'}">
                                    <div class="posts">
                                        <div class="fotoProfilo">
                                            <img title="fotoProfilo" alt="Foto del Profilo" src="${utenteMitt.urlFotoProfilo}">
                                        </div>              
                                        <h3 class="nameuser">${utenteMitt.nome} ${utenteMitt.cognome}</h3>            
                                        <p id='textNewPost'>${testoNuovoPost}</p>
                                        <div id="utenteDest">
                                            <p>Pubblicare sulla bacheca di ${gruppo.name}?</p>
                                            <form action="bacheca.html" method="post">

                                                <input type="text" hidden name="testoNuovoPost" value="${testoNuovoPost}">
                                                <input type="text" hidden name="content" value="${content}">
                                                <input type="text" hidden name="typePost" value="${typePost}">
                                                <input type="text" hidden name="idGruppo" value="${gruppo.id}">


                                                <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                            </form>
                                        </div>
                                    </div>
                                </c:when>

                                <c:when test="${typePost =='IMAGE'}">
                                    <div class="posts">
                                        <div class="fotoProfilo">
                                            <img title="fotoProfilo" alt="Foto del Profilo" src="${utenteMitt.urlFotoProfilo}">
                                        </div>
                                        <h3 class="nameuser">${utenteMitt.nome} ${utenteMitt.cognome}</h3>            
                                        <p id='textNewPost'>${testoNuovoPost}</p>   
                                        <img src="${content}" alt="Foto" title="Allegato"/>
                                        <div id="utenteDest">
                                            <p>Pubblicare sulla bacheca di ${gruppo.name}?</p>
                                            <form action="bacheca.html?idGruppo=${gruppo.id}" method="post">

                                                <input type="text" hidden name="testoNuovoPost" value="${testoNuovoPost}">
                                                <input type="text" hidden name="content" value="${content}">
                                                <input type="text" hidden name="typePost" value="${typePost}">
                                                <input type="text" hidden name="idGruppo" value="${gruppo.id}">


                                                <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                            </form>
                                        </div>
                                    </div>

                                </c:when>

                                <c:when test="${typePost =='LINK'}">
                                    <div class="posts">
                                        <div class="fotoProfilo">
                                            <img title="fotoProfilo" alt="Foto del Profilo" src="${utenteMitt.urlFotoProfilo}">
                                        </div>
                                        <h3 class="nameuser">${utenteMitt.nome} ${utenteMitt.cognome}</h3>            
                                        <p id='textNewPost'>${testoNuovoPost}</p>
                                        <a href="${content}">${content}</a> 
                                        <div id="utenteDest">
                                            <p>Pubblicare sulla bacheca di ${gruppo.name}?</p>
                                            <form action="bacheca.html" method="post">

                                                <input type="text" hidden name="testoNuovoPost" value="${testoNuovoPost}">
                                                <input type="text" hidden name="content" value="${content}">
                                                <input type="text" hidden name="typePost" value="${typePost}">
                                                <input type="text" hidden name="idGruppo" value="${gruppo.id}">


                                                <button type="submit" name="conferma" id="pubblica">Conferma</button>
                                            </form>
                                        </div>
                                    </div>

                                </c:when>

                            </c:choose>

                        </c:if>



                    </c:when>



                    <c:when test="${inserimentoPost== 2}">
                        <!--Conferma pubblicazione post-->
                        <c:if test="${bachecaGruppo==false}">
                            <div class="posts">
                                <p>Hai scritto sulla bacheca di ${utenteDest.nome} ${utenteDest.cognome}</p>
                                <form action="bacheca.html" method="post">
                                    <input type="text" hidden name="idAmico" value="${amico.id}">
                                    <button type="submit" name="conferma2" id="pubblica">Ok!</button>
                                </form>
                            </div>
                        </c:if>


                        <c:if test="${bachecaGruppo==true}">
                            <div class="posts">
                                <p>Hai scritto sul gruppo ${gruppo.name}</p>
                                <form action="bacheca.html" method="post">
                                    <input type="text" hidden name="idGruppo" value="${gruppo.id}">
                                    <button type="submit" name="conferma2" id="pubblica">Ok!</button>
                                </form>
                            </div>
                        </c:if>


                    </c:when>
                </c:choose>

                <c:forEach var="post" items="${posts}">

                    <c:choose>
                        <c:when test="${post.postType == 'TEXT'}">
                            <div class="posts">
                                <c:if test="${amministratore==true}">
                                <form action="bacheca.html" method="post">
                                    <button type="submit" name="amm" id="amm">Cancella</button>
                                </form>
                                </c:if>
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
