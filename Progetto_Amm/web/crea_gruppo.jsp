<%-- 
    Document   : crea_gruppo
    Created on : 24-mag-2017, 12.31.54
    Author     : Edoardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>NerdBook - Creazione gruppo</title>
        <meta charset="UTF-8">
        <meta name="author" content="Edoardo Demuru">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="Nerdbook Social Network sogni gruppo crea">
        <meta name="description" content="Creazione gruppo">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        <c:if test="${NonAutorizzato==false}">
            <c:set var="page" value="0" scope="request"/>
            <jsp:include page="header.jsp"/>

            <div id="contentPage">     
                <jsp:include page="nav.jsp"/>  

                <div id="formProfilo">
                    <img title="fotoProfilo" alt="Foto del Profilo" src="${utente.urlFotoProfilo}" id="Profilepic">
                                       
                    
                    <form action="bacheca.html" method="post" id="Profiloform">
                        <div id="formContent">                  
                            <h3>Crea nuovo gruppo</h3>

                            <div class="formitem" id="firstItem">
                                <label for="nome">Nome gruppo</label>
                                <input type="text" name="nomeGruppo" value="${nomeGruppo}" id="nome">
                            </div>

                            <div class="formitem">
                                <label for="cognome">Interesse</label>
                                <input type="text" name="interesse" value="${interesseGruppo}" id="cognome">
                            </div>

                            <div class="formitem">
                                <label for="url">Url foto gruppo</label>
                                <input type="url" name="url" value="${urlFotoGruppo}" id="url">
                            </div>

                            
                            <button type="submit" name="creaGruppo" id="modifica">Crea gruppo</button>
                        </div>
                    </form>

                </div>
            </div>
        </c:if>
        <c:if test="${NonAutorizzato==true}">
            <h1 id='warning'><strong>Non Autorizzato a visitare questa pagina</strong></h1>

        </c:if>


    </body>
</html>
